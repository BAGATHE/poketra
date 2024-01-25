/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.PoketraMP;

/**
 *
 * @author Pc
 */
public class PoketraMPDao {
      
    
    public static List<PoketraMP> getAllPoketraMp() throws SQLException {
    StringBuilder url = new StringBuilder();
    url.append("SELECT idPoketra, SUM(prixTotalMp)as prixTotalMp FROM poketramp GROUP BY idPoketra");
    List<PoketraMP> poketras = new ArrayList<>();

    try (Connection connection = new Connect().dbConnect("postgres");
         Statement stmt = connection.createStatement();
         ResultSet rep = stmt.executeQuery(url.toString())) {

        while (rep.next()) {
            PoketraMP pmp  = new PoketraMP(rep.getString("idpoketra"),rep.getDouble("prixTotalMp"));
            poketras.add(pmp);
        }

    } catch (SQLException e) {
        throw e;
    }

    return poketras;
}
    
    public static List<PoketraMP> getpoketramp(double min, double max)throws Exception{
        List<PoketraMP> poketramp = getAllPoketraMp();
        List<PoketraMP> poketras = new ArrayList<>();
        for(PoketraMP poketra: poketramp){
            if(poketra.getPrixTotalMp() >= min && poketra.getPrixTotalMp() <= max){
            
               poketras.add(poketra);
        }
            
        }
        return poketras;
    }
  
   
    
    public static List<PoketraMP> getAllPoketraMpByid(String idpoketra) throws SQLException {
    StringBuilder url = new StringBuilder();
    url.append("SELECT * FROM poketramp where idPoketra='").append(idpoketra).append("'");
    List<PoketraMP> poketras = new ArrayList<>();

    try (Connection connection = new Connect().dbConnect("postgres");
         Statement stmt = connection.createStatement();
         ResultSet rep = stmt.executeQuery(url.toString())) {

        while (rep.next()) {
            PoketraMP pmp  = new PoketraMP(rep.getString("idPoketraMP"),rep.getString("idpoketra"),rep.getString("idMPremiere"),rep.getInt("quantite"),rep.getDouble("prixTotalMp"));
            poketras.add(pmp);
        }
    } catch (SQLException e) {
        throw e;
    }

    return poketras;
}
    
    
    public static List<PoketraMP> getQttPoketraMPById(String idPoketra, int quantiter) throws Exception {
        List<PoketraMP> res = new ArrayList<>();
        List<PoketraMP> poketraMP = getAllPoketraMpByid(idPoketra);
        for(PoketraMP mp : poketraMP ) {
            mp.setQuantite(mp.getQuantite() * quantiter);
            res.add(mp);
        }
        return res;
    }
    
    
    
    public static int getStockMatierePremiere(String idMatiere)throws SQLException{
        String url="SELECT * FROM v_etat_stock  WHERE  idMPremiere='"+idMatiere+"'";
        int stock = 0;  
        try(Connection connection = new Connect().dbConnect("postgres");
             Statement stmt = connection.createStatement();
             ResultSet rep = stmt.executeQuery(url)){
        while(rep.next()){
            stock = rep.getInt("enstock");
           }
     }catch (SQLException e){
         throw e;
     }
    return stock;
    }

}
