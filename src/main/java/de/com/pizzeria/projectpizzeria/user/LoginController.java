package de.com.pizzeria.projectpizzeria.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager autenticador;

    public LoginController(AuthenticationManager autenticador) {
        this.autenticador = autenticador;
    }

    @PostMapping
    public ResponseEntity<?> validacaoUsuarios(@RequestBody @Valid UsuarioDTO usuarioDTO){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuarioDTO.getLogin(),usuarioDTO.getSenha());
        Authentication autenticacao = autenticador.authenticate(token);
        return ResponseEntity.ok().build();

    }
}
