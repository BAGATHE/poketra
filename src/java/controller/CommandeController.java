/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MatierePremiereDao;
import dao.MatierePremiereSortieDao;
import dao.PoketraMPDao;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PoketraMP;

/**
 *
 * @author Pc
 */
public class CommandeController extends HttpServlet {

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

        int quantiterDemander = Integer.parseInt(request.getParameter("quantiterpoketra"));
        String idPoketra = request.getParameter("idpoketra");
       
 

        try {
            List<PoketraMP> listQttMP =   PoketraMPDao.getQttPoketraMPById(idPoketra, quantiterDemander);
            for (PoketraMP pkm : listQttMP) {
                int enstock = PoketraMPDao.getStockMatierePremiere(pkm.getIdMPremiere());
                if (pkm.getQuantite() > enstock) {
                    throw new Exception("La quantité de : " +  MatierePremiereDao.getMatiereByID(pkm.getIdMPremiere()).getMateriaux() + " est insuffisante");
                } else {
                    MatierePremiereSortieDao.insertmouvementSortie(pkm);
                }
            }

            // If no exception occurred, remove the error attribute
            request.removeAttribute("error");
        } catch (Exception ex) {
            // If an exception occurred, set the error attribute
            request.setAttribute("error", ex.getMessage());
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Forward to the listPoketra.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listPoketra.jsp");
        dispatcher.forward(request, response);
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
