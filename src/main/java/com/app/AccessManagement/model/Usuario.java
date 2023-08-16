package com.app.AccessManagement.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", columnDefinition = "uuid", updatable = false)
	private UUID idUsuario;

	@Column(name = "nombre_completo", length = 100)
	private String nombreCompleto;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "contrasena", length = 100)
	private String contrasena;

}
