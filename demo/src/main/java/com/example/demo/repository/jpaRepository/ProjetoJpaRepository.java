package com.example.demo.repository.jpaRepository;

import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjetoJpaRepository extends JpaRepository<ProjetoEntity, Long>, JpaSpecificationExecutor<ProjetoEntity> {
    @Query("SELECT p FROM projeto p JOIN FETCH p.usuario")
    List<ProjetoEntity> findAllWithUsuario();
}
