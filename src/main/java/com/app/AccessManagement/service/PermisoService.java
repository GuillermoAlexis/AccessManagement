package com.app.AccessManagement.service;

import java.util.List;

import com.app.AccessManagement.dto.PermisoDTO;

public interface PermisoService {
	PermisoDTO crearPermiso(PermisoDTO permisoDTO);

	List<PermisoDTO> listarPermisos();

	PermisoDTO obtenerPermisoPorId(Long id);

	PermisoDTO actualizarPermiso(Long idPermiso, PermisoDTO permisoActualizadoDTO);
	
	void eliminarPermiso(Long id);

	List<PermisoDTO> obtenerPermisosPorUsuario(String idUsuario);

	
}
