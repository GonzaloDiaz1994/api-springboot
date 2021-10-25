package com.example.firstappspring.service;

import com.example.firstappspring.dto.RequestInicioSesion;
import com.example.firstappspring.model.Usuario;
import com.example.firstappspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public String registrar(Usuario usuario) throws DataIntegrityViolationException {
        return usuarioRepository.registrar(usuario);
    }

    @Override
    public String iniciarSesion(RequestInicioSesion requestInicioSesion) {
        return null;
    }
}
