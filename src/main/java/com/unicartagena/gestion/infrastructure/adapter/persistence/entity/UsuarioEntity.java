package com.unicartagena.gestion.infrastructure.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA de Usuario. Pertenece a la INFRAESTRUCTURA.
 * Se mantiene separada del modelo de dominio para no acoplar el nucleo a JPA.
 */
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String email;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String cedula, String clave, String nombre, String email) {
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
