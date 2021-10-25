package com.example.firstappspring.service;

import com.example.firstappspring.exception.UsuarioYaRegistrado;
import com.example.firstappspring.model.Usuario;
import com.example.firstappspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public String registrar(Usuario usuario) throws UsuarioYaRegistrado {
        if (usuarioRepository.existeElUsuario(usuario)){
            throw new UsuarioYaRegistrado();
        }else{
            usuarioRepository.registrar(usuario);
            return "Registro exitoso";
        }
    }

    @Override
    public String iniciarSesion(String nombre_usuario, String password) {
        return null;
    }
}
