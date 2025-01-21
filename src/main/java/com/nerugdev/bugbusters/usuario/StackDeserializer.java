package com.nerugdev.bugbusters.usuario;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class StackDeserializer extends JsonDeserializer<Stack> {

    @Override
    public Stack deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Obtener el valor como String y convertirlo a mayúsculas
        String value = p.getText().toUpperCase();

        // Mapear el valor convertido a un valor del Enum Stack
        return Stack.valueOf(value);
    }
}
