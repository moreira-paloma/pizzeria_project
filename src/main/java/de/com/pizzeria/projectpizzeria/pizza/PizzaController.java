package de.com.pizzeria.projectpizzeria.pizza;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService service, PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public void cadastrar(@Valid @RequestBody PizzaDTO pizzaDto){
        pizzaService.criarPizza(pizzaDto);
    }

    @GetMapping
    public List<PizzaDTO> buscarTodos(){
        return pizzaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public PizzaDTO buscarPorId(@PathVariable Long id){
        return pizzaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PizzaDTO atualizar(@PathVariable Long id, @Valid @RequestBody PizzaDTO pizzaDto){
        PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id,pizzaDto);
        return pizzaAtualizada;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        pizzaService.deletar(id);
    }
}
