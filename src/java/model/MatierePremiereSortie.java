/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;

/**
 *
 * @author Pc
 */
public class MatierePremiereSortie {
   private String  idMouvementStock; 
   private String idMPremiere; 
   private int mouvement; 
   private Date dateSortie; 

    public String getIdMouvementStock() {
        return idMouvementStock;
    }

    public void setIdMouvementStock(String idMouvementStock) {
        this.idMouvementStock = idMouvementStock;
    }

    public String getIdMPremiere() {
        return idMPremiere;
    }

    public void setIdMPremiere(String idMPremiere) {
        this.idMPremiere = idMPremiere;
    }

    public int getMouvement() {
        return mouvement;
    }

    public void setMouvement(int mouvement) {
        this.mouvement = mouvement;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public MatierePremiereSortie(String idMPremiere, int mouvement, Date dateSortie) {
        this.idMPremiere = idMPremiere;
        this.mouvement = mouvement;
        this.dateSortie = dateSortie;
    }

    public MatierePremiereSortie(String idMouvementStock, String idMPremiere, int mouvement, Date dateSortie) {
        this.idMouvementStock = idMouvementStock;
        this.idMPremiere = idMPremiere;
        this.mouvement = mouvement;
        this.dateSortie = dateSortie;
    }
}
