package com.example.desafio_sigabem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SimulacaoEntregaResponse(
        BigDecimal vlTotalFrete,
        LocalDate dataPrevistaEntrega,
        String cepOrigem,
        String cepDestino
) {
}
