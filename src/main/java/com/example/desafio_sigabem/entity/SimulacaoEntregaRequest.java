package com.example.desafio_sigabem.entity;

import java.math.BigDecimal;

public record SimulacaoEntregaRequest(
        BigDecimal peso,
        String cepOrigem,
        String cepDestino,
        String nomeDestinatario
) {
}
