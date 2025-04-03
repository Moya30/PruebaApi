package com.prueba.pruebatecnica.controller;


import com.prueba.pruebatecnica.dto.ProyectoDTO;
import com.prueba.pruebatecnica.request.ProyectoRequest;
import com.prueba.pruebatecnica.response.ProyectoResponse;
import com.prueba.pruebatecnica.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @PostMapping
    public ResponseEntity<ProyectoResponse> crearProyecto(@RequestBody ProyectoRequest proyectoRequest) {
        ProyectoDTO proyectoDTO = proyectoService.crearProyecto(proyectoRequest);
        ProyectoResponse response = new ProyectoResponse("Proyecto creado exitosamente", proyectoDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> obtenerProyecto(@PathVariable String id) {
        ProyectoDTO proyectoDTO = proyectoService.obtenerProyecto(id);
        return ResponseEntity.ok(proyectoDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProyectoDTO> actualizarProyecto(@PathVariable String id, @RequestBody ProyectoRequest proyectoRequest) {
        ProyectoDTO proyectoDTO = proyectoService.actualizarProyecto(id,proyectoRequest);
        return ResponseEntity.ok(proyectoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> obtenerTodosProyectos() {
        List<ProyectoDTO> proyectos = proyectoService.obtenerTodosProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable("id") String id) {
        proyectoService.eliminarProyecto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
