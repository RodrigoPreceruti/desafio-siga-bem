package com.example.desafio_sigabem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioSigabemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioSigabemApplication.class, args);
    }

}
