package com.example.firstappspring.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@Getter @Setter
public class Usuario {

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;
    @Column(name = "foto_perfil")
    private String fotoPerfil;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    public Usuario(String nombre, String apellido, String telefono, String foto_perfil, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fotoPerfil = foto_perfil;
        this.email = email;
        this.password = password;
    }
}
