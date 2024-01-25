/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Pc
 */
public class Connect {
 public Connection dbConnect(String base) throws SQLException {
        if (base == null) {
            throw new IllegalArgumentException("Le paramètre base ne peut pas être null");
        }
    
        Connection con = null;
        String username ="";
        String password ="";
        String url = "";
    
        if (base.equals("oracle")) {
            url = "jdbc:oracle:thin:@localhost:1522:ORCL";
            username = "";
            password = "";
        } else if (base.equals("postgres")) {
            
            url = "jdbc:postgresql://localhost:5432/poketra2";
            username = "postgres";
            password = "postgresl2";
        } else if (base.equals("mysql")) {
            url = "jdbc:mysql://localhost:3306/nom_base";
            username = "root";
            password = "";
        } 
    
        if (!username.isEmpty() && !password.isEmpty()) {
            try {
                 Class.forName("org.postgresql.Driver");
                 con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (ClassNotFoundException | SQLException e) {
                 e.printStackTrace();
              }
   
           }
    
        return con;
    } 
    
}
