package com.example.firstappspring.controller;

import com.example.firstappspring.dto.RequestInicioSesion;
import com.example.firstappspring.dto.ResponseUsuario;
import com.example.firstappspring.model.Usuario;
import com.example.firstappspring.service.UsuarioService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> todosLosUsuarios(){
        return new ResponseEntity(usuarioService.todosLosUsuarios(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        try{
            return new ResponseEntity(usuarioService.registrar(usuario), HttpStatus.ACCEPTED);
        }catch (DataIntegrityViolationException e){
            return new ResponseEntity("Registro no realizado: alguno de los datos ya existen", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/inicio_sesion")
    public ResponseEntity<ResponseUsuario> iniciarSesion(@RequestBody RequestInicioSesion requestInicioSesion){
        val response = usuarioService.iniciarSesion(requestInicioSesion);
        if (response != null){
            return new ResponseEntity(response, HttpStatus.OK);
        }else{
            return new ResponseEntity("Email o contraseña incorrectas", HttpStatus.BAD_REQUEST);
        }
    }

}
