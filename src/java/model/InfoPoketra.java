/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author Pc
 */
public class InfoPoketra {
    private String idInfoPoketra;
    private String idPoketra;
    private String nom;
    private String types;
    private String look;
    private int taille;
    private double prix;
     private double prixreviens;

    public double getPrixreviens() {
        return prixreviens;
    }

    public void setPrixreviens(double prixreviens) {
        this.prixreviens = prixreviens;
    }

     
     
     
    public String getIdInfoPoketra() {
        return idInfoPoketra;
    }

    public void setIdInfoPoketra(String idInfoPoketra) {
        this.idInfoPoketra = idInfoPoketra;
    }

    public String getIdPoketra() {
        return idPoketra;
    }

    public void setIdPoketra(String idPoketra) {
        this.idPoketra = idPoketra;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public InfoPoketra() {
    }

    public InfoPoketra(String idInfoPoketra, String idPoketra, String nom, String types, String look, int taille, double prix, double prixreviens) {
        this.idInfoPoketra = idInfoPoketra;
        this.idPoketra = idPoketra;
        this.nom = nom;
        this.types = types;
        this.look = look;
        this.taille = taille;
        this.prix = prix;
        this.prixreviens = prixreviens;
    }

    public InfoPoketra(String idPoketra, String nom, String types, String look, int taille, double prix, double prixreviens) {
        this.idPoketra = idPoketra;
        this.nom = nom;
        this.types = types;
        this.look = look;
        this.taille = taille;
        this.prix = prix;
        this.prixreviens = prixreviens;
    }

   
    
 

    
}
