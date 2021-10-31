package com.example.firstappspring.exception;

public class CredencialesInicioSesionInvalidas extends RuntimeException{

    @Override
    public String getMessage() {
        return "Usuario y/o contraseña inválidos";
    }
}
