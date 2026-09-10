package de.com.pizzeria.projectpizzeria.pizza;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;


@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public ResponseEntity<PizzaDTO> cadastrar(@Valid @RequestBody PizzaDTO pizzaDto, UriComponentsBuilder uriComponent){
        PizzaDTO pizzaCriada = pizzaService.criarPizza(pizzaDto);
        URI endereco = uriComponent.path("/pizzas/{id}").buildAndExpand(pizzaCriada.getId()).toUri(); //quem tem id eh pizzaCriada
        return ResponseEntity.created(endereco).body(pizzaCriada);

    }

    @GetMapping
    public ResponseEntity<Page<PizzaDTO>> buscarTodos(@PageableDefault(size = 10)Pageable paginacao){
        Page<PizzaDTO> pizzas = pizzaService.buscarTodos(paginacao);
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> buscarPorId(@PathVariable Long id){
        PizzaDTO pizzaEncontrada = pizzaService.buscarPorId(id);
        return ResponseEntity.ok(pizzaEncontrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PizzaDTO pizzaDto){
      PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id,pizzaDto);
       return ResponseEntity.ok(pizzaAtualizada); // pode ser colocado a linha 38 dentro de onde esta o pizzaAtualizada.
    }
    @PatchMapping("/{id}")
    public ResponseEntity<PizzaDTO> atualizarParcial(
            @PathVariable Long id,
            @RequestBody PizzaDTO dto) {

        PizzaDTO atualizado = pizzaService.atualizarParcial(id, dto);
        return ResponseEntity.ok(atualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pizzaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
