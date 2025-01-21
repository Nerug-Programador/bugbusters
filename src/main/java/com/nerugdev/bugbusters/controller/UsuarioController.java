package com.nerugdev.bugbusters.controller;

import com.nerugdev.bugbusters.topico.DatosTopicos;
import com.nerugdev.bugbusters.topico.Topico;
import com.nerugdev.bugbusters.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/topico")
public class UsuarioController {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    // El método de registro no necesita recibir la fecha
    @PostMapping
    public ResponseEntity<?> RegistroUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        // Crear un nuevo objeto Usuario a partir de los datos recibidos
        Usuario usuario = new Usuario(datosRegistroUsuario);
        usuario.setActivo(true);

        // Guardar el usuario en la base de datos
        Usuario usuarioGuardado = iUsuarioRepository.save(usuario);

        // Crear un DTO o una respuesta personalizada para devolver solo los datos necesarios
        DatosRespuestaUsuario respuestaUsuario = new DatosRespuestaUsuario(
                usuarioGuardado.getId(),
                usuarioGuardado.getNombre(),
                usuarioGuardado.getEmail(),
                usuarioGuardado.getStack().toString(),
                usuarioGuardado.getTopico().getTitulo(),  // Asumiendo que 'topico' no es nulo
                usuarioGuardado.getTopico().getMensaje()  // Asumiendo que 'topico' no es nulo
        );

        // Retornar el ResponseEntity con status 200 y la respuesta del usuario
        return ResponseEntity.created(URI.create("/usuarios/" + usuarioGuardado.getId())).body(respuestaUsuario);
    }


    @GetMapping
    public Page<DatosListadoUsuario> listadoUsuarios(@PageableDefault(size = 5) Pageable paginacion) {
        // Llamamos al método findByActivoTrue que ya está paginado
        return iUsuarioRepository.findByActivoTrue(paginacion).map(DatosListadoUsuario::new);
    }

    // Método para actualizar solo los campos enviados
    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable Long id, @RequestBody DatosActualizarUsuario datosActualizarUsuario) {
        // Buscar el usuario por su ID
        Usuario usuario = iUsuarioRepository.getReferenceById(id);

        // Verificar si el campo stack fue enviado y actualizarlo
        if (datosActualizarUsuario.stack() != null) {
            usuario.setStack(datosActualizarUsuario.stack());
        }

        // Verificar si el campo topico fue enviado
        if (datosActualizarUsuario.topico() != null) {
            Topico topico = usuario.getTopico();

            // Si el topico es null, creamos uno nuevo
            if (topico == null) {
                topico = new Topico();
                usuario.setTopico(topico);
            }

            // Actualizamos solo los campos de topico que fueron enviados
            if (datosActualizarUsuario.topico().titulo() != null) {
                topico.setTitulo(datosActualizarUsuario.topico().titulo());
            }

            if (datosActualizarUsuario.topico().mensaje() != null) {
                topico.setMensaje(datosActualizarUsuario.topico().mensaje());
            }
        }

        // Actualizar la fecha con la fecha y hora actuales
        usuario.setFecha(LocalDateTime.now());

        // Guardar el usuario con los cambios
        iUsuarioRepository.save(usuario);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity desactivarUsuario(@PathVariable Long id) {
        // Obtener el usuario por su id
        Usuario usuario = iUsuarioRepository.getReferenceById(id);

        // Actualizar la columna 'activo' a false (desactivar el usuario)
        usuario.setActivo(false);  // Asegúrate de tener un método `setActivo` en la clase `Usuario`

        // Guardar el usuario con el nuevo estado
        iUsuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }

}
