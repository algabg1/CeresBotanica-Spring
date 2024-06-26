package com.example.demo.controller;

import com.example.demo.entity.PlantaEntity;
import com.example.demo.entity.PlantaProjetoEntity;
import com.example.demo.entity.dto.PlantaProjetoDTO;
import com.example.demo.repository.PlantaProjetoRepository;
import com.example.demo.service.PlantaProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto-planta")
public class PlantaProjetoController implements GenericController<PlantaProjetoEntity, String> {

    @Autowired
    private PlantaProjetoService plantaProjetoService;


    @PostMapping("/adicionar-planta-projeto")
    public ResponseEntity<?> addPlantaProjeto(@RequestBody List<PlantaProjetoDTO> entity){
        boolean executed = this.plantaProjetoService.addPlantaProjeto(entity);
        if(executed){
            return ResponseEntity.status(HttpStatus.CREATED).body("planta(s) adicionadas");
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("erro");
    }


    @DeleteMapping("/remover-planta/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.plantaProjetoService.delete(id)){
            return ResponseEntity.ok("deletado");
        }
        return ResponseEntity.badRequest().body("Deu ruim");
    }


    /**
     *
     * @return retorna uma lista de todos os registros de plantas em todos os projetos. Apenas para depuraçao
     */
    @GetMapping("/minhas-plantas/{id}")
    public ResponseEntity<List<PlantaProjetoEntity>> listAll(@PathVariable Long id) {
        List<PlantaProjetoEntity>plantaProjetoEntities = this.plantaProjetoService.listAllByIdProjeto(id);
        return ResponseEntity.ok(plantaProjetoEntities);
    }



    // tudo aqui para baixo está deprecated.
    /**
     *
     * @param id
     * @return
     */
    @Deprecated
    @Override
    public ResponseEntity<PlantaProjetoEntity> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PlantaProjetoEntity>> listAll() {
        return null;
    }

    @Deprecated
    @Override
    public ResponseEntity<String> update(Long id, PlantaProjetoEntity updatedEntity) {
        return null;
    }

    @Deprecated
    @Override
    public ResponseEntity<String> create(PlantaProjetoEntity entity) {
        return null;
    }
}
