package com.prueba.pruebatecnica.service;

import com.prueba.pruebatecnica.dto.EstadoDTO;
import com.prueba.pruebatecnica.dto.UsuarioDTO;
import com.prueba.pruebatecnica.request.EstadoRequest;
import com.prueba.pruebatecnica.request.UsuarioRequest;

import java.util.List;

public interface EstadoService {
    List<EstadoDTO> listarEstado();
    EstadoDTO crearEstado(EstadoRequest estadoRequest);
}
