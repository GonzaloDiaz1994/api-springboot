package com.example.firstappspring.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResponseUsuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String fotoPerfil;

}
