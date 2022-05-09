package com.api.formularyDB.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_BANCO_DE_DADOS")
public class BancoDeDadosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "O campo Servidor não pode estar em branco")
    private String servidor;

    @NotBlank(message = "O campo Usuario não pode estar em branco")
    @Column(nullable = false, length = 255)
    private String usuario;

    @NotBlank(message = "O campo Senha não pode estar em branco")
    @Column(nullable = false, length = 255)
    private String senha;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private TipoBancoDeDadosModel tipoBanco;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
