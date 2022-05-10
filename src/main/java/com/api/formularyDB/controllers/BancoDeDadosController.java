package com.api.formularyDB.controllers;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import com.api.formularyDB.repositories.BancoDeDadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/banco-de-dados")
public class BancoDeDadosController {

    @Autowired
    BancoDeDadosRepository bancoDeDadosRepository;

    @GetMapping
    public List<BancoDeDadosModel> findAll() {
        var tipo = bancoDeDadosRepository.findAll();
        return tipo
                .stream()
                .map(BancoDeDadosModel::converter)
                .collect(Collectors.toList());
    }

        @PostMapping
    public ResponseEntity<BancoDeDadosModel> save(@RequestBody @Valid BancoDeDadosModel banco){
        return new ResponseEntity<BancoDeDadosModel>(bancoDeDadosRepository.save(banco), HttpStatus.CREATED);
    }




}