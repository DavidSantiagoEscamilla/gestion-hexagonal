package com.unicartagena.gestion.infrastructure.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA de Empleo (infraestructura).
 */
@Entity
@Table(name = "empleos")
public class EmpleoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String categoria;

    @Column(name = "area_trabajo", nullable = false)
    private String areaTrabajo;

    @Column(nullable = false)
    private String empresa;

    @Column(nullable = false)
    private String nivel;

    @Column(nullable = false)
    private Double sueldo;

    @Column(columnDefinition = "TEXT")
    private String funciones;

    @Column(name = "cargo_jefe", nullable = false)
    private String cargoJefe;

    public EmpleoEntity() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getAreaTrabajo() { return areaTrabajo; }
    public void setAreaTrabajo(String areaTrabajo) { this.areaTrabajo = areaTrabajo; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public Double getSueldo() { return sueldo; }
    public void setSueldo(Double sueldo) { this.sueldo = sueldo; }

    public String getFunciones() { return funciones; }
    public void setFunciones(String funciones) { this.funciones = funciones; }

    public String getCargoJefe() { return cargoJefe; }
    public void setCargoJefe(String cargoJefe) { this.cargoJefe = cargoJefe; }
}
