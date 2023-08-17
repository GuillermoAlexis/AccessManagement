package com.app.AccessManagement.service.impl;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.AccessManagement.dto.UsuarioDTO;
import com.app.AccessManagement.exception.InvalidCredentialsException;
import com.app.AccessManagement.mapper.UsuarioMapper;
import com.app.AccessManagement.model.Usuario;
import com.app.AccessManagement.repository.UsuarioRepository;
import com.app.AccessManagement.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService  {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
		return UsuarioMapper.INSTANCE.toDTO(usuarioRepository.save(usuario));
	}

	public List<UsuarioDTO> listarUsuarios() {
		List<Usuario> usuario = usuarioRepository.findAll();
		return UsuarioMapper.INSTANCE.toDTOList(usuario);
	}

	public UsuarioDTO obtenerUsuarioPorId(String idUsuario) {
		UUID uuid = UUID.fromString(idUsuario);
		Usuario usuario = usuarioRepository.findById(uuid)
				.orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
		return UsuarioMapper.INSTANCE.toDTO(usuario);
	}

	public UsuarioDTO actualizarUsuario(String idUsuario, UsuarioDTO usuarioActualizadoDTO) {
		UUID uuid = UUID.fromString(idUsuario);
		Usuario usuarioExistente = usuarioRepository.findById(uuid)
				.orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + idUsuario));

		Usuario usuarioActualizado = UsuarioMapper.INSTANCE.toEntity(usuarioActualizadoDTO);
		usuarioExistente.setNombreCompleto(usuarioActualizado.getNombreCompleto());
		usuarioExistente.setEmail(usuarioActualizado.getEmail());
		usuarioExistente.setContrasena(usuarioActualizado.getContrasena());

		return UsuarioMapper.INSTANCE.toDTO(usuarioRepository.save(usuarioExistente));
	}

	public void eliminarUsuario(String idUsuario) {
		UUID uuid = UUID.fromString(idUsuario);
		usuarioRepository.deleteById(uuid);
	}

	public UsuarioDTO login(String email, String contrasena) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

		if (usuario.getContrasena().equals(contrasena)) {
			return UsuarioMapper.INSTANCE.toDTO(usuario);
		} else {
			throw new InvalidCredentialsException("Credenciales inválidas");
		}
	}
}