package com.api.formularyDB.controllers;

import com.api.formularyDB.exception.ObjectNotFoundException;
import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import com.api.formularyDB.repositories.TipoBancoDeDadosRepository;
import com.api.formularyDB.services.TipoBancoDeDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/tipo-banco-de-dados")
public class TipoBancoDeDadosController {

    @Autowired
    TipoBancoDeDadosService tipoBancoDeDadosService;

    @GetMapping
    public ResponseEntity<List<TipoBancoDeDadosModel>> findAll() {
        return ResponseEntity.ok(tipoBancoDeDadosService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoBancoDeDadosModel> findById(@PathVariable("id") int id_tipo){
        TipoBancoDeDadosModel obj = tipoBancoDeDadosService.findById(id_tipo);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<TipoBancoDeDadosModel> save(@RequestBody TipoBancoDeDadosModel tipoBanco){
        tipoBanco = tipoBancoDeDadosService.save(tipoBanco);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoBanco);
    }
//    @PostMapping
//    public ResponseEntity<TipoBancoDeDadosModel> save(@RequestBody @Valid TipoBancoDeDadosModel tipoBanco){
//        return new ResponseEntity<TipoBancoDeDadosModel>(tipoBancoDeDadosRepository.save(tipoBanco), HttpStatus.CREATED);
//    }
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> delete(@PathVariable(value = "id")  int id){
//        Optional<TipoBancoDeDadosModel> tipoBanco = tipoBancoDeDadosRepository.findById(id);
//        if (!tipoBanco.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        tipoBancoDeDadosRepository.delete(tipoBanco.get());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @PutMapping("{id}")
//    public ResponseEntity<TipoBancoDeDadosModel> update(@PathVariable(value = "id") int id, @RequestBody @Valid TipoBancoDeDadosModel tipoBanco){
//        Optional<TipoBancoDeDadosModel> tipoBanco0 = tipoBancoDeDadosRepository.findById(id);
//        if (!tipoBanco0.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        tipoBanco.setId_tipo(tipoBanco0.get().getId_tipo());
//        return new ResponseEntity<TipoBancoDeDadosModel>(tipoBancoDeDadosRepository.save(tipoBanco), HttpStatus.OK);
//
//    }

}
