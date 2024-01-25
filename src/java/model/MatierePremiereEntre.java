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
public class MatierePremiereEntre {
  private  String  idMouvementStock; 
  private  String idMPremiere; 
  private  int mouvement; 
  private  Date dateEntre; 

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

    public Date getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(Date dateEntre) {
        this.dateEntre = dateEntre;
    }

    public MatierePremiereEntre(String idMPremiere, int mouvement, Date dateEntre) {
        this.idMPremiere = idMPremiere;
        this.mouvement = mouvement;
        this.dateEntre = dateEntre;
    }

    public MatierePremiereEntre(String idMouvementStock, String idMPremiere, int mouvement, Date dateEntre) {
        this.idMouvementStock = idMouvementStock;
        this.idMPremiere = idMPremiere;
        this.mouvement = mouvement;
        this.dateEntre = dateEntre;
    }
   
   
 
}
















