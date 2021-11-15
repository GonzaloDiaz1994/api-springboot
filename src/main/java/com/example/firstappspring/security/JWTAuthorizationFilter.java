package com.example.firstappspring.security;

import io.jsonwebtoken.*;
import lombok.val;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private static final String PREFIX = "Bearer ";
    private static final String SECRET = "mySecretKey";
    private static final String HEADER = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            if(existeJWTToken(request, response)){
                val claims = validateToken(request);
                if (claims.get("authorities") != null){
                    setUpSpringAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e){
            catchError(response, e);
        }
    }

    /**catchea el error**/
    private void catchError(HttpServletResponse response, Exception e) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    }


    private void setUpSpringAuthentication(Claims claims){
        val authorities = ((List<String>) claims.get("authorities"));
        val auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities.stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    /**
     * Obtiene el header y quita el prefijo.
     * Decodifica el token con la llave secreta.
     * **/
    private Claims validateToken(HttpServletRequest request){
        val jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
    }


    /**
     *
     * Si el header es NULL o NO comienza con el prefijo seteado, retorna falso.
     * **/
    private Boolean existeJWTToken(HttpServletRequest request, HttpServletResponse response){
        val authenticationHeader = request.getHeader(HEADER);
        return !(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX));
    }

}

