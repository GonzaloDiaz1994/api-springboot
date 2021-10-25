package com.example.firstappspring.repository;

import com.example.firstappspring.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUsuarioRepository {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Test
    public void registroDeUsuarioExitoso(){
        Usuario usuario = new Usuario("Gonzalo", "Diaz", "1155617310", "",
                "gonzalo@gmail.com", "456", "gonza");
        String msg = usuarioRepository.registrar(usuario);
    }


}
