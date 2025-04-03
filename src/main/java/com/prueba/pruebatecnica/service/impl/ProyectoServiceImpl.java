package com.prueba.pruebatecnica.service.impl;

import com.prueba.pruebatecnica.dto.ProyectoDTO;
import com.prueba.pruebatecnica.model.Estado;
import com.prueba.pruebatecnica.model.Icono;
import com.prueba.pruebatecnica.model.Proyecto;
import com.prueba.pruebatecnica.model.Usuario;
import com.prueba.pruebatecnica.repository.EstadoRepository;
import com.prueba.pruebatecnica.repository.IconoRepository;
import com.prueba.pruebatecnica.repository.ProyectoRepository;
import com.prueba.pruebatecnica.repository.UsuarioRepository;
import com.prueba.pruebatecnica.request.ProyectoRequest;
import com.prueba.pruebatecnica.service.ProyectoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IconoRepository iconoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ProyectoServiceImpl(ProyectoRepository proyectoRepository, ModelMapper modelMapper, UsuarioRepository usuarioRepository) {
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ProyectoDTO crearProyecto(ProyectoRequest proyectoRequest) {

        if (proyectoRequest.getIdProyecto() == null || proyectoRequest.getIdProyecto().isEmpty()) {
            throw new IllegalArgumentException("El ID del proyecto es obligatorio");
        }

        Estado estado = estadoRepository.findById(proyectoRequest.getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        Usuario usuario = usuarioRepository.findById(proyectoRequest.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Icono icono = iconoRepository.findById(proyectoRequest.getIdIcono())
                .orElseThrow(() -> new RuntimeException("Icono no encontrado"));

        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto(proyectoRequest.getIdProyecto());
        proyecto.setNombreProyecto(proyectoRequest.getNombreProyecto());
        proyecto.setDescProyecto(proyectoRequest.getDescProyecto());
        proyecto.setFechaIni(proyectoRequest.getFechaIni());
        proyecto.setFechaFin(proyectoRequest.getFechaFin());
        proyecto.setCompartir(proyectoRequest.getCompartir());
        proyecto.setEstado(estado);
        proyecto.setUsuario(usuario);
        proyecto.setIcono(icono);

        Proyecto savedProyecto = proyectoRepository.save(proyecto);
        return modelMapper.map(savedProyecto, ProyectoDTO.class);
    }

    @Override
    public ProyectoDTO obtenerProyecto(String id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        return modelMapper.map(proyecto, ProyectoDTO.class);
    }

    @Override
    public List<ProyectoDTO> obtenerTodosProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        return proyectos.stream()
                .map(proyecto -> modelMapper.map(proyecto, ProyectoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO actualizarProyecto(String id, ProyectoRequest proyectoRequest) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        proyecto.setNombreProyecto(proyectoRequest.getNombreProyecto());
        proyecto.setDescProyecto(proyectoRequest.getDescProyecto());
        proyecto.setFechaIni(proyectoRequest.getFechaIni());
        proyecto.setFechaFin(proyectoRequest.getFechaFin());

        Estado estado = estadoRepository.findById(proyectoRequest.getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        proyecto.setEstado(estado);

        Usuario usuario = usuarioRepository.findById(proyectoRequest.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        proyecto.setUsuario(usuario);

        Icono icono = iconoRepository.findById(proyectoRequest.getIdIcono())
                .orElseThrow(() -> new RuntimeException("Icono no encontrado"));
        proyecto.setIcono(icono);

        proyectoRepository.save(proyecto);
        return modelMapper.map(proyecto, ProyectoDTO.class);
    }

    @Override
    public void eliminarProyecto(String id) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        proyectoRepository.delete(proyecto);
    }
}
