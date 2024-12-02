/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RAHUL
 */
public class DBConnect {
    
    private static Connection conn;
    
    public static Connection getConnection(){
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-605BQ7AF:1521/xe","firstRahul","Rahul");
            System.out.println("Connected To the database Successfully");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Error while connected to the database..."+ex.getMessage());
        }
        return conn;
    }
    
}
