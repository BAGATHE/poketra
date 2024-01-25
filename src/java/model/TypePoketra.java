/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class TypePoketra {
      String idTypePoketra;
      String nom;

    public TypePoketra(String id,String nom) {
        this.idTypePoketra = id;
        this.nom = nom;
    }

    public TypePoketra(String nom) {
        this.nom = nom;
    }

    
    
    
    
    public TypePoketra() {
    }
   
   
    public String getIdTypePoketra() {
        return idTypePoketra;
    }

    public void setIdTypePoketra(String idTypePoketra) {
        this.idTypePoketra = idTypePoketra;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
     
 
 
}
