package com.unicartagena.gestion.domain.model;

/**
 * Modelo de dominio Usuario. POJO puro, sin anotaciones de framework.
 * Representa el nucleo del negocio (capa de dominio en arquitectura hexagonal).
 * Campos basados en las guias: cedula, clave, nombre, email.
 */
public class Usuario {

    private String cedula;
    private String clave;
    private String nombre;
    private String email;

    public Usuario() {
    }

    public Usuario(String cedula, String clave, String nombre, String email) {
        this.cedula = cedula;
        this.clave = clave;
        this.nombre = nombre;
        this.email = email;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
