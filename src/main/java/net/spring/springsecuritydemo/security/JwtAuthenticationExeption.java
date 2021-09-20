package net.spring.springsecuritydemo.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenticationExeption extends AuthenticationException {

    private HttpStatus httpStatus;

    public JwtAuthenticationExeption(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public JwtAuthenticationExeption(String msg) {
        super(msg);
    }
}
