/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.Connect;
import static dao.PoketraMPDao.getAllPoketraMp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.InfoPoketra;
import model.PoketraMP;

/**
 *
 * @author Pc
 */
public class InfoPoketraDao {
    
    public static List<InfoPoketra> getAllPoketra() throws SQLException {
    String url = "SELECT * FROM InfoPoketra";
    List<InfoPoketra> poketras = new ArrayList<>();

    try (Connection connection = new Connect().dbConnect("postgres");
         Statement stmt = connection.createStatement();
         ResultSet rep = stmt.executeQuery(url)) {

        while (rep.next()) {
            InfoPoketra infopoketra = new InfoPoketra(rep.getString("idpoketra"),rep.getString("nom"), rep.getString("types"),rep.getString("look"),rep.getInt("taille"),rep.getDouble("prix"),rep.getDouble("prixreviens"));
            poketras.add(infopoketra);
        }

    } catch (SQLException e) {
        throw e;
    }

    return poketras;
}
    
    
public static List<InfoPoketra> getAllPoketraParMatierePremier(String matiere) throws SQLException {
        String url = "SELECT * FROM v_poketra_mp WHERE idMPremiere ='"+ matiere+"' ";
        
        List<InfoPoketra> poketras = new ArrayList<>();

        try (Connection connection = new Connect().dbConnect("postgres");
             Statement stmt = connection.createStatement();
             ResultSet rep = stmt.executeQuery(url)) {

            while (rep.next()) {
                InfoPoketra infopoketra = new InfoPoketra(rep.getString("idpoketra"),rep.getString("nom"), rep.getString("types"),rep.getString("look"),rep.getInt("taille"),rep.getDouble("prix"),rep.getDouble("prixreviens"));
                poketras.add(infopoketra);
            }
        } catch (SQLException e) {
            throw e;
        }
    return poketras;
    } 
    


public static InfoPoketra getinfoByID(String id)throws SQLException{
    String url="SELECT * FROM InfoPoketra  WHERE idPoketra='"+id+"'";
    InfoPoketra infop = null;   
    try(Connection connection = new Connect().dbConnect("postgres");
         Statement stmt = connection.createStatement();
         ResultSet rep = stmt.executeQuery(url)){
    while(rep.next()){
        infop =  new InfoPoketra(rep.getString("idpoketra"),rep.getString("nom"), rep.getString("types"),rep.getString("look"),rep.getInt("taille"),rep.getDouble("prix"),rep.getDouble("prixreviens"));
       }
 }catch (SQLException e){
     throw e;
 }
return infop;
    
}

   public static List<InfoPoketra> getcorrectPoketra(double min, double max)throws Exception{
        List<InfoPoketra> infopoketra =  getAllPoketra();
        List<InfoPoketra> poketras = new ArrayList<>();
        for(InfoPoketra infpoketra: infopoketra){
            double benef = infpoketra.getPrix() - infpoketra.getPrixreviens();
            if( benef >= min && benef<= max){
            
               poketras.add(infpoketra);
        }
            
        }
        return poketras;
    }
    
    
    
}
