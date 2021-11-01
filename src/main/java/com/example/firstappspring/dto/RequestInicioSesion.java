package com.example.firstappspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class RequestInicioSesion {

    private String email;
    private String password;

}
