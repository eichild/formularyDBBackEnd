package com.api.formularyDB.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_tipo_banco_de_dados")
public class TipoBancoDeDadosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo;

    @NotBlank(message = "O campo Tipo não pode estar em branco")
    private String tipo;

    public int getId_tipo() {
        return id_tipo;
    }
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   public static TipoBancoDeDadosModel converter(TipoBancoDeDadosModel t){
        var tipoBancoDeDados = new TipoBancoDeDadosModel();
        tipoBancoDeDados.setId_tipo(t.getId_tipo());
        tipoBancoDeDados.setTipo(t.getTipo());
        return tipoBancoDeDados;
   }
}
