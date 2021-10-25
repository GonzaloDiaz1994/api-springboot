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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "foto_perfil")
    private String fotoPerfil;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    public Usuario(String nombre, String apellido, String telefono, String foto_perfil, String email, String password,
                   String nombre_usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fotoPerfil = foto_perfil;
        this.email = email;
        this.password = password;
        this.nombreUsuario = nombre_usuario;
    }
}
