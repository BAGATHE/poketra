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
public class PoketraMP {
   private String idPoketraMP;
   private String idPoketra;
   private String idMPremiere;
   private int quantite;
   private double prixTotalMp;

    public double getPrixTotalMp() {
        return prixTotalMp;
    }

    public void setPrixTotalMp(double prixTotalMp) {
        this.prixTotalMp = prixTotalMp;
    }
    
    
    
    
    
    
    public String getIdPoketraMP() {
        return idPoketraMP;
    }

    public void setIdPoketraMP(String idPoketraMP) {
        this.idPoketraMP = idPoketraMP;
    }

    public String getIdPoketra() {
        return idPoketra;
    }

    public void setIdPoketra(String idPoketra) {
        this.idPoketra = idPoketra;
    }

    public String getIdMPremiere() {
        return idMPremiere;
    }

    public void setIdMPremiere(String idMPremiere) {
        this.idMPremiere = idMPremiere;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    

    public PoketraMP() {
    }

    public PoketraMP(String idPoketra, String idMPremiere, int quantite, double prixTotalMp) {
        this.idPoketra = idPoketra;
        this.idMPremiere = idMPremiere;
        this.quantite = quantite;
        this.prixTotalMp = prixTotalMp;
    }

    public PoketraMP(String idPoketraMP, String idPoketra, String idMPremiere, int quantite, double prixTotalMp) {
        this.idPoketraMP = idPoketraMP;
        this.idPoketra = idPoketra;
        this.idMPremiere = idMPremiere;
        this.quantite = quantite;
        this.prixTotalMp = prixTotalMp;
    }
    
       public PoketraMP( String idPoketra,double prixTotalMp) {

        this.idPoketra = idPoketra;
        
       
        this.prixTotalMp = prixTotalMp;
    }
  
}
