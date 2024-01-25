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
import model.TypePoketra;

/**
 *
 * @author Pc
 */
public class TypePoketraDao {
    public static List<TypePoketra> getAllType() throws SQLException {
    String url = "SELECT * FROM TypePoketra";
    List<TypePoketra> poketras = new ArrayList<>();

    try (Connection connection = new Connect().dbConnect("postgres");
         Statement stmt = connection.createStatement();
         ResultSet rep = stmt.executeQuery(url)) {

        while (rep.next()) {
            TypePoketra poketra = new TypePoketra(rep.getString("idTypePoketra"), rep.getString("nomtypepoketra"));
            poketras.add(poketra);
        }

    } catch (SQLException e) {
        throw e;
    }

    return poketras;
}

 public static TypePoketra getById(String id) throws SQLException {
    String url = "SELECT * FROM TypePoketra WHERE idTypePoketra='"+ id +"'";
    TypePoketra poketras = null;

    try (Connection connection = new Connect().dbConnect("postgres");
         Statement stmt = connection.createStatement();
         ResultSet rep = stmt.executeQuery(url)) {

        while (rep.next()) {
          poketras = new TypePoketra(rep.getString("idTypePoketra"), rep.getString("nomtypepoketra"));
        }

    } catch (SQLException e) {
        throw e;
    }

    return poketras;
}
}
