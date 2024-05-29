package com.example.tp_note;

public class Pizza {
    private String nom;
    private int prix;
    private int nombreIngredients;

    public Pizza(String nom, int prix, int nombreIngredients) {
        this.nom = nom;
        this.prix = prix;
        this.nombreIngredients = nombreIngredients;
    }

    public Pizza(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNombreIngredients() {
        return nombreIngredients;
    }

    public void setNombreIngredients(int nombreIngredients) {
        this.nombreIngredients = nombreIngredients;
    }
}
