package com.example.demo.service;

import com.example.demo.entity.ProjetoEntity;
import com.example.demo.repository.ProjetoRepository;
import com.example.demo.repository.jpaRepository.ProjetoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService{

    @Autowired
    private ProjetoJpaRepository projetoJpaRepository;

}
