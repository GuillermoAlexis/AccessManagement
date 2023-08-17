package com.app.AccessManagement.service.impl;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.AccessManagement.dto.AccesoDTO;
import com.app.AccessManagement.mapper.AccesoMapper;
import com.app.AccessManagement.model.Acceso;
import com.app.AccessManagement.model.Usuario;
import com.app.AccessManagement.repository.AccesoRepository;
import com.app.AccessManagement.service.AccesoService;

@Service
public class AccesoServiceImpl implements AccesoService {
	@Autowired
	private AccesoRepository accesoRepository;

	public AccesoDTO crearAcceso(AccesoDTO accesoDTO) {
		Acceso acceso = AccesoMapper.INSTANCE.toEntity(accesoDTO);
		return AccesoMapper.INSTANCE.toDTO(accesoRepository.save(acceso));
	}

	public List<AccesoDTO> listarAccesos() {
		List<Acceso> accesos = accesoRepository.findAll();
		return AccesoMapper.INSTANCE.toDTOList(accesos);
	}

	public AccesoDTO obtenerAccesoPorId(Long id) {
		Acceso acceso = accesoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Acceso no encontrado"));
		return AccesoMapper.INSTANCE.toDTO(acceso);
	}

	public AccesoDTO actualizarAcceso(Long idAcceso, AccesoDTO accesoActualizadoDTO) {
		Acceso accesoExistente = accesoRepository.findById(idAcceso)
				.orElseThrow(() -> new RuntimeException("Acceso no encontrado con ID: " + idAcceso));

		Acceso accesoActualizado = AccesoMapper.INSTANCE.toEntity(accesoActualizadoDTO);
		accesoExistente.setUsuario(accesoActualizado.getUsuario());
		accesoExistente.setFecha(accesoActualizado.getFecha());

		return AccesoMapper.INSTANCE.toDTO(accesoRepository.save(accesoExistente));
	}

	public AccesoDTO obtenerUltimoAccesoPorUsuario(String idUsuario) {
		UUID uuid = UUID.fromString(idUsuario);
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(uuid);
		Acceso ultimoAcceso = accesoRepository.findTopByUsuarioOrderByFechaDescIdAccesoDesc(usuario);
		if (ultimoAcceso != null) {
			return AccesoMapper.INSTANCE.toDTO(ultimoAcceso);
		}
		return null;
	}

	public void eliminarAcceso(Long id) {
		accesoRepository.deleteById(id);
	}

}
