/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourServlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import tourDao.travelDao;
import tourDb.DBConnect;

/**
 *
 * @author RAHUL
 */
@MultipartConfig
public class addData extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,NullPointerException {
      
        String pname = request.getParameter("placename");
        String stateName = request.getParameter("stateName");
        
        String distance = request.getParameter("distance");
        String timing = request.getParameter("timing");
        String desc = request.getParameter("description");
        
        String imageName =request.getParameter("pname");
        
        
        
        
        
        
        
        
//          request.getAttribute("imageName");
        Part file = request.getPart("imageName");
        
        String imageFileName = file.getSubmittedFileName();
        
        System.out.println("Selected image file name is "+imageFileName);
        System.out.println("Now add image servlet");
//        "C:/Users/RAHUL/Documents/NetBeansProjects/ImageUplodingTut/web/image/"
        
        String uploadPath = "C:/Users/RAHUL/Documents/NetBeansProjects/TourGuide/web/image/"+imageFileName;
        System.out.println("upload image path is "+uploadPath);
        
        
        
        
        
        
       
        travelDao dao = new travelDao(DBConnect.getConnection());
        boolean f;
        try{
              FileOutputStream fos = new FileOutputStream(uploadPath);
        InputStream is =file.getInputStream();
        byte[] data = new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close();
            
            f = dao.addData(pname, stateName,imageFileName , desc, distance, timing);
            if(f){
                request.getSession().setAttribute("msg","Data added Successfully");
                response.sendRedirect("index.jsp");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Error "+ex.getMessage());
        }
        
    }

  

}
