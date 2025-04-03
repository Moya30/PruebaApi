package com.prueba.pruebatecnica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = "correo_usua")})
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")

    private Integer idUsuario;

    @Column (name = "nomb_usua", length = 100, nullable = false)
    private String nombUsuario;

    @Column (name = "ape_usua", length = 100, nullable = false)
    private String apeUsuario;

    @Column (name = "carg_emp_usua", length = 100)
    private String cargEmp;

    @Column (name = "nomb_emp_usua", length = 100)
    private String nombEmp;

    @Column(name = "telf_usua")
    private String telfUsua;

    @Column (name = "correo_usua", length = 100)
    private String correoUsua;

    @Column(name = "pass_usua")
    @JsonIgnore
    private String password;
}
