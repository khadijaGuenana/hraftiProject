package com.example.hraftiproject;

public class professionnel {
    String nomComplet,email, password , metier ,ville ,description;
    int numTel ,ID;
    public professionnel(String nomComplet, String email, String password, String metier, String ville,  int numTel, String description) {
        this.nomComplet = nomComplet;
        this.email = email;
        this.password = password;
        this.metier = metier;
        this.ville = ville;
        this.description = description;
        this.numTel = numTel;
    }

    public professionnel( int ID ,String nomComplet, String email, String password, String metier, String ville, int numTel, String description) {
        this.ID = ID;
        this.nomComplet = nomComplet;
        this.email = email;
        this.password = password;
        this.metier = metier;
        this.ville = ville;
        this.description = description;
        this.numTel = numTel;

    }
    public professionnel(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }
}
