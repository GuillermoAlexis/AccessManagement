package com.app.AccessManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.AccessManagement.model.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {

}
