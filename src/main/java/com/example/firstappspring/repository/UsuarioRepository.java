package com.example.firstappspring.repository;

import com.example.firstappspring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByTelefono(String telefono);
    Usuario deleteUsuarioByEmail(String email);
    Usuario findUsuarioByEmailAndPassword(String email, String password);

}
