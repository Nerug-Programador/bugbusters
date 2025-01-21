package com.nerugdev.bugbusters.usuario;

import com.nerugdev.bugbusters.topico.DatosTopicos;
import com.nerugdev.bugbusters.topico.Topico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull
        Long id,
        String nombre,
        Stack stack,
        DatosTopicos topico
) {
}
