package com.nerugdev.bugbusters.usuario;

import com.nerugdev.bugbusters.topico.DatosTopicos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Pattern(regexp = "\\d{4,12}")
        String documento,
        @Email
        String email,
        @NotBlank
        String password,
        @NotNull
        Stack stack,
        @NotNull
        @Valid
        DatosTopicos topico) {

}
