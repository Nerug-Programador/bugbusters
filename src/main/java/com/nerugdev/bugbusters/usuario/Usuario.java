package com.nerugdev.bugbusters.usuario;

import com.nerugdev.bugbusters.topico.DatosTopicos;
import com.nerugdev.bugbusters.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String email;
    private String documento;
    private String password;

    @Enumerated(EnumType.STRING)
    private Stack stack;

    @Embedded
    private Topico topico;
    @Column(nullable = false)
    private Boolean activo;

    // Aquí está la propiedad correcta para almacenar la fecha y hora
    private LocalDateTime fecha;

    // Constructor para crear Usuario a partir de DatosRegistroUsuario
    public Usuario(DatosRegistroUsuario datosRegistroUsuario){
        this.nombre = datosRegistroUsuario.nombre();
        this.email = datosRegistroUsuario.email();
        this.documento = datosRegistroUsuario.documento();
        this.password = datosRegistroUsuario.password();
        this.stack = datosRegistroUsuario.stack();
        this.topico = new Topico(datosRegistroUsuario.topico());

        // Generar automáticamente la fecha cuando el usuario es creado
        this.fecha = LocalDateTime.now();  // Asignar la fecha actual
    }

    // Método para actualizar la columna activo
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    // Método para obtener el valor de activo
    public Boolean getActivo() {
        return activo;
    }

    // Método para actualizar los datos del usuario
    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        this.nombre = datosActualizarUsuario.nombre();
        this.stack = datosActualizarUsuario.stack();

        // Aquí debes asegurarte de usar DatosTopicos y no Topico directamente
        DatosTopicos datosTopicos = datosActualizarUsuario.topico();
        this.topico = this.topico.actualizarDatos(new Topico(datosTopicos));
    }
}
