package com.trabalholp.trabalholp;

public class linha{

    private int numero;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double estado;
    private String estado2;
    private String materia;


    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getNumero() {
        return numero;
    }
    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public double getEstado() {
        return estado;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2){
        this.estado2 = estado2;
    }

    public String getMateria() {
        return materia;
    }

    public linha(double nota1, double nota2, double nota3, double nota4, String materia, Integer numero, Integer media) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.materia = materia;
        this.numero = numero;

        atualizarEstado(media);
    }

    public void atualizarEstado(int media) {
        this.estado = (nota1+nota2+nota3+nota4)-media;

        if (estado >= 0)
            this.estado2 = "Aprovado";
        else
            this.estado2 = "Reprovado";
    }
}
