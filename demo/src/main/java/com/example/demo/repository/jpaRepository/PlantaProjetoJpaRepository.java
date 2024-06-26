package com.example.demo.repository.jpaRepository;

import com.example.demo.entity.PlantaProjetoEntity;
import com.example.demo.entity.ProjetoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlantaProjetoJpaRepository
        extends JpaRepository<PlantaProjetoEntity, Long>, JpaSpecificationExecutor<PlantaProjetoEntity> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO plantaprojeto (idplanta, idprojeto) VALUES ( ?1, ?2)", nativeQuery = true)
    void addPlantaProjeto(Long idplanta, Long idprojeto);

    @Query("SELECT p FROM plantaprojeto p WHERE p.projeto.idProjeto = :idprojeto")
    List<PlantaProjetoEntity> findByIdProjeto(@Param("idprojeto") Long idprojeto);
}
