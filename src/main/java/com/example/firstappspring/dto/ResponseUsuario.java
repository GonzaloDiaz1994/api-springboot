package com.example.firstappspring.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class ResponseUsuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String fotoPerfil;

}
