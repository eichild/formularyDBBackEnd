package com.api.formularyDB.models;

import com.api.formularyDB.dtos.request.BancoDeDadosRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_banco_de_dados")
public class BancoDeDadosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_banco;

    @NotBlank(message = "O campo Servidor não pode estar em branco")
    private String servidor;

    @NotBlank(message = "O campo Usuario não pode estar em branco")
    private String usuario;

    @NotBlank(message = "O campo Senha não pode estar em branco")
    private String senha;

    @NotBlank(message = "O campo de tipo de banco não pode estar em branco")
    private String tipo_banco;


    public BancoDeDadosModel converter(BancoDeDadosRequestDto b) {
        var bancoDeDados = new BancoDeDadosModel();
        bancoDeDados.setId_banco(b.getId_banco());
        bancoDeDados.setServidor(b.getServidor());
        bancoDeDados.setUsuario(b.getUsuario());
        bancoDeDados.setSenha(b.getSenha());
        bancoDeDados.setTipo_banco(getTipo_banco());
        return bancoDeDados;
    }
}
