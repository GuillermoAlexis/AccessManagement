package com.app.AccessManagement.service.impl;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.AccessManagement.dto.PermisoDTO;
import com.app.AccessManagement.mapper.PermisoMapper;
import com.app.AccessManagement.model.Permiso;
import com.app.AccessManagement.model.Usuario;
import com.app.AccessManagement.repository.PermisoRepository;
import com.app.AccessManagement.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService {
	@Autowired
	private PermisoRepository permisoRepository;

	public PermisoDTO crearPermiso(PermisoDTO permisoDTO) {
		Permiso permiso = PermisoMapper.INSTANCE.toEntity(permisoDTO);
		return PermisoMapper.INSTANCE.toDTO(permisoRepository.save(permiso));
	}

	public List<PermisoDTO> listarPermisos() {
		List<Permiso> permisos = permisoRepository.findAll();
		return PermisoMapper.INSTANCE.toDTOList(permisos);
	}

	public PermisoDTO obtenerPermisoPorId(Long id) {
		Permiso permiso = permisoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Permiso no encontrado"));
		return PermisoMapper.INSTANCE.toDTO(permiso);
	}

	public PermisoDTO actualizarPermiso(Long idPermiso, PermisoDTO permisoActualizadoDTO) {
		Permiso permisoExistente = permisoRepository.findById(idPermiso)
				.orElseThrow(() -> new EntityNotFoundException("Permiso no encontrado con ID: " + idPermiso));

		Permiso permisoActualizado = PermisoMapper.INSTANCE.toEntity(permisoActualizadoDTO);
		permisoExistente.setUsuario(permisoActualizado.getUsuario());
		permisoExistente.setPermiso(permisoActualizado.getPermiso());

		return PermisoMapper.INSTANCE.toDTO(permisoRepository.save(permisoExistente));
	}

	public List<PermisoDTO> obtenerPermisosPorUsuario(String idUsuario) {
	    UUID uuid = UUID.fromString(idUsuario);
	    Usuario usuario = new Usuario();
	    usuario.setIdUsuario(uuid);
	    
	    List<Permiso> permisos = permisoRepository.findByUsuario(usuario);
	    
	    return PermisoMapper.INSTANCE.toDTOList(permisos);
	}

	public void eliminarPermiso(Long id) {
		permisoRepository.deleteById(id);
	}
}
