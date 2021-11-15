package com.example.firstappspring.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.val;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.stream.Collectors;

public class Token {

    /**
     * Se le agrega "Bearer" como prefijo al token por ser un
     * estandar de OAUTH 2.0.
     * "Bearer" avisa que lo que lo acompaña detras es un token de tipo JWT
     * **/

    public static String getJWTToken(String username){
        val secretKey = "mySecretKey";
        val grantedAuthorities = AuthorityUtils.
                commaSeparatedStringToAuthorityList("ROLE_USER");
        val token = Jwts
                .builder()
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream()
                        .map(obj -> obj.getAuthority()).collect(Collectors.toList()))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}
