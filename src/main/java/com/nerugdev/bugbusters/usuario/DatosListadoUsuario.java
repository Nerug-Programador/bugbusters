package com.nerugdev.bugbusters.usuario;

import com.nerugdev.bugbusters.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        Stack stack,
        Topico topico,
        LocalDateTime fecha
) {
    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getStack(), usuario.getTopico(), usuario.getFecha());
    }
}
