package com.prueba.pruebatecnica.service;

import com.prueba.pruebatecnica.dto.LoginDTO;
import com.prueba.pruebatecnica.dto.UsuarioDTO;
import com.prueba.pruebatecnica.request.UsuarioRequest;
import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO crearUsuario(UsuarioRequest usuarioRequest);
    UsuarioDTO obtenerUsuario(Integer id);
    UsuarioDTO actualizarUsuario(Integer id, UsuarioRequest usuarioRequest);

    // Método para el login
    LoginDTO login(String correo, String password);
}
