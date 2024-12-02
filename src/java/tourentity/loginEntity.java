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
public class loginEntity {
    
    private String username;
    private String useremail;
    private String phoneNumber;

    public loginEntity() {
    }

    public loginEntity(String username, String useremail, String phoneNumber) {
        this.username = username;
        this.useremail = useremail;
        this.phoneNumber = phoneNumber;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "loginEntity{" + "username=" + username + ", useremail=" + useremail + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
}
