package br.com.agls.pizzariafuturoDev.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public enum TipoCartao {


    DEBITO("Débito"),
    CREDITO("Crédito");

    private String tipoCartao;

    private TipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}


