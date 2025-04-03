package com.prueba.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foto_usuario")
public class FotoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto_usua")
    private Integer idFoto;

    @Column (name = "nomb_foto", length = 100, nullable = false)
    private String nombFoto;

    @Column(name="url_foto")
    private String urlFoto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
