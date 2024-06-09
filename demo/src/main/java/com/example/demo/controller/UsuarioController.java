package com.example.demo.controller;

import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.jpaRepository.UsuarioJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends GenericController<UsuarioEntity, String>{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    /**
     *
     * @return retorna uma lista contendo todos os usuarios cadastrados
     */

    @GetMapping("/usuarios")
    @Override
    public ResponseEntity<List<UsuarioEntity>> listAll() {
        List<UsuarioEntity> pessoa = usuarioRepository.findAll();
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UsuarioEntity updatedPessoa) {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);

        if (usuarioEntityOptional.isPresent()) {
            UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
            usuarioEntity.setNome(updatedPessoa.getNome());
            usuarioEntity.setEmail(updatedPessoa.getEmail());
            usuarioEntity.setSenha(updatedPessoa.getSenha());
            this.usuarioRepository.save(usuarioEntity);
            return ResponseEntity.ok("usuario atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    @Override
    public ResponseEntity<String> create(@RequestBody UsuarioEntity usuario) {
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário criado com sucesso");
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);

        if (usuarioEntityOptional.isPresent()) {
            this.usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuário excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UsuarioEntity> getById(Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
