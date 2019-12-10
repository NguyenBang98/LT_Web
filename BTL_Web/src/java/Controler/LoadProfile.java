package Controler;

import Model.Pin;
import Model.Post;
import java.util.*;

public class LoadProfile {

    public static List<String> loadUserImage(int PersonID) {
        
        PostDAO postDAO = new PostDAO();
        List<Post> list = new ArrayList<Post>();
        list = postDAO.getPostByID(PersonID + "");
        List<String> list_img = new ArrayList<String>();
        for (Post a : list) {
            list_img.add(a.getUrlImg());
        }
        return list_img;
    }
    
    public static List<String> loadPinImage(int PersonID){
        PinDAO pinDAO = new PinDAO();
        List<Pin> listPin = new ArrayList<Pin>();
        
        listPin = pinDAO.getPinByPersonID(PersonID);
        List<String> list_pin_img = new ArrayList<String>();
        for(Pin a : listPin){
            list_pin_img.add(a.getPost().getUrlImg());
        }
        
        return list_pin_img;
    }
    
     public static List<Post> loadPostUser(int PersonID)
    {
        
        PostDAO pdao = new PostDAO();
        List<Post> list = pdao.getPostByID(PersonID + "");
        return list;
    } 
    
//    public static void main(String[] args) {
//        List <String> list = loadUserImage(1);
//        for(String s: list){
//            System.out.println(s);
//        }
//    }
}
