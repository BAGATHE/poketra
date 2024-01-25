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
import model.MatierePremiere;

/**
 *
 * @author Pc
 */
public class MatierePremiereDao {

    public static List<MatierePremiere> getAllMatieres() throws SQLException {
        String url = "SELECT * FROM MatierePremiere";
        List<MatierePremiere> matieres = new ArrayList<>();

        try (Connection connection = new Connect().dbConnect("postgres");
                Statement stmt = connection.createStatement();
                ResultSet rep = stmt.executeQuery(url)) {

            while (rep.next()) {
                MatierePremiere mp = new MatierePremiere(rep.getString("idMPremiere"), rep.getString("Materiaux"), rep.getDouble("prix"));
                matieres.add(mp);
            }

        } catch (SQLException e) {
            throw e;
        }
        return matieres;
    }

    public static MatierePremiere getMatiereByID(String id) throws SQLException {
        String url = "SELECT * FROM MatierePremiere  WHERE idMPremiere='" + id + "'";
        MatierePremiere mp = null;
        try (Connection connection = new Connect().dbConnect("postgres");
                Statement stmt = connection.createStatement();
                ResultSet rep = stmt.executeQuery(url)) {
            while (rep.next()) {
                mp = new MatierePremiere(rep.getString("idMPremiere"), rep.getString("Materiaux"), rep.getDouble("prix"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return mp;

    }

}
