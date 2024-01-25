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
import model.LookPoketra;

/**
 *
 * @author Pc
 */
public class LookPoketraDao {

    private static Connection sharedConnection;

    private static Connection getSharedConnection() throws SQLException {
        if (sharedConnection == null || sharedConnection.isClosed()) {
            sharedConnection = new Connect().dbConnect("postgres");
        }
        return sharedConnection;
    }

    public static LookPoketra getLookByID(String id) throws SQLException {
        String url = "SELECT * FROM lookPoketra WHERE idlookpoketra='" + id + "'";
        LookPoketra look = null;
        try (Statement stmt = getSharedConnection().createStatement();
                ResultSet rep = stmt.executeQuery(url)) {
            while (rep.next()) {
                look = new LookPoketra(rep.getString("idLookPoketra"), rep.getString("nomLook"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return look;

    }

    public static List<LookPoketra> getAllLook() throws SQLException {
        String url = "SELECT * FROM LookPoketra";
        List<LookPoketra> looks = new ArrayList<>();
        try (Statement stmt = getSharedConnection().createStatement();
                ResultSet rep = stmt.executeQuery(url)) {
            while (rep.next()) {
                LookPoketra look = new LookPoketra(rep.getString("idLookPoketra"), rep.getString("nomLook"));
                looks.add(look);
            }
        } catch (SQLException e) {
            throw e;
        }
        return looks;
    }

}
