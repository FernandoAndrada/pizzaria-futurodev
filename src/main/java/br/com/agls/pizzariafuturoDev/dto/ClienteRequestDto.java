package br.com.agls.pizzariafuturoDev.dto;

import br.com.agls.pizzariafuturoDev.entity.Cliente;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteRequestDto {
    @NotNull
    private String nome;

    private List<CartaoRequestDto> cartoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CartaoRequestDto> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoRequestDto> cartoes) {
        this.cartoes = cartoes;
    }
}
