/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import model.MatierePremiereEntre;
import model.PoketraMP;

/**
 *
 * @author Pc
 */
public class MatierePremiereEntreDao {
    public void insertmouvementEntre(PoketraMP pkm)throws SQLException, Exception{
     MatierePremiereEntre mps = new MatierePremiereEntre(pkm.getIdMPremiere(),pkm.getQuantite(),null);
     RequestDb.insert(mps,"postgres");
   }   
}
