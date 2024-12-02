/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tourDao.tourPlacesDao;
import tourDb.DBConnect;
import tourentity.loginEntity;
import tourentity.tourPlacesDetails;

/**
 *
 * @author RAHUL
 */
public class favouriteplaces extends HttpServlet {

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
        HttpSession session = request.getSession();
        String placeid = (String) session.getAttribute("placeID");

        loginEntity det = (loginEntity) session.getAttribute("userDetails");

        tourPlacesDao placesDao = new tourPlacesDao(DBConnect.getConnection());

        tourPlacesDetails placesDetails = placesDao.getDetailsByid(placeid);

        String placeName;
        String stateName;
        String images;
        String distance;
        String emailid;

        if (placesDetails == null && det==null) {
           return;

        }
               emailid = det.getUseremail();
               placeName = placesDetails.getPname();
               stateName = placesDetails.getStatename();
               images = placesDetails.getImages();
               distance = placesDetails.getDistance();
             
               System.out.println("favourtie "+placeName);
               System.out.println(stateName);
               System.out.println(images);
               System.out.println(distance);
                tourPlacesDao placesdao = new tourPlacesDao(DBConnect.getConnection());
                String msg = placesdao.addFavouriteplaces(placeName, stateName, images, distance, placeid, emailid);
                System.out.println("msg is "+msg);
                if(msg.trim().equalsIgnoreCase("Failed")){
                    request.getSession().setAttribute("msg","Error while add as favourite place please try again");
                    response.sendRedirect("SearchResult.jsp");
                }
                else if(msg.trim().equalsIgnoreCase("Place alreday in collection")){
                    request.getSession().setAttribute("msg", "This place already in your favourite place. Please add another");
                    response.sendRedirect("SearchResult.jsp");
                }
                else{
                    request.getSession().setAttribute("msg","Added as a favourite place successfully");
                    response.sendRedirect("SearchResult.jsp");
                }
               
               
               
        
       

        System.out.println("id in servlet page " + placeid);

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
