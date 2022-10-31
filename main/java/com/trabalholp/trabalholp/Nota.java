package com.trabalholp.trabalholp;

import javafx.scene.paint.Color;

public class Nota {
    String texto;
    String titulo;
    Color cor;

    public Nota(String texto, String titulo, Color cor) {
        this.texto = texto;
        this.titulo = titulo;
        this.cor = cor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }


    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public Color getCor() {
        return cor;
    }
}
