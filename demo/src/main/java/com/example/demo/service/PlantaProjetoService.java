package com.example.demo.service;

import com.example.demo.entity.PlantaProjetoEntity;
import com.example.demo.entity.dto.PlantaProjetoDTO;
import com.example.demo.entity.dto.ProjetoDTO;
import com.example.demo.repository.jpaRepository.PlantaProjetoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaProjetoService {

    @Autowired
    private PlantaProjetoJpaRepository plantaProjetoJpaRepository;

    public boolean addPlantaProjeto (List<PlantaProjetoDTO> entity){
        try{
            for (int i = 0; i < entity.size(); i++) {
                PlantaProjetoDTO plantaProjetoDTO = entity.get(i);
                plantaProjetoJpaRepository.addPlantaProjeto(plantaProjetoDTO.idplanta(), plantaProjetoDTO.idprojeto());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public List<PlantaProjetoEntity> findAll() {
        return this.plantaProjetoJpaRepository.findAll();
    }

    public boolean delete(Long id) {
        if(plantaProjetoJpaRepository.existsById(id)){
            this.plantaProjetoJpaRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public List<PlantaProjetoEntity> listAllByIdProjeto(Long id) {
        return this.plantaProjetoJpaRepository.findByIdProjeto(id);
    }
}
