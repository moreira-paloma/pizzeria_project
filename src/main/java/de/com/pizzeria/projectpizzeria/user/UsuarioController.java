package de.com.pizzeria.projectpizzeria.user;

import de.com.pizzeria.projectpizzeria.pizza.PizzaDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO,UriComponentsBuilder uriComponentsBuilder) {
       UsuarioDTO usuarioCriado = usuarioService.criarUsuario(usuarioDTO);
        URI endereco = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuarioCriado.getId()).toUri();
        return ResponseEntity.created(endereco).body(usuarioCriado);

    }

}

