package com.prueba.pruebatecnica.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ProyectoRequest {
    private  String idProyecto;
    private String nombreProyecto;
    private String descProyecto;
    private LocalDateTime fechaIni;
    private LocalDateTime fechaFin;
    private Boolean compartir;
    private Integer idUsuario;
    private  Integer idIcono;
    private  Integer idEstado;
}

