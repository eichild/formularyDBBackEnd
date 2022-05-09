package com.api.formularyDB.controllers;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.services.BancoDeDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/banco-de-dados")
public class BancoDeDadosController {

    @Autowired
    BancoDeDadosService bancoDeDadosService;


}