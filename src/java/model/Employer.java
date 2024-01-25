/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Pc
 */
public class Employer {
    private String idEmployer;
    private String roleEmp;
    private String TypeClasse;
    private Date dateEntrer;

    public Date getDateEntrer() {
        return dateEntrer;
    }

    public void setDateEntrer(Date dateEntrer) {
        this.dateEntrer = dateEntrer;
    }

    
    

   
    
    public String getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(String idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getRoleEmp() {
        return roleEmp;
    }

    public void setRoleEmp(String roleEmp) {
        this.roleEmp = roleEmp;
    }

    public String getTypeClasse() {
        return TypeClasse;
    }

    public void setTypeClasse(String TypeClasse) {
        this.TypeClasse = TypeClasse;
    }

    public Employer(String idEmployer, String roleEmp, String TypeClasse, Date dateEntrer) {
        this.idEmployer = idEmployer;
        this.roleEmp = roleEmp;
        this.TypeClasse = TypeClasse;
        this.dateEntrer = dateEntrer;
    }

    public Employer(String roleEmp, String TypeClasse, Date dateEntrer) {
        this.roleEmp = roleEmp;
        this.TypeClasse = TypeClasse;
        this.dateEntrer = dateEntrer;
    }

   
   

    
    
  
 
    
    
}
