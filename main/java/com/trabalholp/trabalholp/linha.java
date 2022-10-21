package com.trabalholp.trabalholp;

public class linha{

    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    private double estado;

    private String materia;

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

    public String getMateria() {
        return materia;
    }

    public linha(double nota1, double nota2, double nota3, double nota4, double estado, String materia) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.estado = estado;
        this.materia = materia;
    }
}
