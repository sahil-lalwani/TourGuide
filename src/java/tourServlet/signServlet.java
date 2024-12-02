/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tourDao.travelDao;
import tourDb.DBConnect;

/**
 *
 * @author RAHUL
 */
public class signServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
         travelDao dao = new travelDao(DBConnect.getConnection());    
        boolean f;
        String username = request.getParameter("username");
        String email = request.getParameter("useremail");
        String mobileNumber = request.getParameter("mobileNumber");
        String password = request.getParameter("password");
        try{
           f = dao.sign(username, email, mobileNumber, password);
           HttpSession session =request.getSession();
           if(f){
              session.setAttribute("msg", "SuccessFully registered");
              response.sendRedirect("login.jsp");
           }
           else{
               session.setAttribute("failedMsg", "Some error occur please Try again");
               response.sendRedirect("signup.jsp");
           }
           
        }catch(Exception ex){
            
        }
    }// </editor-fold>

}
