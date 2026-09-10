package de.com.pizzeria.projectpizzeria.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {

   public UserDetails findByLogin(String login);
}
