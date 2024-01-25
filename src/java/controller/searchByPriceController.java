/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.InfoPoketraDao;
import dao.PoketraMPDao;
import dao.RequestDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InfoPoketra;
import model.PoketraMP;

/**
 *
 * @author Pc
 */
public class searchByPriceController extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            double min = Double.parseDouble(request.getParameter("prixmin"));
            double max = Double.parseDouble(request.getParameter("prixmax")); 
          /*  List<PoketraMP> rep =   PoketraMPDao.getpoketramp(min,max);
            List<InfoPoketra> poketras = new ArrayList<>();*/
          
            List<InfoPoketra> rep =   InfoPoketraDao.getcorrectPoketra(min, max);
            List<InfoPoketra> poketras = new ArrayList<>();
            
            for(InfoPoketra poketram : rep){
               poketras.add(InfoPoketraDao.getinfoByID(poketram.getIdPoketra()));    
            }
            request.setAttribute("resulsearchbyprice", poketras);

            // Utiliser RequestDispatcher pour transférer les attributs
            RequestDispatcher dispatcher = request.getRequestDispatcher("listPoketra.jsp");
            dispatcher.forward(request, response); 
            
        } catch (Exception ex) {
            Logger.getLogger(searchByPriceController.class.getName()).log(Level.SEVERE, null, ex);
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
