package com.example.demo.controller;

import com.example.demo.Enum.CategoriaEnum;
import com.example.demo.entity.PlantaEntity;
import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.PlantaDTO;
import com.example.demo.repository.PlantaRepository;
import com.example.demo.service.PlantaService;
import com.example.demo.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planta")
public class PlantaController{

    @Autowired
    private PlantaRepository plantaRepository;

    @Autowired
    private PlantaService plantaService;

    @GetMapping("/plantas")
    public ResponseEntity<Page<PlantaEntity>> listAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            Pageable pageable) {
        Page<PlantaEntity> plantaPage = plantaService.listAll(PageRequest.of(page, size));
        return ResponseEntity.ok(plantaPage);
    }

    @GetMapping("/get-planta-to-projeto")
    public ResponseEntity<List<PlantaEntity>> listAll(){
        return ResponseEntity.ok(this.plantaRepository.findAll());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody @Valid PlantaDTO entity, @PathVariable Long id){
        try {
            boolean isExecuted = plantaService.edit(entity, id);
            if(!isExecuted){
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("nao aconteceu nada");
            }
            return ResponseEntity.status(HttpStatus.OK).body("editado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping("/criar")
    public ResponseEntity<String> create(@RequestBody @Valid PlantaDTO entity) {
        plantaService.criar(entity);
        return ResponseEntity.ok("Planta criado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id) {
        Optional<PlantaEntity> plantaEntityOptional = plantaRepository.findById(id);

        if (plantaEntityOptional.isPresent()) {
            this.plantaRepository.deleteById(id);
            return ResponseEntity.ok("planta excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantaEntity> getById(Long id) {
        Optional<PlantaEntity> planta = plantaRepository.findById(id);
        if (planta.isPresent()) {
            return ResponseEntity.ok(planta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
