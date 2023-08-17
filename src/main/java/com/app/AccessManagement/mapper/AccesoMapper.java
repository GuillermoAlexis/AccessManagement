package com.app.AccessManagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.AccessManagement.dto.AccesoDTO;
import com.app.AccessManagement.model.Acceso;

@Mapper
public interface AccesoMapper {
	AccesoMapper INSTANCE = Mappers.getMapper(AccesoMapper.class);

	@Mapping(source = "usuario", target = "usuario")
	AccesoDTO toDTO(Acceso acceso);

	List<AccesoDTO> toDTOList(List<Acceso> accesos);

	@Mapping(source = "usuario", target = "usuario")
	Acceso toEntity(AccesoDTO accesoDTO);
}
