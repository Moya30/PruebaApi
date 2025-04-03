package com.prueba.pruebatecnica.response;

import com.prueba.pruebatecnica.dto.ProyectoDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Data
public class ProyectoResponse {

    private String mensaje;
    private ProyectoDTO proyecto;

    public ProyectoResponse(String mensaje, ProyectoDTO proyecto) {
        this.mensaje = mensaje;
        this.proyecto = proyecto;
    }
}
