package com.api.formularyDB.controllers;

import com.api.formularyDB.exception.ObjectNotFoundException;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import com.api.formularyDB.repositories.TipoBancoDeDadosRepository;
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
    TipoBancoDeDadosRepository tipoBancoDeDadosRepository;


    @GetMapping
    public List<TipoBancoDeDadosModel> findAll() {
        return tipoBancoDeDadosRepository.findAll();
//        return tipo
//                .stream()
//                .map(BancoDeDadosModel::converter)
//                .collect(Collectors.toList());
    }
//    @GetMapping(value = "/{id}")
//    public ResponseEntity consultar(@PathVariable("id") int id_tipo){
//        return tipoBancoDeDadosRepository.findById(id_tipo)
//                .map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
//    }
    @GetMapping(value = "/{id}")
    public TipoBancoDeDadosModel consultar(@PathVariable("id") int id_tipo){
        Optional<TipoBancoDeDadosModel> tipoBanco = this.tipoBancoDeDadosRepository.findById(id_tipo);
        return tipoBanco.orElseThrow(() -> new ObjectNotFoundException("Tipo de banco não encontrado! ID:" +id_tipo));
    }
    @PostMapping
    public ResponseEntity<TipoBancoDeDadosModel> save(@RequestBody @Valid TipoBancoDeDadosModel tipoBanco){
        return new ResponseEntity<TipoBancoDeDadosModel>(tipoBancoDeDadosRepository.save(tipoBanco), HttpStatus.CREATED);
    }
//    @PostMapping
//    public TipoBancoDeDadosModel save (@RequestBody TipoBancoDeDadosModel tipo){
//        return tipoBancoDeDadosRepository.save(tipo);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id")  int id){
        Optional<TipoBancoDeDadosModel> tipoBanco = tipoBancoDeDadosRepository.findById(id);
        if (!tipoBanco.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipoBancoDeDadosRepository.delete(tipoBanco.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipoBancoDeDadosModel> update(@PathVariable(value = "id") int id, @RequestBody @Valid TipoBancoDeDadosModel tipoBanco){
        Optional<TipoBancoDeDadosModel> tipoBanco0 = tipoBancoDeDadosRepository.findById(id);
        if (!tipoBanco0.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipoBanco.setId_tipo(tipoBanco0.get().getId_tipo());
        return new ResponseEntity<TipoBancoDeDadosModel>(tipoBancoDeDadosRepository.save(tipoBanco), HttpStatus.OK);

    }

}
