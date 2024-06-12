package com.example.demo.service;

import com.example.demo.entity.ComentarioEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.ComentarioDTO;
import com.example.demo.entity.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    //teste
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAllUsuarios() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UsuarioDTO convertToDTO(UsuarioEntity usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}
