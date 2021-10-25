package com.example.firstappspring.service;

import com.example.firstappspring.exception.UsuarioYaRegistrado;
import com.example.firstappspring.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUsuarioService {

    @Autowired
    private UsuarioService usuarioService;


    @Test
    public void registroDeUsuarioIncompleto() {
        Usuario usuario = new Usuario("Akira", "Diaz", "1155617310", "",
                "akira@gmail.com", "456", "akira");
        try {
            usuarioService.registrar(usuario);
        }catch (UsuarioYaRegistrado e){
            e.getMessage();
        }
    }
}
