package com.api.formularyDB.dtos.request;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BancoDeDadosRequestDto {

    private int id_banco;
    private String servidor;
    private String usuario;
    private String senha;

    @NotBlank
    private TipoBancoDeDadosModel tipoBanco;


}



