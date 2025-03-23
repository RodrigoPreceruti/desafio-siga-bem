package com.example.desafio_sigabem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal peso;

    private String cepOrigem;

    private String cepDestino;

    private String nomeDestinatario;

    private BigDecimal vlTotalFrete;

    private LocalDate dataPrevistaEntrega;
}
