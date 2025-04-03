package com.prueba.pruebatecnica.response;

import com.prueba.pruebatecnica.dto.UsuarioDTO;
import lombok.Data;

@Data
public class UsuarioResponse {
    private String mensaje;
    private UsuarioDTO usuario;

    public UsuarioResponse(String mensaje, UsuarioDTO usuario) {
        this.mensaje = mensaje;
        this.usuario = usuario;
    }
}
