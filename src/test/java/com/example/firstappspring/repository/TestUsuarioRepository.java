package com.example.firstappspring.repository;

import com.example.firstappspring.model.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

@SpringBootTest
public class TestUsuarioRepository {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach()
    public void limpiarTablaUsuario(){
        usuarioRepository.eliminarTodo();
    }

    @Test
    public void registroDeUsuarioExitoso(){
        Usuario usuario = new Usuario("Gonzalo", "Diaz", "1155617310", "",
                "gonzalo@gmail.com", "456", "gonza");
        Assertions.assertEquals("Registro exitoso", usuarioRepository.registrar(usuario));
    }

    @Test
    public void usuarioYaEstáRegistrado(){
        Usuario usuario1 = new Usuario("Gonzalo", "Diaz", "1155617310", "",
                "gonzalo@gmail.com", "456", "gonza");
        Usuario usuario2 = new Usuario("Pablo", "Diaz", "1155617310", "",
                "pablo@gmail.com", "456", "pablo");
        try {
            usuarioRepository.registrar(usuario1);
            usuarioRepository.registrar(usuario2);
        }catch (DataIntegrityViolationException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

}
