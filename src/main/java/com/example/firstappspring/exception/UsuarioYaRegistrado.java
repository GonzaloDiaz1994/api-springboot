package com.example.firstappspring.exception;

public class UsuarioYaRegistrado extends Exception{

    public UsuarioYaRegistrado(){
        super("Este usuario o email ya está registrado");
    }
}
