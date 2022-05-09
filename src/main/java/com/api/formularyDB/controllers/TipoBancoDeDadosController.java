package com.api.formularyDB.controllers;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import com.api.formularyDB.repositories.TipoBancoDeDadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tipo-banco-de-dados")
public class TipoBancoDeDadosController {

    @Autowired
    TipoBancoDeDadosRepository tipoBancoDeDadosRepository;

    @PostMapping
    public ResponseEntity<TipoBancoDeDadosModel> save(@RequestBody @Valid TipoBancoDeDadosModel tipoBanco){
        return new ResponseEntity<TipoBancoDeDadosModel>(tipoBancoDeDadosRepository.save(tipoBanco), HttpStatus.CREATED);
    }

}
