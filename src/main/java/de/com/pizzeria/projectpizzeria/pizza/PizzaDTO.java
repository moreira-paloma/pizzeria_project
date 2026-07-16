package de.com.pizzeria.projectpizzeria.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PizzaDTO {

    @NotBlank
    private String nome;
    private SaborEnum sabor;
    private TamanhoEnum tamanho;
    @NotNull
    @Positive
    private Double preco;
    @NotNull
    private Boolean disponivel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SaborEnum getSabor() {
        return sabor;
    }

    public void setSabor(SaborEnum sabor) {
        this.sabor = sabor;
    }

    public TamanhoEnum getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoEnum tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
