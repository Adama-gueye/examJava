package com.exam_java.exam_java;

public class Employe {

    private int idE;
    private String nomE;
    private String prenomE;
    private String emailE;
    private Departement dept;

    public Employe() {
    }

    public Employe(int idE, String nomE, String prenomE, String emailE, Departement dept) {
        this.idE = idE;
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.emailE = emailE;
        this.dept = dept;
    }

    public int getIdE() {
        return idE;
    }
    public String toString() {
        return nomE+prenomE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }
}
