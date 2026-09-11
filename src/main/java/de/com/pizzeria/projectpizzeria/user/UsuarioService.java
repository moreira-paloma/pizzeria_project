package de.com.pizzeria.projectpizzeria.user;

import de.com.pizzeria.projectpizzeria.pizza.PizzaDTO;
import de.com.pizzeria.projectpizzeria.pizza.PizzaModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) repository.findByLogin(username).orElseThrow(() ->
                new UsernameNotFoundException(
                        "Usuário não encontrado"
                )
        );
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = modelMapper.map(usuarioDTO,UsuarioModel.class);
        UsuarioModel usuarioSalvo = repository.save(usuarioModel);
        UsuarioDTO usuarioCriado = modelMapper.map(usuarioSalvo,UsuarioDTO.class);
        return usuarioCriado;

    }
}
