package com.example.firstappspring.service;

import com.example.firstappspring.dto.RequestInicioSesion;
import com.example.firstappspring.model.Usuario;
import lombok.val;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUsuarioService {

    @Autowired
    private UsuarioService usuarioService;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;

    @BeforeAll
    void setUp(){
        usuario1 = new Usuario("Akira", "Diaz", "1155617310", "",
                "akira@gmail.com", "456");
        usuario2 = new Usuario("Apolo", "Diaz", "1166788749", "",
                "apolo@gmail.com", "456");
        usuario3 = new Usuario("Titan", "Villaba", "1165655335", "",
                "titan@gmail.com", "456");
    }

    @BeforeEach
    void tearDown(){
        usuarioService.eliminarTodo();
    }

    @Test
    public void registroDeUsuarioCompleto() {
        val response = usuarioService.registrar(usuario1);
        Assertions.assertEquals("Usuario akira@gmail.com registrado con exito", response);
    }

    @Test
    public void intentoDeRegistroConEmailExistenteFallido() {
        usuarioService.registrar(usuario1);
        usuario2.setEmail("akira@gmail.com");
        val response = usuarioService.registrar(usuario2);
        Assertions.assertEquals("Usuario no registrado", response);
    }

    @Test
    public void intentoDeRegistroConTelefonoExistenteFallido(){
        usuarioService.registrar(usuario1);
        usuario2.setTelefono("1155617310");
        val response = usuarioService.registrar(usuario2);
        Assertions.assertEquals("Usuario no registrado", response);
    }

    @Test
    public void buscarPorEmail(){
        usuarioService.registrar(usuario1);
        val response = usuarioService.buscarPorEmail("akira@gmail.com");
        Assertions.assertEquals("Akira", response.getNombre());
    }

    @Test
    public void buscarUsuarioPorId(){
        usuarioService.registrar(usuario1);
        val id = usuarioService.buscarPorEmail("akira@gmail.com").getId();
        val response = usuarioService.buscarPorId(id);
        Assertions.assertEquals("Akira", response.getNombre());
    }

    @Test
    public void iniciarSesion(){
        usuarioService.registrar(usuario1);
        val request = new RequestInicioSesion("akira@gmail.com", "456");
        val response = usuarioService.iniciarSesion(request);
        Assertions.assertEquals("Akira", response.getNombre());
    }
}
