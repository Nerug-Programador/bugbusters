package com.nerugdev.bugbusters.topico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    private String titulo;
    private String mensaje;

    // Constructor que recibe DatosTopicos
    public Topico(DatosTopicos topico) {
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
    }

    // Método para actualizar los datos de Topico
    public Topico actualizarDatos(Topico nuevoTopico) {
        this.titulo = nuevoTopico.getTitulo();  // Accedemos a los atributos correctamente
        this.mensaje = nuevoTopico.getMensaje(); // Accedemos a los atributos correctamente
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTitulo() {
        return titulo;
    }
}
