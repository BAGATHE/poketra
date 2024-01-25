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
import model.MatierePremiereSortie;
import model.PoketraMP;

/**
 *
 * @author Pc
 */
public class MatierePremiereSortieDao {


    public static void insertmouvementSortie(PoketraMP pkm) throws SQLException, Exception {
        MatierePremiereSortie mps = new MatierePremiereSortie(pkm.getIdMPremiere(), pkm.getQuantite(), null);
        RequestDb.insert(mps, "postgres");
    }

    public static Boolean SortieIsExist(String idmatiereP) throws SQLException {
        String url = "SELECT * FROM MatierePremiereSortie WHERE idMPremiere='" + idmatiereP + "'";
        int counter = 0;
        try (Connection connection = new Connect().dbConnect("postgres");
                Statement stmt = connection.createStatement();
                ResultSet rep = stmt.executeQuery(url)) {
            while (rep.next()) {
                counter++;
            }
            return counter > 0;
        } catch (SQLException e) {
            throw e;
        }

    }
}
