package com.exam_java.exam_java;

public class Departement {

     private int idD;
     private String nomD;

    public Departement() {
    }

    public Departement(int idD, String nomD) {
        this.idD = idD;
        this.nomD = nomD;
    }
    public String toString() {
        return nomD;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    public String getNomD() {
        return nomD;
    }

    public void setNomD(String nomD) {
        this.nomD = nomD;
    }
}
