package com.example.demo.service;

import com.example.demo.entity.ComentarioEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.ComentarioDTO;
import com.example.demo.entity.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService extends GenericService<UsuarioEntity, UsuarioRepository>{


    public List<UsuarioDTO> getAllUsuarios() {
        List<UsuarioEntity> usuarios = getService().findAll();
        return usuarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }



    private UsuarioDTO convertToDTO(UsuarioEntity usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    @Override
    public List<UsuarioEntity> listAll() {
        return List.of();
    }

    @Override
    public UsuarioEntity update(Long id, UsuarioEntity updatedEntity) {
        Optional<UsuarioEntity> user = getService().findById(id);
        if (user.isPresent()) {
            UsuarioEntity existingUser = user.get();
            existingUser.setNome(updatedEntity.getNome());
            existingUser.setEmail(updatedEntity.getEmail());
            existingUser.setSenha(updatedEntity.getSenha());

            getService().save(existingUser);
            return updatedEntity;
        } else {
            return null;
        }
    }

    @Override
    public UsuarioEntity create(UsuarioEntity entity) {
        return null;
    }

    @Override
    public UsuarioEntity delete(Long id) {
        return null;
    }

    @Override
    public UsuarioEntity getById(Long id) {
        return null;
    }
}
