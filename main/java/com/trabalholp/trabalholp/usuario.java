package com.trabalholp.trabalholp;

public class usuario {

    String senha;
    String usuario;


    public usuario(String senha, String usuario) {
        this.senha = senha;
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
