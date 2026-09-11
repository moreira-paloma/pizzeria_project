package de.com.pizzeria.projectpizzeria.user;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
