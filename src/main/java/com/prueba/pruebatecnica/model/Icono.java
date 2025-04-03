package com.prueba.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="icono" , uniqueConstraints = {@UniqueConstraint(columnNames = "id_icono")})
public class Icono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_icono")
    private Integer idIcono;

    @Column(name = "nomb_icono")
    private String nombIncono;

    @Column(name = "url_icono")
    private  String urlIcono;
}
