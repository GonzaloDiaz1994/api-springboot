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
    public boolean emailYaRegitrado(String email){
        return entityManager.contains(email);
    }

    @Transactional
    public boolean existeElUsuario(Usuario usuario){
        return entityManager.contains(usuario);
    }

    @Transactional
    public boolean nombreUsuarioYaRegistrado(String nombreUsuario){
        return entityManager.contains(nombreUsuario);
    }

    @Transactional
    public boolean telefonoYaRegistrado(String telefono){
        return entityManager.contains(telefono);
    }

    public boolean datosYaRegistrados(Usuario usuario) {
        return nombreUsuarioYaRegistrado(usuario.getNombreUsuario()) || emailYaRegitrado(usuario.getEmail()) ||
                telefonoYaRegistrado(usuario.getTelefono());
    }
}
