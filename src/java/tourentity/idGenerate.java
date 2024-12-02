/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourentity;

import java.util.Date;

/**
 *
 * @author RAHUL
 */
public class idGenerate {
    
    
    
    public String getDates(){
        Date date = new Date();
    
    long millisecond = date.getTime();
String   dates = String.valueOf(millisecond);
    
return dates;
    }
  
   
    
}
