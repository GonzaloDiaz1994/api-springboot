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
        return "Registro exitoso";
    }

    @Transactional
    public void eliminarTodo(){
        String query = "DELETE FROM Usuario ";
        entityManager.createQuery(query).executeUpdate();
    }

}
