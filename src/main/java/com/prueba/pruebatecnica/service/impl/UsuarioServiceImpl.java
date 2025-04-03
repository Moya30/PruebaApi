package com.prueba.pruebatecnica.service.impl;

import com.prueba.pruebatecnica.dto.LoginDTO;
import com.prueba.pruebatecnica.dto.UsuarioDTO;
import com.prueba.pruebatecnica.model.Usuario;
import com.prueba.pruebatecnica.repository.UsuarioRepository;
import com.prueba.pruebatecnica.request.UsuarioRequest;
import com.prueba.pruebatecnica.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombUsuario(usuarioRequest.getNombUsuario());
        usuario.setApeUsuario(usuarioRequest.getApeUsuario());
        usuario.setCargEmp(usuarioRequest.getCargEmp());
        usuario.setNombEmp(usuarioRequest.getNombEmp());
        usuario.setTelfUsua(usuarioRequest.getTelfUsua());
        usuario.setCorreoUsua(usuarioRequest.getCorreoUsua());
        usuario.setPassword(usuarioRequest.getPassword());
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return modelMapper.map(usuarioGuardado, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO obtenerUsuario(Integer id) {
        return null;
    }

    @Override
    public UsuarioDTO actualizarUsuario(Integer id, UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNombUsuario(usuarioRequest.getNombUsuario());
            usuario.setApeUsuario(usuarioRequest.getApeUsuario());
            usuario.setCargEmp(usuarioRequest.getCargEmp());
            usuario.setNombEmp(usuarioRequest.getNombEmp());
            usuario.setTelfUsua(usuarioRequest.getTelfUsua());
            usuario.setCorreoUsua(usuarioRequest.getCorreoUsua());
            usuario.setPassword(usuarioRequest.getPassword());

            Usuario usuarioActualizado = usuarioRepository.save(usuario);
            return modelMapper.map(usuarioActualizado, UsuarioDTO.class);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
    @Override
    public LoginDTO login(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreoUsuaAndPassword(correo, password);

        if (usuario != null) {
            return new LoginDTO(usuario.getIdUsuario(), usuario.getCorreoUsua(), "LOGEADO CON ÉXITO");
        }
        return new LoginDTO(null, null, "CREDENCIALES INCORRECTAS");
    }

}
