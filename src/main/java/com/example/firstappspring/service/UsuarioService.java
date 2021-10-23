package com.example.firstappspring.service;

import com.example.firstappspring.model.Usuario;
import com.example.firstappspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public String registrar(String nombre, String apellido, String telefono, String fotoPerfil, String email,
                            String nombreUsuario, String password) {

        return null;
    }

    @Override
    public String iniciarSesion(String nombre_usuario, String password) {
        return null;
    }
}
