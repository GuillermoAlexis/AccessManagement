package com.app.AccessManagement.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
	private UUID idUsuario;
	private String nombreCompleto;
	private String email;
	private String contrasena;
}