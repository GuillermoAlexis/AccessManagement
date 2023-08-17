package com.app.AccessManagement.service;

import java.util.List;

import com.app.AccessManagement.dto.AccesoDTO;

public interface AccesoService {
	AccesoDTO crearAcceso(AccesoDTO accesoDTO);

	List<AccesoDTO> listarAccesos();

	AccesoDTO obtenerAccesoPorId(Long id);

	AccesoDTO actualizarAcceso(Long idAcceso, AccesoDTO accesoActualizadoDTO);

	void eliminarAcceso(Long id);

	AccesoDTO obtenerUltimoAccesoPorUsuario(String idUsuario);

}
