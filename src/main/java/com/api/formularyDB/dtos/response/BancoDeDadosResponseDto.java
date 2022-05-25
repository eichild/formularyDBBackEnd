package com.api.formularyDB.dtos.response;

import com.api.formularyDB.models.BancoDeDadosModel;
import com.api.formularyDB.models.TipoBancoDeDadosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BancoDeDadosResponseDto {

    private int id_banco;
    private String servidor;
    private String usuario;
    private String senha;
    private String tipo_banco;


    public BancoDeDadosResponseDto(BancoDeDadosModel obj){
        super();
        this.id_banco = obj.getId_banco();
        this.servidor = obj.getServidor();
        this.usuario = obj.getUsuario();
        this.senha = obj.getSenha();
        this.tipo_banco = obj.getTipo_banco();

    }


}
