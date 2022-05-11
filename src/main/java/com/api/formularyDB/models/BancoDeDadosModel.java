package com.api.formularyDB.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Entity
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

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public TipoBancoDeDadosModel getTipoBanco() {
        return tipoBanco;
    }

    public void setTipoBanco(TipoBancoDeDadosModel tipoBanco) {
        this.tipoBanco = tipoBanco;
    }

    @OneToOne
    @JoinColumn(name = "id_tipo")
    private TipoBancoDeDadosModel tipoBanco;

    public int getId() {
        return id_banco;
    }

    public void setId(int id) {
        this.id_banco = id;
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

    public static BancoDeDadosModel converter(BancoDeDadosModel b) {
        var bancoDeDados = new BancoDeDadosModel();
        bancoDeDados.setId(b.getId());
        bancoDeDados.setServidor(b.getServidor());
        bancoDeDados.setUsuario(b.getUsuario());
        bancoDeDados.setSenha(b.getSenha());
        return b;
    }
}
