/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Notification;
import java.util.List;

/**
 *
 * @author trung
 */
public class LoadNotice {
    
    
    public static List<Notification> loadNotice(NotificationDAO n,int pReceive){
        
        
        
        List<Notification> list = n.getNotification(pReceive);
        
        return list;
    }
    
}
