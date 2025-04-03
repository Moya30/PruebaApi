package com.prueba.pruebatecnica.controller;

import com.prueba.pruebatecnica.dto.LoginDTO;
import com.prueba.pruebatecnica.dto.UsuarioDTO;
import com.prueba.pruebatecnica.request.LoginRequest;
import com.prueba.pruebatecnica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public LoginDTO login(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest.getCorreo(), loginRequest.getPassword());
    }
}
