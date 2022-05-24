package com.api.formularyDB.models;

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
@Table(name = "tb_tipo_banco_de_dados")
public class TipoBancoDeDadosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo;

    @NotBlank(message = "O campo Tipo não pode estar em branco")
    private String tipo;


   public static TipoBancoDeDadosModel converter(TipoBancoDeDadosModel t){
        var tipoBancoDeDados = new TipoBancoDeDadosModel();
        tipoBancoDeDados.setId_tipo(t.getId_tipo());
        tipoBancoDeDados.setTipo(t.getTipo());
        return tipoBancoDeDados;
   }
}
