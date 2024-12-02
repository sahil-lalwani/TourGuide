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
public class FetchFavouitePlaces {

    private String placeName;
    private String placeState;
    private String images;
    private String Distance;
    private String placeid;
    private String emailid;

    public FetchFavouitePlaces(String placeName, String placeState, String images, String Distance, String placeid, String emailid) {
        this.placeName = placeName;
        this.placeState = placeState;
        this.images = images;
        this.Distance = Distance;
        this.placeid = placeid;
        this.emailid = emailid;
    }

    public FetchFavouitePlaces() {
    }

    @Override
    public String toString() {
        return "FetchFavouitePlaces{" + "placeName=" + placeName + ", placeState=" + placeState + ", images=" + images + ", Distance=" + Distance + ", placeid=" + placeid + ", emailid=" + emailid + '}';
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceState() {
        return placeState;
    }

    public void setPlaceState(String placeState) {
        this.placeState = placeState;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String Distance) {
        this.Distance = Distance;
    }

    public String getPlaceid() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

}
