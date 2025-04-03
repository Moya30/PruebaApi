package com.prueba.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "proyecto" ,  uniqueConstraints = {@UniqueConstraint(columnNames = "id_proyecto")})
public class Proyecto {

    @Id
    @Column(name = "id_proyecto")
    private String idProyecto;

    @Column (name = "nomb_proyecto", length = 100, nullable = false)
    private  String nombreProyecto;
    @Column (name = "desc_proyecto", length = 100, nullable = false)
    private String descProyecto;
    @Column (name = "fecha_ini", length = 100, nullable = false)
    private LocalDateTime fechaIni;
    @Column (name = "fecha_fin", length = 100, nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "compartir")
    private Boolean compartir;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario" , nullable = false)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_icono")
    private Icono icono;
}
