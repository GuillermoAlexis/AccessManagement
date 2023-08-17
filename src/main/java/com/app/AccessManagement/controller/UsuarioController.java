package com.app.AccessManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.AccessManagement.dto.UsuarioDTO;
import com.app.AccessManagement.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<UsuarioDTO> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}

	@GetMapping("/{idUsuario}")
	public UsuarioDTO obtenerUsuarioPorId(@PathVariable String idUsuario) {
		return usuarioService.obtenerUsuarioPorId(idUsuario);
	}

	@PostMapping
	public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuario) {
		return usuarioService.crearUsuario(usuario);
	}

	@PutMapping("/{idUsuario}")
	public UsuarioDTO actualizarUsuario(@PathVariable String idUsuario, @RequestBody UsuarioDTO usuarioActualizado) {
		return usuarioService.actualizarUsuario(idUsuario, usuarioActualizado);
	}

	@DeleteMapping("/{idUsuario}")
	public void eliminarUsuario(@PathVariable String idUsuario) {
		usuarioService.eliminarUsuario(idUsuario);
	}

	@PostMapping("/login")
	public UsuarioDTO login(@RequestParam String email, @RequestParam String contrasena) {
		return usuarioService.login(email, contrasena);
	}
}
