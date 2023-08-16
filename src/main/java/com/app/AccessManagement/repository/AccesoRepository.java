package com.app.AccessManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.AccessManagement.model.Acceso;

public interface AccesoRepository extends JpaRepository<Acceso, Long> {

}