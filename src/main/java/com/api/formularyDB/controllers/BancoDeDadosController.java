package com.api.formularyDB.controllers;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.repositories.BancoDeDadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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

    @PutMapping("{id}")
    public ResponseEntity<BancoDeDadosModel> update (@PathVariable(value = "id") int id, @RequestBody @Valid BancoDeDadosModel banco){
        Optional<BancoDeDadosModel> banco0 = bancoDeDadosRepository.findById(id);
        if (!banco0.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        banco.setId(banco0.get().getId());
        return new ResponseEntity<BancoDeDadosModel>(bancoDeDadosRepository.save(banco), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        Optional<BancoDeDadosModel> banco = bancoDeDadosRepository.findById(id);
        if (!banco.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bancoDeDadosRepository.delete(banco.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}