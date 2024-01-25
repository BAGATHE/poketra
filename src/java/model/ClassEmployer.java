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
public class ClassEmployer {
private String idClasseEmployer;
private String typeclasse;

    public ClassEmployer(String typeclasse) {
        this.typeclasse = typeclasse;
    }

    public ClassEmployer(String idClasseEmployer, String typeclasse) {
        this.idClasseEmployer = idClasseEmployer;
        this.typeclasse = typeclasse;
    }

    public String getIdClasseEmployer() {
        return idClasseEmployer;
    }

    public void setIdClasseEmployer(String idClasseEmployer) {
        this.idClasseEmployer = idClasseEmployer;
    }

    public String getTypeclasse() {
        return typeclasse;
    }

    public void setTypeclasse(String typeclasse) {
        this.typeclasse = typeclasse;
    }


    
}
