package com.example.demo.service;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Não pode criar um usuario com o mesmo email
     * @return
     */
    public UsuarioService criarPessoa(UsuarioEntity usuarioEntity){
        return null;
    }
}
