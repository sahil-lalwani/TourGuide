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
import java.util.ArrayList;
import java.util.List;
import tourDb.DBConnect;
import tourServlet.favouriteplaces;
import tourentity.FetchFavouitePlaces;
import tourentity.tourPlacesDetails;

/**
 *
 * @author RAHUL
 */
public class tourPlacesDao {

    private Connection conn = null;

    public tourPlacesDao(Connection conn) {
        this.conn = conn;
    }

//    public List<tourPlacesDetails> getAllPlaces(String StateName){
//        
//        List<tourPlacesDetails> placesDetails =null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String query ;
//        tourPlacesDetails placeDet;
//        
//        String imageFileName=null;
//        try{
//            query ="select * from placesDetails where statename = ?  ";
//              ps=conn.prepareStatement(query);
//              ps.setString(1,StateName);
//              rs = ps.executeQuery();
//              while(rs.next()){
//                  placesDetails = new ArrayList();
//                placeDet = new tourPlacesDetails();
//                placeDet.setPname(rs.getString("pname"));
//                placeDet.setStatename(rs.getString("statename"));
//                
//                 imageFileName = rs.getString("images");
//                
//                
//                placeDet.setImages(imageFileName);
//                placeDet.setDescription(rs.getString("description"));
//                placeDet.setDistance(rs.getString("distance"));
//                placeDet.setTiming(rs.getString("timing"));
//                placesDetails.add(placeDet);
//                
//                
//              }
//              
//        }
//        catch(SQLException ex){
//            ex.printStackTrace();
//            System.out.println("Error while fetching the data from the database and error is "+ex.getMessage());
//        }
//        
//        return placesDetails;
//    }
//    
    public List<tourPlacesDetails> getAllPlaces(String StateName) {
        List<tourPlacesDetails> placesDetails = new ArrayList<>(); // Initialize outside the loop
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query;
        tourPlacesDetails placeDet;

        try {
            query = "SELECT * FROM placesDetails WHERE statename = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, StateName);
            rs = ps.executeQuery();

            while (rs.next()) {
                placeDet = new tourPlacesDetails();
                placeDet.setPname(rs.getString("pname"));
                placeDet.setStatename(rs.getString("statename"));
                placeDet.setImages(rs.getString("images"));
                placeDet.setDescription(rs.getString("description"));
                placeDet.setDistance(rs.getString("distance"));
                placeDet.setTiming(rs.getString("timing"));
                placeDet.setPlaceID(rs.getString("placesid"));

                placesDetails.add(placeDet); // Add each placeDet object to the list
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error while fetching the data from the database: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return placesDetails; // Will contain all fetched results
    }

    public tourPlacesDetails getDetailsByid(String placeid) {
        tourPlacesDetails placeDet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query;
        try {
            query = "SELECT * FROM placesDetails WHERE placesid = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, placeid);
            rs = ps.executeQuery();
            while (rs.next()) {
                placeDet = new tourPlacesDetails();
                placeDet.setPname(rs.getString("pname"));
                placeDet.setStatename(rs.getString("statename"));
                placeDet.setImages(rs.getString("images"));
                placeDet.setDescription(rs.getString("description"));
                placeDet.setDistance(rs.getString("distance"));
                placeDet.setTiming(rs.getString("timing"));
                placeDet.setPlaceID(rs.getString("placesid"));

            }
        } catch (SQLException ex) {

            System.err.println("Error while fetching the data from the database: " + ex.getMessage());
        } finally {
            // Close resources in the finally block to ensure they are always closed
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.err.println("Error while closing resources: " + e.getMessage());
            }
        }

        return placeDet;

    }

    public String addFavouriteplaces(String placeName, String state, String images, String distance, String placeid, String emailid) {
        String status = "Failed";

        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        String query1;
        String query2;
        ResultSet rs;

        try {
            query1 = "select * from collectionPlaces where placeid = ? and emailid=?";
            query2 = "insert into collectionPlaces(placeName,placeState,images,distance, placeid,emailid) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(query1);
            ps.setString(1, placeid);
            ps.setString(2, emailid);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = "Place alreday in collection ";
            } else {
                ps1 = conn.prepareStatement(query2);
                ps1.setString(1, placeName);
                ps1.setString(2, state);
                ps1.setString(3, images);
                ps1.setString(4, distance);
                ps1.setString(5, placeid);
                ps1.setString(6, emailid);
                int k = ps1.executeUpdate();
                if (k > 0) {
                    status = "Added to Collection Successfully";
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in addFavourite places " + ex.getMessage());
        }

        return status;
    }

    public List<FetchFavouitePlaces> getAllCollection(String emailid) {

        List<FetchFavouitePlaces> details =null; 
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query;
        try {
         details=   new ArrayList();
            query = "select * from collectionPlaces where emailid = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, emailid);
            rs = ps.executeQuery();
            while (rs.next()) {
                FetchFavouitePlaces fp = new FetchFavouitePlaces();
                fp.setPlaceName(rs.getString("placename"));
                fp.setPlaceState(rs.getString("placestate"));
                fp.setImages(rs.getString("images"));
                fp.setDistance(rs.getString("distance"));
                fp.setEmailid(rs.getString("emailid"));
                fp.setPlaceid(rs.getString("placeid"));
                details.add(fp);

            }

        } catch (SQLException ex) {
            System.out.println("Error while getAllCollection " + ex.getMessage());
        }

        return details;
    }

}
