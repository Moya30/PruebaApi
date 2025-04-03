package com.prueba.pruebatecnica.service;

import com.prueba.pruebatecnica.dto.ProyectoDTO;
import com.prueba.pruebatecnica.model.Proyecto;
import com.prueba.pruebatecnica.request.ProyectoRequest;

import java.util.List;

public interface ProyectoService {

    ProyectoDTO crearProyecto(ProyectoRequest request);
    ProyectoDTO obtenerProyecto(String id);
    List<ProyectoDTO> obtenerTodosProyectos();
    ProyectoDTO actualizarProyecto(String id, ProyectoRequest proyectoRequest);
    void eliminarProyecto(String id);

}
