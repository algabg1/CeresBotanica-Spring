package com.example.demo.repository.jpaRepository;

import com.example.demo.entity.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioJpaRepository extends JpaRepository<ComentarioEntity, Long> {
    @Query("SELECT c FROM comentario c")
    List<ComentarioEntity> findComentariosWithUser();
}
