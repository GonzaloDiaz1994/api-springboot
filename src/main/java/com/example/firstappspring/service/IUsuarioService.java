package com.example.firstappspring.service;

import com.example.firstappspring.model.Usuario;

public interface IUsuarioService {

    public String registrar(String nombre, String apellido, String telefono, String fotoPerfil, String email,
                            String nombreUsuario, String password);
    public String iniciarSesion(String nombre_usuario, String password);
}
