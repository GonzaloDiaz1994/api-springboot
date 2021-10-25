package com.example.firstappspring.repository;

import com.example.firstappspring.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String registrar(Usuario usuario){
        entityManager.persist(usuario);
        return "usuario persistido";
    }

    @Transactional
    public boolean usuarioOEmailRegitrado(String nombreUsuario, String email){
        return entityManager.contains(nombreUsuario) || entityManager.contains(email);
    }
}
