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
import model.Employer;
import model.MatierePremiere;
/**
 *
 * @author Pc
 */
public class EmployerDao {
        public static List<Employer> getAllEmployers() throws SQLException {
        String url = "SELECT * FROM Employer ";
        List<Employer> employers = new ArrayList<>();

        try (Connection connection = new Connect().dbConnect("postgres");
                Statement stmt = connection.createStatement();
                ResultSet rep = stmt.executeQuery(url)) {

            while (rep.next()) {
                Employer emp = new Employer(rep.getString("idEmployer"), rep.getString("roleEmp"),rep.getString("salaire"),rep.getDate("dateEntrer"));
                employers.add(emp);
            }

        } catch (SQLException e) {
            throw e;
        }
        return employers;
    }
        
        
      public static Employer getEmployerByID(String id) throws SQLException {
        String url = "SELECT * FROM Employer  WHERE idEmployer='" + id + "'";
        Employer emp = null;
        try (Connection connection = new Connect().dbConnect("postgres");
                Statement stmt = connection.createStatement();
                ResultSet rep = stmt.executeQuery(url)) {
            while (rep.next()) {
                 emp = new Employer(rep.getString("idEmployer"), rep.getString("roleEmp"),rep.getString("salaire"),rep.getDate("dateEntrer"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return emp;

    }
}
