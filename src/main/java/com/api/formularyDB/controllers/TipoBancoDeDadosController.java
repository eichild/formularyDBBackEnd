package com.api.formularyDB.controllers;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import com.api.formularyDB.repositories.TipoBancoDeDadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipo-banco-de-dados")
public class TipoBancoDeDadosController {

    @Autowired
    TipoBancoDeDadosRepository tipoBancoDeDadosRepository;

    @GetMapping
    public List<TipoBancoDeDadosModel> findAll(){
        var tipo = tipoBancoDeDadosRepository.findAll();
        return tipo
                .stream()
                .map(TipoBancoDeDadosModel::converter)
                .collect(Collectors.toList());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity consultar(@PathVariable("id")UUID id){
        return tipoBancoDeDadosRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoBancoDeDadosModel> save(@RequestBody @Valid TipoBancoDeDadosModel tipoBanco){
        return new ResponseEntity<TipoBancoDeDadosModel>(tipoBancoDeDadosRepository.save(tipoBanco), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id")  UUID id){
        Optional<TipoBancoDeDadosModel> tipoBanco = tipoBancoDeDadosRepository.findById(id);
        if (!tipoBanco.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipoBancoDeDadosRepository.delete(tipoBanco.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipoBancoDeDadosModel> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid TipoBancoDeDadosModel tipoBanco){
        Optional<TipoBancoDeDadosModel> tipoBanco0 = tipoBancoDeDadosRepository.findById(id);
        if (!tipoBanco0.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipoBanco.setId(tipoBanco0.get().getId());
        return new ResponseEntity<TipoBancoDeDadosModel>(tipoBancoDeDadosRepository.save(tipoBanco), HttpStatus.OK);

    }

}
