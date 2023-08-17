package com.app.AccessManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.AccessManagement.model.Acceso;
import com.app.AccessManagement.model.Usuario;

public interface AccesoRepository extends JpaRepository<Acceso, Long> {

	Acceso findTopByUsuarioOrderByFechaDescIdAccesoDesc(Usuario usuario);
}