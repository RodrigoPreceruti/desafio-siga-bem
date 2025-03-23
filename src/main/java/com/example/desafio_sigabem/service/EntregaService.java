package com.example.desafio_sigabem.service;

import com.example.desafio_sigabem.client.ViaCepApiResponse;
import com.example.desafio_sigabem.client.ViaCepClient;
import com.example.desafio_sigabem.entity.Entrega;
import com.example.desafio_sigabem.entity.SimulacaoEntregaRequest;
import com.example.desafio_sigabem.entity.SimulacaoEntregaResponse;
import com.example.desafio_sigabem.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository repository;

    @Autowired
    private ViaCepClient viaCepClient;

    public List<Entrega> listarEntregas() {
        return this.repository.findAll();
    }

    public SimulacaoEntregaResponse criarEntrega(SimulacaoEntregaRequest request) {
        Entrega entrega = new Entrega(request);
        BigDecimal frete = this.calcularFreteComDesconto(request, entrega);

        entrega.setVlTotalFrete(frete);

        this.repository.save(entrega);

        return new SimulacaoEntregaResponse(entrega);

    }

    public BigDecimal calcularFreteComDesconto(SimulacaoEntregaRequest request, Entrega entrega) {
        ViaCepApiResponse consultaCepOrigem = this.viaCepClient.consultarCep(request.cepOrigem());
        ViaCepApiResponse consultaCepDestino = this.viaCepClient.consultarCep(request.cepDestino());

        if (consultaCepOrigem.ddd().equals(consultaCepDestino.ddd())) {
            entrega.setDataPrevistaEntrega(LocalDate.now().plusDays(1));

            return BigDecimal.valueOf(request.peso() - request.peso() * 0.50);
        }

        if (consultaCepOrigem.estado().equals(consultaCepDestino.estado())) {
            entrega.setDataPrevistaEntrega(LocalDate.now().plusDays(3));

            return BigDecimal.valueOf(request.peso() - request.peso() * 0.75);
        }

        entrega.setDataPrevistaEntrega(LocalDate.now().plusDays(10));

        return BigDecimal.valueOf(request.peso());
    }
}

