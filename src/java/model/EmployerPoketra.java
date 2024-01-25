/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pc
 */
public class EmployerPoketra {
    private String idEmployerPoketra;
    private String idEmployer;
    private String idPoketra;
    private int nombreEmp;
    private int heuretravail;

    
      public String getIdPoketra() {
        return idPoketra;
    }

    public void setIdPoketra(String idPoketra) {
        this.idPoketra = idPoketra;
    }
    public String getIdEmployerPoketra() {
        return idEmployerPoketra;
    }

    public void setIdEmployerPoketra(String idEmployerPoketra) {
        this.idEmployerPoketra = idEmployerPoketra;
    }

    public String getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(String idEmployer) {
        this.idEmployer = idEmployer;
    }

    public int getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(int nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public int getHeuretravail() {
        return heuretravail;
    }

    public void setHeuretravail(int heuretravail) {
        this.heuretravail = heuretravail;
    }

    public EmployerPoketra(String idEmployerPoketra, String idEmployer, String idPoketra, int nombreEmp, int heuretravail) {
        this.idEmployerPoketra = idEmployerPoketra;
        this.idEmployer = idEmployer;
        this.idPoketra = idPoketra;
        this.nombreEmp = nombreEmp;
        this.heuretravail = heuretravail;
    }

    public EmployerPoketra(String idEmployer, String idPoketra, int nombreEmp, int heuretravail) {
        this.idEmployer = idEmployer;
        this.idPoketra = idPoketra;
        this.nombreEmp = nombreEmp;
        this.heuretravail = heuretravail;
    }

    
    
    
}
