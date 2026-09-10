package de.com.pizzeria.projectpizzeria.pizza;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
       PizzaModel pizzaSalva = repository.save(pizzaModel);
       PizzaDTO pizzaCriada = modelMapper.map(pizzaSalva,PizzaDTO.class);
        return pizzaCriada;

    }
    //pesquisar
    public Page<PizzaDTO> buscarTodos(Pageable paginacao){
        return repository.findAll(paginacao).map(pizzaModel ->
                modelMapper.map(pizzaModel,PizzaDTO.class));

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

    public PizzaDTO atualizarParcial(Long id, PizzaDTO dto) {

        PizzaModel pizza = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pizza não encontrada"));

        if (dto.getNome() != null) {
            pizza.setNome(dto.getNome());
        }
        if (dto.getTamanho() != null) {
            pizza.setTamanho(dto.getTamanho());
        }
        if (dto.getPreco() != null) {
            pizza.setPreco(dto.getPreco());
        }
        if (dto.getSabor() != null) {
            pizza.setSabor(dto.getSabor());
        }

        PizzaModel salvo = repository.save(pizza);
        return modelMapper.map(salvo, PizzaDTO.class);
    }

}

