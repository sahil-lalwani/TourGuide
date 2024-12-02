/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourDao.tourPlacesDao;
import tourDb.DBConnect;
import tourentity.FetchFavouitePlaces;

/**
 *
 * @author RAHUL
 */
public class deletePlacesCollection extends HttpServlet {

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
       
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        System.out.println("id is "+id);
        System.out.println("email is "+email);
        
        
        Connection conn = DBConnect.getConnection();
        PreparedStatement ps = null;
        String query;
        try{
            query = "delete from collectionplaces where emailid = ? and placeid = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2,id);
           int k  =  ps.executeUpdate();
           if(k>0){
               tourPlacesDao dao =new tourPlacesDao(DBConnect.getConnection());
               List<FetchFavouitePlaces> updatedList = dao.getAllCollection(email);
                       
    request.getSession().setAttribute("fetchdata", updatedList);

    request.getSession().setAttribute("msg", "Deleted successfully");
    response.sendRedirect("FavouritePlaces.jsp");
           }
        }
        catch(SQLException ec){
            System.out.println("Error while delete from collection "+ec.getMessage());
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
