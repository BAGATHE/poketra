/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.lang.reflect.*;
import java.util.*;
import connection.Connect;

/**
 *
 * @author Pc
 */
public class RequestDb {

    public static void insert(Object o,String database)throws Exception{
    Class c = o.getClass(); //alaiko class le object
    Field[] fields = c.getDeclaredFields();
    
    StringBuilder nomColonnes = new StringBuilder();
    StringBuilder valueColonnes = new StringBuilder();
     StringBuilder sqlRequete = new StringBuilder();
    
    for(int i=0;i<fields.length;i++){
        fields[i].setAccessible(true);
        Object value = fields[i].get(o);  //maka anle value get anle champ => miretourne object
        
        if(value != null){
            if(valueColonnes.length() > 0){
                nomColonnes.append(","); //separateur 
                valueColonnes.append(",");
            }
            nomColonnes.append(fields[i].getName());
            
            if(value instanceof String){
                 String strvalue = (String) value;
                if(strvalue.matches("\\d{4}-\\d{2}-\\d{2}")){
                    if (database.equals("oracle")) {
                          valueColonnes.append("to_date('").append(strvalue).append("','YYYY-MM-DD')");
                    }else{
                            valueColonnes.append("'"+strvalue.toString()+"'");
                    }
                }else{valueColonnes.append("'").append(strvalue).append("'");}
            }
            else{
                valueColonnes.append(value);
            }
        }			
    }

    sqlRequete.append("INSERT INTO ").append(c.getSimpleName()).append(" VALUES (").append("concat('").append(c.getSimpleName()).append("-',nextval('seq").append(c.getSimpleName()).append("')),").append(valueColonnes.toString()).append(")");
        Connect connexion=new Connect();
        Connection connection=connexion.dbConnect(database);
        connection.setAutoCommit(false);
        Statement stmt=connection.createStatement();

 int rep = stmt.executeUpdate(sqlRequete.toString());
 
 if(rep == 0){
     //System.out.println("insertion non valide dans" + c.getSimpleName();
     connection.rollback();
 }else{
     //System.out.println("insertion reussi dans " + c.getSimpleName());
  
     connection.commit();
    
 }
 connection.close();
 stmt.close();
}

    
    
  public static String getLastIdINtable(String database, String colonneName, String table) throws Exception {
    String response =" ";
    StringBuilder sqlRequete = new StringBuilder();
     sqlRequete.append("SELECT *").append(" FROM ").append(table);
        Connect connexion=new Connect();
        Statement stmt;
        ResultSet result;
        try (Connection connection = connexion.dbConnect(database)) {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            result = stmt.executeQuery(sqlRequete.toString());
            while (result.next()) {
                if (result.isLast()==true) {
                    response = result.getString(colonneName);
                }
            }
        }
        stmt.close();
        result.close();
        return response; 
}
    
  
  
  
  
     public static void createOrUpdateViews()throws Exception{
        String url = "CREATE OR REPLACE VIEW v_poketra_mp AS " +
            "SELECT p.idPoketra, p.nom, p.types, p.look, p.taille, p.taille, p.prix, mp.idmpremiere " +
            "FROM InfoPoketra p " +
            "JOIN PoketraMP mp ON p.idPoketra = mp.idPoketra";
        Connect connexion=new Connect();
        Statement stmt;
        try (Connection connection = connexion.dbConnect("postgres")) {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            int rep = stmt.executeUpdate(url);
            if(rep == 0){
                connection.rollback();
            }else{
                connection.commit();
            }      }
 stmt.close();
}

     
public static List<List<Object>> getStock() throws SQLException {
    String query = "SELECT * FROM v_etat_stock_detail";
    List<List<Object>> stocks = new ArrayList<>();

    try (Connection connection = new Connect().dbConnect("postgres");
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {
        
        while (resultSet.next()) {
            List<Object> stock = new ArrayList<>();
            stock.add(resultSet.getString("idMPremiere")); 
            stock.add(resultSet.getString("materiaux"));
            stock.add(resultSet.getDouble("prix"));
            stock.add(resultSet.getInt("quantiterstock"));
            stocks.add(stock);
        }
    } catch (SQLException e) {
        throw e;
    }

    return stocks;
}
       
}

