package com.example.firstappspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestInicioSesion {

    private String nombreUsuario_email;
    private String password;

}
