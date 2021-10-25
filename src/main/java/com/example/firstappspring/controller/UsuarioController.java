package com.example.firstappspring.controller;

import com.example.firstappspring.exception.UsuarioYaRegistrado;
import com.example.firstappspring.model.Usuario;
import com.example.firstappspring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        try{
            usuarioService.registrar(usuario);
            return new ResponseEntity("Registro exitoso", HttpStatus.ACCEPTED);
        }catch (UsuarioYaRegistrado e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
