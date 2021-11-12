package com.example.firstappspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @Column(name = "rol_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rol_id;
    @Column(name = "nombre_rol", nullable = false)
    private String nombre;

    public Rol(String nombre){
        this.nombre = nombre;
    }
}
