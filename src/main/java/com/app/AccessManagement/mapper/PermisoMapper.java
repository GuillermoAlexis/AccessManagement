package com.app.AccessManagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.AccessManagement.dto.PermisoDTO;
import com.app.AccessManagement.model.Permiso;

@Mapper
public interface PermisoMapper {
	PermisoMapper INSTANCE = Mappers.getMapper(PermisoMapper.class);

	@Mapping(source = "usuario", target = "usuario")
	PermisoDTO toDTO(Permiso permiso);

	List<PermisoDTO> toDTOList(List<Permiso> permisos);

	@Mapping(source = "usuario", target = "usuario")
	Permiso toEntity(PermisoDTO permisoDTO);
}