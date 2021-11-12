package com.example.firstappspring.service;

import com.example.firstappspring.dto.RequestInicioSesion;
import com.example.firstappspring.model.Cuenta;
import com.example.firstappspring.model.Rol;
import com.example.firstappspring.model.Usuario;
import lombok.val;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUsuarioService {

    @Autowired
    private UsuarioService usuarioService;
    private Usuario usuario1;
    private Usuario usuario2;
    private Cuenta cuenta1;
    private Cuenta cuenta2;
    private Rol administardor;
    private Rol colaborador;
    private Rol visitante;


    @BeforeAll
    void setUp(){
        cuenta1 = new Cuenta("ALIAS-1", 30000);
        cuenta2 = new Cuenta("ALIAS-2", 0);
        administardor = new Rol("ADMINISTRADOR");
        colaborador = new Rol("COLABORADOR");
        visitante = new Rol("VISITANTE");


        usuario1 = new Usuario("Akira", "Diaz", "1155617310", "",
                "akira@gmail.com", "456");
        usuario1.agregarRol(administardor);
        usuario1.agregarRol(colaborador);
        usuario1.setCuenta(cuenta1);


        usuario2 = new Usuario("Apolo", "Diaz", "1166788749", "",
                "apolo@gmail.com", "456");
        usuario2.setCuenta(cuenta2);
        usuario2.agregarRol(colaborador);
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
        Usuario usuario3 = new Usuario("Titan", "Villaba", "1165655335", "",
                "titan@gmail.com", "890");
        usuarioService.registrar(usuario3);
        Cuenta cuenta = new Cuenta("ALIAS-3", 100);
        usuario3.agregarRol(visitante);
        usuario3.setCuenta(cuenta);
        val request = new RequestInicioSesion("titan@gmail.com", "890");
        val response = usuarioService.iniciarSesion(request);
        Assertions.assertEquals("Titan", response.getNombre());
    }
}
