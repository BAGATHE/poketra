/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmployerDao;
import dao.LookPoketraDao;
import dao.MatierePremiereDao;
import dao.RequestDb;
import dao.TypePoketraDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employer;
import model.EmployerPoketra;
import model.InfoPoketra;
import model.LookPoketra;
import model.MatierePremiere;
import model.Poketra;
import model.PoketraMP;
import model.TypePoketra;

/**
 *
 * @author Pc
 */
public class CreationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean success = false;
        try {
            response.setContentType("text/html;charset=UTF-8");
            /*UTILITAIRE*/
 /*DONNEE*/
            String nompoketra = request.getParameter("nom");
            String idtype = request.getParameter("type");
            int taille = Integer.parseInt(request.getParameter("taille"));
            String idlook = request.getParameter("look");
            double prix = Double.parseDouble(request.getParameter("prix"));
            String[] choix = request.getParameterValues("choix[]");
            String[] choixEmployer = request.getParameterValues("choixEmp[]");
            
            /*TRAITEMENT*/
            
           
            
            
 /*insert anaty poketra*/
            Poketra poketra = new Poketra(idlook, idtype);
            RequestDb.insert(poketra, "postgres");

            
            /*insert anaty poketra-matierepremiere */
            String lastIdPoketra = RequestDb.getLastIdINtable("postgres", "idpoketra", "poketra");

            
            /*inserrt employerPoketra*/
            double somme = 0;
             for(String choixE: choixEmployer){
                int nombreEmp = Integer.parseInt(request.getParameter(choixE+"-nombre"));
                int heuret = Integer.parseInt(request.getParameter(choixE+"-heure"));
                EmployerPoketra empP = new EmployerPoketra(choixE,lastIdPoketra,nombreEmp,heuret);
                RequestDb.insert(empP,"postgres");
        
                Employer emp = EmployerDao.getEmployerByID(choixE);
               somme+= emp.getSalaire() * heuret * nombreEmp; 
            }
            
            
            
            for (String choice : choix) {
                //je recupere le quantiter du materiaux
                int quantite = Integer.parseInt(request.getParameter(choice));

                double prixMp = MatierePremiereDao.getMatiereByID(choice).getPrix() * quantite;
                somme+=prixMp;
                PoketraMP poketramp = new PoketraMP(lastIdPoketra, choice, quantite, prixMp);
                RequestDb.insert(poketramp, "postgres");
            }

            /*insert anaty poketra-info*/
            LookPoketra lookpoketra = LookPoketraDao.getLookByID(idlook);
            String nomlook = (lookpoketra != null) ? lookpoketra.getNomLook() : "indefinie";

            TypePoketra typepoketra = TypePoketraDao.getById(idtype);
            String nomtype = (typepoketra != null) ? typepoketra.getNom() : "indefinie";

            PrintWriter out = response.getWriter();
            out.println("<h1>Servlet andrana at " + nomlook + nomtype + "</h1>");

            InfoPoketra infopoketra = new InfoPoketra(lastIdPoketra, nompoketra, nomtype, nomlook, taille, prix,somme);
            RequestDb.insert(infopoketra, "postgres");

            ///db.createOrUpdateViews();
            success = true;
            response.sendRedirect("creation.jsp?message=success");
        } catch (Exception ex) {
            response.sendRedirect("creation.jsp?message=failed");
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
