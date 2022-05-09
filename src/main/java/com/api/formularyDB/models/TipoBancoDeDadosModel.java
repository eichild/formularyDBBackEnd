package com.api.formularyDB.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_TIPO_BANCO_DE_DADOS")
public class TipoBancoDeDadosModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    @NotBlank(message = "O campo Tipo não pode estar em branco")
    private String tipo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   public static TipoBancoDeDadosModel converter(TipoBancoDeDadosModel t){
        var tipoBancoDeDados = new TipoBancoDeDadosModel();
        tipoBancoDeDados.setId(t.getId());
        tipoBancoDeDados.setTipo(t.getTipo());
        return tipoBancoDeDados;
   }
}
