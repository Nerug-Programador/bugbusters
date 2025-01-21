package com.nerugdev.bugbusters.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje) {

}
