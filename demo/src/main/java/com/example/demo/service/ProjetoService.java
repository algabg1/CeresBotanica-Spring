package com.example.demo.service;

import com.example.demo.Enum.TipoProjetoEnum;
import com.example.demo.entity.dto.ProjetoDTO;
import com.example.demo.repository.jpaRepository.ProjetoJpaRepository;
import com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

@Service
public class ProjetoService{

    @Autowired
    private ProjetoJpaRepository projetoJpaRepository;

    /**
     *
     * @param entity espera receber um DTO
     * @return boolean confirmando se deu tudo certo
     */
    public boolean criarProjeto(ProjetoDTO entity){
        try {
            boolean findSomething = Utils.findMatchEnum(entity.tipo_projeto(), TipoProjetoEnum.class);
            if(findSomething){
                projetoJpaRepository.adicionarProjeto(entity.nome(), entity.descricao(), entity.idUsuario(), entity.tipo_projeto());
                return true;
            }
            return false;
        }
        catch (Exception e){
            throw new IllegalArgumentException("Houve um erro critico");
        }
    }

}
