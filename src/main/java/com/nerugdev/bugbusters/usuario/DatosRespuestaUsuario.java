package com.nerugdev.bugbusters.usuario;

public class DatosRespuestaUsuario {

    private Long id;
    private String nombre;
    private String email;
    private String stack;
    private String titulo;
    private String mensaje;

    // Constructor
    public DatosRespuestaUsuario(Long id, String nombre, String email, String stack, String titulo, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.stack = stack;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    // Getters and Setters (si es necesario)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
