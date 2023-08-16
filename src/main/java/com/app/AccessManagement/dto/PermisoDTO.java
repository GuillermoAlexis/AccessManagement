package com.app.AccessManagement.dto;

import com.app.AccessManagement.model.Usuario;

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
public class PermisoDTO {
	private Long idPermiso;
	private Usuario usuario;
	private String permiso;
}