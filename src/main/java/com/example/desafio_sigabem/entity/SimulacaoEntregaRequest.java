package com.example.desafio_sigabem.entity;

public record SimulacaoEntregaRequest(
        Double peso,
        String cepOrigem,
        String cepDestino,
        String nomeDestinatario
) {
}
