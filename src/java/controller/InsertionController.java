/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TypePoketra;
import dao.RequestDb;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LookPoketra;
import model.MatierePremiere;

/**
 *
 * @author Pc
 */
public class InsertionController extends HttpServlet {

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
        

        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("typepoketra");
        String materiaux = request.getParameter("materiaux");
        String prixString =  (String) request.getParameter("prixm");
        String look = request.getParameter("look");
        try {
            if (type != null) {
                TypePoketra typeP = new TypePoketra(type);
                RequestDb.insert(typeP,"postgres");
            } else if (materiaux != null) {
                double prix = 0.0;
                if (prixString != null && !prixString.isEmpty()) {
                   prix = Double.parseDouble(prixString);
                }
               MatierePremiere mpremiere = new MatierePremiere(materiaux,prix);
               RequestDb.insert(mpremiere,"postgres");
            } else if (look != null) {
                LookPoketra lookp = new LookPoketra(look);
                RequestDb.insert(lookp,"postgres");
            }
            response.sendRedirect("index.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
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
