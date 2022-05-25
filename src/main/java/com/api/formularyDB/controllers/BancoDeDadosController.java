package com.api.formularyDB.controllers;

import com.api.formularyDB.config.ModelMapperConfig;
import com.api.formularyDB.dtos.request.BancoDeDadosRequestDto;
import com.api.formularyDB.dtos.response.BancoDeDadosResponseDto;
import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.repositories.BancoDeDadosRepository;
import com.api.formularyDB.services.BancoDeDadosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.yaml.snakeyaml.events.Event;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/banco-de-dados")
public class BancoDeDadosController {
    @Autowired
    BancoDeDadosService bancoDeDadosService;

    @Autowired
    BancoDeDadosRepository bancoDeDadosRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<BancoDeDadosResponseDto>> findAll() {
        List<BancoDeDadosResponseDto> listDTO = bancoDeDadosService.findAll().stream().map(obj -> new BancoDeDadosResponseDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<BancoDeDadosResponseDto> findById(@PathVariable("id") int id_banco){
        BancoDeDadosResponseDto objDTO = new BancoDeDadosResponseDto(bancoDeDadosService.findById(id_banco));
        return ResponseEntity.ok().body(objDTO);
    }
    @PostMapping
    public ResponseEntity<BancoDeDadosRequestDto> save(@RequestBody BancoDeDadosRequestDto objDTO) {

        BancoDeDadosModel bancoRequest = modelMapper.map(objDTO, BancoDeDadosModel.class);
        BancoDeDadosModel banco = bancoDeDadosService.save(objDTO);
        BancoDeDadosRequestDto bancoResponse = modelMapper.map(banco, BancoDeDadosRequestDto.class);
        return new ResponseEntity<BancoDeDadosRequestDto>(bancoResponse, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<BancoDeDadosRequestDto> update (@PathVariable(value = "id") int id_banco, @RequestBody BancoDeDadosRequestDto objDTO){
        BancoDeDadosModel bancoRequest = modelMapper.map(objDTO, BancoDeDadosModel.class);
        BancoDeDadosModel banco = bancoDeDadosService.save(objDTO);
        BancoDeDadosRequestDto bancoResponse = modelMapper.map(banco, BancoDeDadosRequestDto.class);
        return ResponseEntity.ok().body(bancoResponse);
    }
//
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