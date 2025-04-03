package com.prueba.pruebatecnica.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UsuarioRequest {

    private String nombUsuario;
    private String apeUsuario;
    private String cargEmp;
    private String nombEmp;
    private String telfUsua;
    private String correoUsua;
    private String password;
}
