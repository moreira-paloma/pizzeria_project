package de.com.pizzeria.projectpizzeria.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UserDetails carregarUsuarioPorUsername(String username){
        return repository.findByLogin(username);
    }


}
