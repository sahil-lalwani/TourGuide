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
import javax.servlet.http.HttpSession;
import tourDao.tourPlacesDao;
import tourDb.DBConnect;
import tourentity.FetchFavouitePlaces;
import tourentity.loginEntity;

/**
 *
 * @author RAHUL
 */
public class FavouritePlaceFetch extends HttpServlet {

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
            throws ServletException, IOException,NullPointerException {
        HttpSession session = request.getSession(); 
        
        
        loginEntity det = (loginEntity) session.getAttribute("userDetails");
        if(det==null){
            response.sendRedirect("login.jsp");
            return;
            
        
        }
      String email =   det.getUseremail();
        System.out.println("email is "+email);
        tourPlacesDao placeDao = new tourPlacesDao(DBConnect.getConnection());
   List<FetchFavouitePlaces> places = placeDao.getAllCollection(email);
   if(places.size()==0){
         request.getSession().setAttribute("msg","No data present");
        response.sendRedirect("FavouritePlaces.jsp");
       return;
      
       
   }
FetchFavouitePlaces rs = new FetchFavouitePlaces();
  
   
   for(FetchFavouitePlaces place:places){
    rs.setPlaceName(place.getImages());
    rs.setPlaceState(place.getPlaceState());
    rs.setImages(place.getImages());
    rs.setDistance(place.getDistance());
    rs.setEmailid(place.getEmailid());
    
     rs.setPlaceid(place.getPlaceid());
   
   }
  request.getSession().setAttribute("fetchdata",places);
     response.sendRedirect("FavouritePlaces.jsp");
  
   

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
