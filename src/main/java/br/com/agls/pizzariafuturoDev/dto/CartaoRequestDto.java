package br.com.agls.pizzariafuturoDev.dto;

import br.com.agls.pizzariafuturoDev.entity.TipoCartao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CartaoRequestDto {

    @Size(max = 16)
    private String numero;

    @NotNull
    private TipoCartao tipoCartao;

    @NotNull
    private LocalDate validade;

    @PositiveOrZero
    private Double limite;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoCartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
}
