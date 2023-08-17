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

import com.app.AccessManagement.dto.AccesoDTO;
import com.app.AccessManagement.service.AccesoService;

@RestController
@RequestMapping("/accesos")
public class AccesoController {
	@Autowired
	private AccesoService accesoService;

	@GetMapping
	public List<AccesoDTO> listarAccesos() {
		return accesoService.listarAccesos();
	}

	@GetMapping("/{idAcceso}")
	public AccesoDTO obtenerAccesoPorId(@PathVariable Long idAcceso) {
		return accesoService.obtenerAccesoPorId(idAcceso);
	}

	@PostMapping
	public AccesoDTO crearAcceso(@RequestBody AccesoDTO acceso) {
		return accesoService.crearAcceso(acceso);
	}

	@PutMapping("/{idAcceso}")
	public AccesoDTO actualizarAcceso(@PathVariable Long idAcceso, @RequestBody AccesoDTO accesoActualizado) {
		return accesoService.actualizarAcceso(idAcceso, accesoActualizado);
	}

	@DeleteMapping("/{idAcceso}")
	public void eliminarAcceso(@PathVariable Long idAcceso) {
		accesoService.eliminarAcceso(idAcceso);
	}

	@GetMapping("/ultimo/{idUsuario}")
	public AccesoDTO obtenerUltimoAccesoPorUsuario(@PathVariable String idUsuario) {
		return accesoService.obtenerUltimoAccesoPorUsuario(idUsuario);
	}

}
