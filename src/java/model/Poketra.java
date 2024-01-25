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
public class Poketra {
private String idPoketra;
private String idLook;
private String idType;

    public Poketra(String idPoketra, String idLook, String idType) {
        this.idPoketra = idPoketra;
        this.idLook = idLook;
        this.idType = idType;
    }
    public Poketra(String idLook, String idType) {
        this.idLook = idLook;
        this.idType = idType;
    }

    public Poketra() {
    }

    public String getIdPoketra() {
        return idPoketra;
    }

    public void setIdPoketra(String idPoketra) {
        this.idPoketra = idPoketra;
    }

    public String getIdLook() {
        return idLook;
    }

    public void setIdLook(String idLook) {
        this.idLook = idLook;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }


}
