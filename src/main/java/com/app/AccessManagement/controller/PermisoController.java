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
import org.springframework.web.bind.annotation.RestController;

import com.app.AccessManagement.dto.PermisoDTO;
import com.app.AccessManagement.service.PermisoService;

@RestController
@RequestMapping("/permisos")
public class PermisoController {
	@Autowired
	private PermisoService permisoService;

	@GetMapping
	public List<PermisoDTO> listarPermisos() {
		return permisoService.listarPermisos();
	}

	@GetMapping("/{idPermiso}")
	public PermisoDTO obtenerPermisoPorId(@PathVariable Long idPermiso) {
		return permisoService.obtenerPermisoPorId(idPermiso);
	}

	@PostMapping
	public PermisoDTO crearPermiso(@RequestBody PermisoDTO permiso) {
		return permisoService.crearPermiso(permiso);
	}

	@PutMapping("/{idPermiso}")
	public PermisoDTO actualizarPermiso(@PathVariable Long idPermiso, @RequestBody PermisoDTO permisoActualizado) {
		return permisoService.actualizarPermiso(idPermiso, permisoActualizado);
	}

	@DeleteMapping("/{idPermiso}")
	public void eliminarPermiso(@PathVariable Long idPermiso) {
		permisoService.eliminarPermiso(idPermiso);
	}

	@GetMapping("/usuario/{idUsuario}/permisos")
	public List<PermisoDTO> obtenerPermisosPorUsuario(@PathVariable String idUsuario) {
		return permisoService.obtenerPermisosPorUsuario(idUsuario);
	}
}
