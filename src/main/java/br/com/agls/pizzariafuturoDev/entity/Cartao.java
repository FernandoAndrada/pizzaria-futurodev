package br.com.agls.pizzariafuturoDev.entity;

// Numero (max 16) // Validade LocalDate // Limite // Limite Utilizado// Saldo

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(length = 16)
    @Size(max = 16)
    private String numero;

    @NotNull
    private LocalDate validade;

    @PositiveOrZero
    private Double limite;

    private Double limiteUtilizado;

    private Double saldo;

}


