package com.example.demo.service;

import com.example.demo.entity.ComentarioEntity;
import com.example.demo.entity.dto.ComentarioDTO;
import com.example.demo.repository.ComentarioRepository;
import com.example.demo.repository.jpaRepository.ComentarioJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ComentarioJpaRepository comentarioJpaRepository;

    public List<ComentarioDTO> getAllComentarios() {
        List<ComentarioEntity> comentarios = comentarioJpaRepository.findComentariosWithUser();

        return comentarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ComentarioDTO convertToDTO(ComentarioEntity comentario) {
        ComentarioDTO dto = new ComentarioDTO();
        dto.setIdcomentario(comentario.getIdcomentario());
        dto.setConteudo(comentario.getConteudo());
        dto.setNomeUsuario(comentario.getUsuario().getNome());
        return dto;
    }
}
