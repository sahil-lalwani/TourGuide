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
import tourDao.travelDao;
import tourDb.DBConnect;
import tourentity.loginEntity;

/**
 *
 * @author RAHUL
 */
public class logServlet extends HttpServlet {

   

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String email = request.getParameter("email");
        String password = request.getParameter("password");
         travelDao dao = new travelDao(DBConnect.getConnection());
        if(email.equals("admin@gmail.com") && password.equals("admin")){
           request.getSession().setAttribute("admin", "Admin login successfully");
           loginEntity ent = new loginEntity();
           ent.setUsername("Admin");
           request.getSession().setAttribute("userDetails",ent);
           response.sendRedirect("index.jsp");
        
           
        }else{
  
  loginEntity ent = dao.Login(email, password);
  
        System.out.println(ent);
   if(ent!=null){
       request.getSession().setAttribute("userDetails",ent);
       request.getSession().setAttribute("msg", "login SuccessFully");
       response.sendRedirect("index.jsp");
   }
   else{
       request.getSession().setAttribute("msg", "Invalid credentials");
       response.sendRedirect("login.jsp");
   }
        }
    }

}
