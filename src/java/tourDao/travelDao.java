/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tourentity.idGenerate;
import tourentity.loginEntity;

/**
 *
 * @author RAHUL
 */
public class travelDao {
    
    private Connection conn = null;
    
    public travelDao(Connection conn){
        this.conn = conn;
    }
    
    public boolean sign(String username,String email,String phoneNo,String password){
        boolean f= false;
        PreparedStatement ps =null;
        String query;
        try{
            query = "insert into tourUser(name,email,mobilenumber,password) values(?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,email);
            ps.setString(3,phoneNo);
            ps.setString(4,password);
            int k = ps.executeUpdate();
            if(k>0){
                f = true;
            }
            
                    
                    
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Error while inserting the data and error in login method "+ex.getMessage());
        }
        return f;
    }
    
    public loginEntity Login(String email, String password){
        loginEntity details = null;
        PreparedStatement ps = null;
        String query;
        try{
            query = "select * from tourUser where email =? and password = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                details = new loginEntity();
                details.setUsername(rs.getString("name"));
                details.setUseremail(rs.getString("email"));
                details.setPhoneNumber(rs.getString("mobilenumber"));
               
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Error while login ");
        }
        
        
        return details;
        
    }
    
    public boolean addData(String pname,String stateName,String image,String desc,String distance, String timing){
        boolean f = false;
        
        PreparedStatement ps = null;
        String query;
        try{
            idGenerate placesid = new idGenerate();
            String placeId = placesid.getDates();
            System.out.println("Your id is "+placeId);
            query = "insert into placesDetails(pname,stateName,images,description,distance,timing,placesid)values(?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(query);
            ps.setString(1,pname);
            ps.setString(2, stateName);
            ps.setString(3,image);
            ps.setString(4,desc);
            ps.setString(5,distance);
            ps.setString(6,timing);
            ps.setString(7,placeId);
            int k = ps.executeUpdate();
            if(k>0){
                f=true;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Error while inserting add data in the table "+ex.getMessage());
        }
        
        
        return f;
    }
    
}
