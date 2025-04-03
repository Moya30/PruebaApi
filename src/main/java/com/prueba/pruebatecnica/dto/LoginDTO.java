package com.prueba.pruebatecnica.dto;

import lombok.Data;

@Data
public class LoginDTO {

    private Integer id;
    private String correo;
    private String mensaje;

    public LoginDTO(Integer id, String correo, String mensaje) {
        this.id = id;
        this.correo = correo;
        this.mensaje = mensaje;
    }
}
