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
public class MatierePremiere {
  private String idMPremiere;
  private String materiaux;
  private double prix;

    public MatierePremiere(String idMPremiere, String materiaux, double prix) {
        this.idMPremiere = idMPremiere;
        this.materiaux = materiaux;
        this.prix = prix;
    }

    public MatierePremiere(String materiaux, double prix) {
        this.materiaux = materiaux;
        this.prix = prix;
    }

    public MatierePremiere() {
    }

    public String getIdMPremiere() {
        return idMPremiere;
    }

    public void setIdMPremiere(String idMPremiere) {
        this.idMPremiere = idMPremiere;
    }

    public String getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(String materiaux) {
        this.materiaux = materiaux;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
     
}
