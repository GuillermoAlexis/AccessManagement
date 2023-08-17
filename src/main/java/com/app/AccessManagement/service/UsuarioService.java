package com.app.AccessManagement.service;

import com.app.AccessManagement.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> listarUsuarios();

    UsuarioDTO obtenerUsuarioPorId(String idUsuario);

    UsuarioDTO actualizarUsuario(String idUsuario, UsuarioDTO usuarioActualizadoDTO);

    void eliminarUsuario(String idUsuario);

    UsuarioDTO login(String email, String contrasena);
}
