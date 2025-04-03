package com.prueba.pruebatecnica.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String correo;
    private String password;
}
