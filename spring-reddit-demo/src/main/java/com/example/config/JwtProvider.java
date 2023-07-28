package com.example.config;

import org.springframework.stereotype.Service;

import java.security.KeyStore;

@Service
public class JwtProvider {

    private KeyStore keyStore;

/*    @PostConstruct
    public void init() {
        keyStore = KeyStore.getInstance("JKS");
        InputStream resourceStream = getClass().getResourceAsStream("/springblog.jks");
    }*/

/*    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey()).compact();
    }*/

}