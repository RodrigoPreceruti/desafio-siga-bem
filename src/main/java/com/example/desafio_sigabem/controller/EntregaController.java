package com.example.desafio_sigabem.controller;

import com.example.desafio_sigabem.entity.Entrega;
import com.example.desafio_sigabem.entity.SimulacaoEntregaRequest;
import com.example.desafio_sigabem.entity.SimulacaoEntregaResponse;
import com.example.desafio_sigabem.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
    @Autowired
    private EntregaService service;

    @GetMapping
    public ResponseEntity<List<Entrega>> listarEntregas() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listarEntregas());
    }

    @PostMapping
    public ResponseEntity<SimulacaoEntregaResponse> simularEntrega(@RequestBody SimulacaoEntregaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.criarEntrega(request));
    }
}
