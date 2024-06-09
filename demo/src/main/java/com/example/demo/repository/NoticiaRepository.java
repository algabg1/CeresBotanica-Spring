package com.example.demo.repository;

import com.example.demo.entity.NoticiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<NoticiaEntity, Long> {
}
