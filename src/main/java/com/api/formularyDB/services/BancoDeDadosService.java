package com.api.formularyDB.services;

import com.api.formularyDB.dtos.request.BancoDeDadosRequestDto;
import com.api.formularyDB.dtos.response.BancoDeDadosResponseDto;
import com.api.formularyDB.exception.ObjectNotFoundException;
import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import com.api.formularyDB.repositories.BancoDeDadosRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoDeDadosService {

    @Autowired
    BancoDeDadosRepository bancoDeDadosRepository;

    @Autowired
    private ModelMapper mapper;


    public List<BancoDeDadosModel> findAll(){
        List<BancoDeDadosModel>bancoDeDadosModel= bancoDeDadosRepository.findAll();
        return bancoDeDadosModel;
    }
    public BancoDeDadosModel findById(int id_banco){
        Optional<BancoDeDadosModel> obj = bancoDeDadosRepository.findById(id_banco);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Informações de Banco não encontrada! ID:" +id_banco));
    }
    public BancoDeDadosModel save(BancoDeDadosRequestDto objDTO){
        return bancoDeDadosRepository.save(mapper.map(objDTO, BancoDeDadosModel.class));
    }

    public BancoDeDadosModel update(int id_banco, BancoDeDadosModel bancoRequest) {
        BancoDeDadosModel banco = bancoDeDadosRepository.findById(id_banco)
                .orElseThrow(() -> new ObjectNotFoundException("Informações de Banco não encontrada! ID:" + id_banco));
        banco.setServidor(bancoRequest.getServidor());
        banco.setUsuario(bancoRequest.getUsuario());
        banco.setUsuario(bancoRequest.getUsuario());
        banco.setTipo_banco(bancoRequest.getTipo_banco());
        return bancoDeDadosRepository.save(banco);
    }


}
