package com.app.AccessManagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.AccessManagement.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	
}