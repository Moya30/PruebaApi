package com.prueba.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="estado" , uniqueConstraints = {@UniqueConstraint(columnNames = "id_estado")})
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;
    @Column(name = "nomb_estado")
    private String nombEstado;
}
