package com.example.demo.controller;

import com.example.demo.entity.ComentarioEntity;
import com.example.demo.entity.dto.ComentarioDTO;
import com.example.demo.repository.ComentarioRepository;
import com.example.demo.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController implements GenericController<ComentarioEntity, String> {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<ComentarioEntity>> listAll() {
        return null;
    }

    @GetMapping("/comentarios")
    public List<ComentarioDTO> getAllComentarios() {
        return comentarioService.getAllComentarios();
    }

    @Override
    public ResponseEntity<String> update(Long id, ComentarioEntity updatedEntity) {
        return null;
    }

    @Override
    public ResponseEntity<String> create(ComentarioEntity entity) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ComentarioEntity> getById(Long id) {
        return null;
    }
}
