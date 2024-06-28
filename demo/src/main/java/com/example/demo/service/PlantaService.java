package com.example.demo.service;

import com.example.demo.Enum.CategoriaEnum;
import com.example.demo.controller.PlantaController;
import com.example.demo.entity.PlantaEntity;
import com.example.demo.entity.dto.PlantaDTO;
import com.example.demo.repository.PlantaRepository;
import com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlantaService {
    @Autowired
    private PlantaRepository plantaRepository;

    public boolean criar(PlantaDTO entity) {
        PlantaEntity plantaEntity = new PlantaEntity();
        try {
            if (Utils.findMatchEnum(entity.categoria(), CategoriaEnum.class)) {
                plantaEntity.setCategoria(CategoriaEnum.valueOf(entity.categoria().toUpperCase()));
                plantaEntity.setNome(entity.nome());
                plantaEntity.setOrigem(entity.origem());
                plantaEntity.setCuidados(entity.cuidados());
                plantaEntity.setNome_cientifico(entity.nome_cientifico());
                plantaEntity.setDescricao(entity.descricao());
                plantaEntity.setDataregistro(Date.valueOf(entity.dataregistro()));
                //plantaEntity.setImagem(null);
                plantaRepository.save(plantaEntity);
                return true;
            }
            return false;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Page<PlantaEntity> listAll(Pageable pageable){
        return this.plantaRepository.findAll(pageable);
    }


    public boolean edit(PlantaDTO entity, Long id) throws Exception{
        Optional<PlantaEntity> plantaOptional = plantaRepository.findById(id);
        if (plantaOptional.isPresent()) {
            PlantaEntity plantaEntity = plantaOptional.get();
            plantaEntity.setNome(entity.nome());
            plantaEntity.setNome_cientifico(entity.nome_cientifico());
            plantaEntity.setDescricao(entity.descricao());
            plantaEntity.setOrigem(entity.origem());
            plantaEntity.setCuidados(entity.cuidados());
            Date date;
            plantaEntity.setDataregistro(Date.valueOf(entity.dataregistro()));
            if(!Utils.findMatchEnum(entity.categoria(), CategoriaEnum.class)){throw new RuntimeException("Enum invalido");}
            plantaEntity.setCategoria(CategoriaEnum.valueOf(entity.categoria().toUpperCase()));
            plantaRepository.save(plantaEntity);
            return true;
        } else {
            return false;
        }
    }

    public List<PlantaEntity> findAll(){
        return this.plantaRepository.findAll();
    }

}
