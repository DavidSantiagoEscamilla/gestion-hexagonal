package com.unicartagena.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la API RESTful con arquitectura Hexagonal.
 */
@SpringBootApplication
public class GestionHexagonalApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionHexagonalApplication.class, args);
    }
}
