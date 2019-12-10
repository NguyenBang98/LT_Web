/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Controler.RelationshipDAO;

/**
 *
 * @author trung
 */
public class CovertRelation {
    
    public static String check(RelationshipDAO r, int ID1, int ID2)
    {
//        System.out.println(ID1 + " " + ID2);
        if(ID1 == ID2) return "My Self";
        else if(r.checkRelationShip(ID1, ID2)) return "Following";
        else{
            return "Follow";
        }
        
    }
            
    
    
}
