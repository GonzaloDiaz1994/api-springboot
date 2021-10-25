package com.example.firstappspring.controller;

import com.example.firstappspring.model.Usuario;
import com.example.firstappspring.service.UsuarioService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
            return new ResponseEntity(usuarioService.registrar(usuario), HttpStatus.ACCEPTED);
        }catch (DataIntegrityViolationException e){
            return new ResponseEntity("Registro no realizado: alguno de los datos ya existen", HttpStatus.BAD_REQUEST);
        }
    }

}
