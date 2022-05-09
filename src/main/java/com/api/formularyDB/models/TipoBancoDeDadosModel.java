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
}
