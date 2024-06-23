package com.example.demo.service;

import com.example.demo.Enum.TipoProjetoEnum;
import com.example.demo.entity.dto.ProjetoDTO;
import com.example.demo.repository.jpaRepository.ProjetoJpaRepository;
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
            AtomicBoolean findSomething = new AtomicBoolean(false);
            Stream.of(TipoProjetoEnum.values()).forEach((x) ->{
                if(x.toString().equalsIgnoreCase(entity.tipo_projeto())){
                    findSomething.set(true);
                }
            });
            if(findSomething.get()){
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
