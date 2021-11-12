package com.example.firstappspring.service;

import com.example.firstappspring.dto.RequestInicioSesion;
import com.example.firstappspring.dto.ResponseUsuario;
import com.example.firstappspring.model.Usuario;
import com.example.firstappspring.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public String registrar(Usuario usuario){
        if (!usuarioRepository.existsByEmail(usuario.getEmail())
                && !usuarioRepository.existsByTelefono(usuario.getTelefono())){
            val pass = toHash("ayi#"+ usuario.getPassword());
            usuario.setPassword(pass);
            usuarioRepository.save(usuario);
            return "Usuario "+usuario.getEmail()+" registrado con exito";
        }else {
            return "Usuario no registrado";
        }
    }

    @Override
    public ResponseUsuario buscarPorEmail(String email) {
        val response = usuarioRepository.findByEmail(email);
        return new ResponseUsuario(response.getId(), response.getNombre(),
                response.getApellido(), response.getFotoPerfil());
    }

    @Override
    public ResponseUsuario buscarPorId(Long id) {
        val retorno = usuarioRepository.findById(id).get();
        return new ResponseUsuario(retorno.getId(), retorno.getNombre(),
                retorno.getApellido(), retorno.getFotoPerfil());
    }

    @Override
    public ResponseUsuario iniciarSesion(RequestInicioSesion requestInicioSesion) {
        try{
            val pass = toHash("ayi#"+requestInicioSesion.getPassword());
            val response = usuarioRepository.findUsuarioByEmailAndPassword(requestInicioSesion.getEmail()
                    , pass);
            return new ResponseUsuario(response.getId(), response.getNombre(),
                    response.getApellido(), response.getFotoPerfil());

        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Usuario> todosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void eliminarTodo() {
        usuarioRepository.deleteAll();
    }

    // hasheo

    private byte[] toByteArray(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bytes = password.getBytes();
        return digest.digest(bytes);
    }

    private String byteArrayToHex(byte[] array){
        StringBuilder sb = new StringBuilder(array.length + 2);
        for (byte b : array){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String toHash(String password){
        return this.byteArrayToHex(this.toByteArray(password));
    }
}
