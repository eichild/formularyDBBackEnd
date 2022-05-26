package com.api.formularyDB.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BancoDeDadosRequestDto {

    private int id_banco;
    private String servidor;
    private String usuario;
    private String senha;
    private String tipo_banco;

}



