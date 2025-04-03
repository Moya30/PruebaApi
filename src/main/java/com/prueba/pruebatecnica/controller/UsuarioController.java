package com.prueba.pruebatecnica.controller;
import com.prueba.pruebatecnica.dto.UsuarioDTO;
import com.prueba.pruebatecnica.request.UsuarioRequest;
import com.prueba.pruebatecnica.response.UsuarioResponse;
import com.prueba.pruebatecnica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        try {
            List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping(value = "/crear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody UsuarioRequest request) {
        UsuarioDTO usuarioDTO = usuarioService.crearUsuario(request);
        UsuarioResponse response = new UsuarioResponse("Usuario creado con éxito", usuarioDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioResponse> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest request) {
        UsuarioDTO usuarioDTO = usuarioService.actualizarUsuario(id, request);
        UsuarioResponse response = new UsuarioResponse("Usuario actualizado con éxito", usuarioDTO);
        return ResponseEntity.ok(response);
    }

}
