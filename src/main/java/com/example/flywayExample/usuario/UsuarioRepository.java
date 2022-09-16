package com.example.flywayExample.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}