package com.mildw.minsu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

@Component
public class JwtTokenProvider {

    public String createJwtToken(String subject) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jws = Jwts.builder().setSubject(subject).signWith(key).compact();
        return jws;
    }

    public Claims decodeJWT(String jwt) {
        try {
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
            jws.getSignature();

            //OK, we can trust this JWT

        } catch (Exception e) {

            //don't trust the JWT!
        }
    }
}