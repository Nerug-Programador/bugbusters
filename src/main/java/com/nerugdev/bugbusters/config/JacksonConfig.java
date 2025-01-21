package com.nerugdev.bugbusters.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Registrar el módulo para manejo de Java 8 DateTime
        objectMapper.registerModule(new JavaTimeModule());

        // Configurar para que las fechas sean serializadas en el formato ISO 8601
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // No usar timestamps (milisegundos)

        return objectMapper;
    }
}