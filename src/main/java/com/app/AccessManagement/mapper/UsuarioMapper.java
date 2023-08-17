package com.app.AccessManagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.app.AccessManagement.dto.UsuarioDTO;
import com.app.AccessManagement.model.Usuario;

@Mapper
public interface UsuarioMapper {
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	@Mapping(source = "idUsuario", target = "idUsuario")
	UsuarioDTO toDTO(Usuario usuario);

	List<UsuarioDTO> toDTOList(List<Usuario> usuarios);

	@Mapping(source = "idUsuario", target = "idUsuario")
	Usuario toEntity(UsuarioDTO usuarioDTO);

	@Mapping(source = "idUsuario", target = "idUsuario")
	void updateEntityFromDTO(UsuarioDTO usuarioDTO, @MappingTarget Usuario usuario);
}
