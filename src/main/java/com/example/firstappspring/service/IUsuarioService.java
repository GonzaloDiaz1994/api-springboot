package com.example.firstappspring.service;

import com.example.firstappspring.exception.UsuarioYaRegistrado;
import com.example.firstappspring.model.Usuario;

public interface IUsuarioService {

    String registrar(Usuario usuario) throws UsuarioYaRegistrado;

    public String iniciarSesion(String nombre_usuario, String password);
}
