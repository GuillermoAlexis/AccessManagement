package com.app.AccessManagement.dto;

import java.time.LocalDateTime;

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
public class AccesoDTO {
	private Long idAcceso;
	private Usuario usuario;
	private LocalDateTime fecha;
}