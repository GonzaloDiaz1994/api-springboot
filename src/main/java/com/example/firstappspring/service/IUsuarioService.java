package com.example.firstappspring.service;

import com.example.firstappspring.dto.RequestInicioSesion;
import com.example.firstappspring.dto.ResponseUsuario;
import com.example.firstappspring.exception.UsuarioYaRegistrado;
import com.example.firstappspring.model.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioService {

    String registrar(Usuario usuario) throws UsuarioYaRegistrado;
    ResponseUsuario buscarPorEmail(String email);
    ResponseUsuario buscarPorId(Long id);
    void eliminarTodo();
    ResponseUsuario iniciarSesion(RequestInicioSesion requestInicioSesion);
    List<Usuario> todosLosUsuarios();
}
