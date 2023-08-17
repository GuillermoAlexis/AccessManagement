package com.app.AccessManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.AccessManagement.model.Permiso;
import com.app.AccessManagement.model.Usuario;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {

	List<Permiso> findByUsuario(Usuario usuario);
}
