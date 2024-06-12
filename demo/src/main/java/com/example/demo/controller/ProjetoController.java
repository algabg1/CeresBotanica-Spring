package com.example.demo.controller;

import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.ProjetoRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projeto")
public class ProjetoController implements GenericController<ProjetoEntity, String>{

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @GetMapping("/projetos")
    public ResponseEntity<List<ProjetoEntity>> listAll() {
        List<ProjetoEntity>projetoEntities = projetoRepository.findAll();
        return ResponseEntity.ok(projetoEntities);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<String> update(Long id, ProjetoEntity updatedEntity) {
        Optional<ProjetoEntity> projetoEntityOptional = projetoRepository.findById(id);

        if (projetoEntityOptional.isPresent()) {
            ProjetoEntity projetoEntity = projetoEntityOptional.get();
            projetoEntity.setNome(updatedEntity.getNome());
            projetoEntity.setDescricao(updatedEntity.getDescricao());
            //Preciso dar um findById agora na pessoa
            this.projetoRepository.save(projetoEntity);
            return ResponseEntity.ok("usuario atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/criar")
    @Override
    public ResponseEntity<String> create(ProjetoEntity entity) {
        this.projetoRepository.save(entity);
        return ResponseEntity.ok("Usuário criado com sucesso");
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<ProjetoEntity> projetoEntityOptional = projetoRepository.findById(id);

        if (projetoEntityOptional.isPresent()) {
            this.projetoRepository.deleteById(id);
            return ResponseEntity.ok("Projeto excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoEntity> getById(@PathVariable Long id) {
        Optional<ProjetoEntity> projeto = projetoRepository.findById(id);
        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
