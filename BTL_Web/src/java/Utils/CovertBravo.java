/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Controler.BravoDAO;

/**
 *
 * @author trung
 */
public class CovertBravo {
    
    public static String checkBravo(BravoDAO b, int PersonID, int PostID)
    {
        
        if(b.checkBravo(PersonID, PostID)){
//            System.out.println("Gọi hàm");
            return "#2ecc71";
        }
        return null;
        
    }
    
}
