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
public class LookPoketra {
 private String idLookPoketra;
 private String nomLook;

    public LookPoketra(String idLookPoketra, String nomLook) {
        this.idLookPoketra = idLookPoketra;
        this.nomLook = nomLook;
    }
    
    public LookPoketra(String nomLook) {
        this.nomLook = nomLook;
    }


    public LookPoketra() {
    }

    public String getIdLookPoketra() {
        return idLookPoketra;
    }

    public void setIdLookPoketra(String idLookPoketra) {
        this.idLookPoketra = idLookPoketra;
    }

    public String getNomLook() {
        return nomLook;
    }

    public void setNomLook(String nomLook) {
        this.nomLook = nomLook;
    }
   
}
