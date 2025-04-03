package com.prueba.pruebatecnica.repository;

import com.prueba.pruebatecnica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByCorreoUsuaAndPassword(String correoUsua, String password);

}
