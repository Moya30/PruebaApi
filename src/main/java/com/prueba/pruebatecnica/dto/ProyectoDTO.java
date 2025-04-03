package com.prueba.pruebatecnica.dto;

import com.prueba.pruebatecnica.model.Estado;
import com.prueba.pruebatecnica.model.Icono;
import com.prueba.pruebatecnica.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ProyectoDTO {
    private String idProyecto;
    private String nombreProyecto;
    private String descProyecto;
    private LocalDateTime fechaIni;
    private LocalDateTime fechaFin;
    private Boolean compartir;
    private Estado estado;
    private Usuario usuario;
    private Icono icono;
}
