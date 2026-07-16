package de.com.pizzeria.projectpizzeria.pizza;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository repository;
    private final ModelMapper modelMapper; // ele é o tradutor do dto

    public PizzaService(PizzaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    //revisar, jogar no gpt.
    public PizzaDTO criarPizza(PizzaDTO pizzaDto){
       PizzaModel pizzaModel = modelMapper.map(pizzaDto,PizzaModel.class);
        repository.save(pizzaModel);
        return modelMapper.map(pizzaModel,PizzaDTO.class);

    }
    //pesquisar
    public List<PizzaDTO> buscarTodos(){
        return repository.findAll()
                .stream(). //pegar a lista de entidades e colocar no fluxo com o stream.
                map(pizzaModel -> modelMapper.map(pizzaModel,PizzaDTO.class))
                .toList();
    }

    public PizzaDTO buscarPorId(Long id){
        PizzaModel pizzaModel = repository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        return modelMapper.map(pizzaModel,PizzaDTO.class);
    }
//return modelMapper.map(repository.findById(id)
    // .orElseThrow(() -> new EntityNotFoundException()), PizzaDTO.class);

    public PizzaDTO atualizarPizza(Long id, PizzaDTO pizzaDTO){
        PizzaModel pizzaModel = modelMapper.map(pizzaDTO, PizzaModel.class);
        pizzaModel.setId(id);
        repository.save(pizzaModel);
        return modelMapper.map(pizzaModel,PizzaDTO.class);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}

