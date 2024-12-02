/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourDao.tourPlacesDao;
import tourDb.DBConnect;
import tourentity.tourPlacesDetails;

/**
 *
 * @author RAHUL
 */
public class DisplayDet extends HttpServlet {

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
      
        String search = request.getParameter("search");
        String concatJammu = " and Kashmir";
        String newresult=null;
        if(search.equalsIgnoreCase("Jammu")){
            search = "Jammu";
           newresult= search+concatJammu; 
        }
        else{
             newresult=search; 
        }
      
        System.out.println("Your search value is "+search);
        System.out.println("Your  modified search value is "+ newresult);
        tourPlacesDao placesdao = new tourPlacesDao(DBConnect.getConnection());
        
        try{
           List<tourPlacesDetails> details = placesdao.getAllPlaces(newresult) ;
           if(details!=null){
              request.getSession().setAttribute("searchresult", details);
               response.sendRedirect("SearchResult.jsp");
           }
           else{
                          request.getSession().setAttribute("msg", "Sorry places may be not entered in the database please try with another state/ut name");
              response.sendRedirect("index.jsp");
   
           }
        }
        catch(Exception ec){
            
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
