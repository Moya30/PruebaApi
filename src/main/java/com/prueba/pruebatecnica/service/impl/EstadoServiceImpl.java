package com.prueba.pruebatecnica.service.impl;

import com.prueba.pruebatecnica.dto.EstadoDTO;
import com.prueba.pruebatecnica.dto.UsuarioDTO;
import com.prueba.pruebatecnica.model.Estado;
import com.prueba.pruebatecnica.model.Usuario;
import com.prueba.pruebatecnica.repository.EstadoRepository;
import com.prueba.pruebatecnica.repository.UsuarioRepository;
import com.prueba.pruebatecnica.request.EstadoRequest;
import com.prueba.pruebatecnica.service.EstadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EstadoServiceImpl(EstadoRepository estadoRepository, ModelMapper modelMapper) {
        this.estadoRepository = estadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EstadoDTO> listarEstado() {
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream()
                .map(estado -> modelMapper.map(estado, EstadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EstadoDTO crearEstado(EstadoRequest estadoRequest) {
        Estado estado = new Estado();
        estado.setNombEstado(estadoRequest.getNombEstado());

        Estado estadoguardado = estadoRepository.save(estado);
        return modelMapper.map(estadoguardado, EstadoDTO.class);
    }
}
