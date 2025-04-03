package com.prueba.pruebatecnica.response;

import com.prueba.pruebatecnica.dto.EstadoDTO;
import lombok.Data;

@Data
public class EstadoResponse {
    private String mensaje;
    private EstadoDTO estado;

    public EstadoResponse(String mensaje, EstadoDTO estado) {
        this.mensaje = mensaje;
        this.estado = estado;
    }
}
