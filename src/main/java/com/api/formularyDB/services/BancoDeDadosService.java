package com.api.formularyDB.services;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.repositories.BancoDeDadosRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BancoDeDadosService {

    final BancoDeDadosRepository bancoDeDadosRepository;

    public BancoDeDadosService(BancoDeDadosRepository bancoDeDadosRepository) {
        this.bancoDeDadosRepository = bancoDeDadosRepository;
    }

    @Transactional
    public BancoDeDadosModel save(BancoDeDadosModel bancoDeDadosModel){
        return bancoDeDadosRepository.save(bancoDeDadosModel);
    }
}
