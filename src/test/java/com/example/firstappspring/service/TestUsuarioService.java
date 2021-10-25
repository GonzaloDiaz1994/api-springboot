package com.example.firstappspring.service;

import com.example.firstappspring.model.Usuario;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class TestUsuarioService {

    @Autowired
    private UsuarioService usuarioService;


    @Test
    public void registroDeUsuarioIncompleto() {
        Usuario usuario = new Usuario("Tom", "Diaz", "1155617310", "",
                "akira@gmail.com", "456", "akira");
        try {
            usuarioService.registrar(usuario);
        }catch (DataIntegrityViolationException e){
            e.getMessage();
        }
    }
}
