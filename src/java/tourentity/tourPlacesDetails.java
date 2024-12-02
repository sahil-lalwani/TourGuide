/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourentity;

/**
 *
 * @author RAHUL
 */
public class tourPlacesDetails {

    @Override
    public String toString() {
        return "tourPlacesDetails{" + "pname=" + pname + ", statename=" + statename + ", images=" + images + ", description=" + description + ", distance=" + distance + ", timing=" + timing + ", placeID=" + placeID + '}';
    }

    public tourPlacesDetails(String pname, String statename, String images, String description, String distance, String timing, String placeID) {
        this.pname = pname;
        this.statename = statename;
        this.images = images;
        this.description = description;
        this.distance = distance;
        this.timing = timing;
        this.placeID = placeID;
    }

    public tourPlacesDetails() {
    }

    
    private String pname;
    private String statename;
    private String images;
    private String description;
    private String distance;
    private String timing;
    private String placeID;

    
    
    
    public String getPlaceID() {
        return placeID;
    }

    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }
   

 

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
    
    
    
    
}
