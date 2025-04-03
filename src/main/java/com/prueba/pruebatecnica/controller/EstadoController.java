package com.prueba.pruebatecnica.controller;

import com.prueba.pruebatecnica.dto.EstadoDTO;
import com.prueba.pruebatecnica.request.EstadoRequest;
import com.prueba.pruebatecnica.response.EstadoResponse;
import com.prueba.pruebatecnica.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
        private final EstadoService  estadoService;
    @Autowired
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listarEstados() {
        try {
            List<EstadoDTO> estados = estadoService.listarEstado();
            return ResponseEntity.ok(estados);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping(value = "/crear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoResponse> crearEstado(@RequestBody EstadoRequest request) {
        EstadoDTO estadoDTO = estadoService.crearEstado(request);
        EstadoResponse response = new EstadoResponse("estado creado con éxito", estadoDTO);
        return ResponseEntity.ok(response);
    }
}
