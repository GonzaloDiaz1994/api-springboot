package com.example.firstappspring.repository;

import com.example.firstappspring.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String registrar(Usuario usuario){
       if (!entityManager.contains(usuario)){
            entityManager.persist(usuario);
            return "usuario persistido";
       }else {
           return "usuario no persistido";
       }
    }
}
