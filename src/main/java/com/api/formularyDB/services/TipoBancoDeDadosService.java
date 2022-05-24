package com.api.formularyDB.services;

import com.api.formularyDB.exception.ObjectNotFoundException;
import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import com.api.formularyDB.repositories.TipoBancoDeDadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoBancoDeDadosService {

    @Autowired
    private TipoBancoDeDadosRepository tipoBancoDeDadosRepository;

    public List<TipoBancoDeDadosModel> findAll(){
        List<TipoBancoDeDadosModel> tipoBancoDeDadosModel= tipoBancoDeDadosRepository.findAll();
        return tipoBancoDeDadosModel;
    }
    public TipoBancoDeDadosModel findById(int id_tipo){
        Optional<TipoBancoDeDadosModel> obj = tipoBancoDeDadosRepository.findById(id_tipo);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Tipo de banco não encontrado! ID:" +id_tipo));
    }
    public TipoBancoDeDadosModel save(TipoBancoDeDadosModel tipoBanco){
        return tipoBancoDeDadosRepository.save(tipoBanco);
    }
}
