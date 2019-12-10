/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Controler.PinDAO;

/**
 *
 * @author trung
 */
public class CovertPin {
    
    public static String checkPin(PinDAO p, int PersonID, String UrlImg)
    {
        if(p.checkPined(PersonID, UrlImg)){
//            System.out.println("Gọi hàm");
            return "Pined";
        }
        return "Pin";
    }
    
}
