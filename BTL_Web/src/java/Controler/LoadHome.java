/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Post;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author trung
 */
public class LoadHome {
    
    public static List<Post> loadPost()
    {
        System.out.println("Được goi lại");
        PostDAO pdao = new PostDAO();
        List<Post> list = pdao.getPostAll();    
        Collections.reverse(list);
        return list;
    } 
}
