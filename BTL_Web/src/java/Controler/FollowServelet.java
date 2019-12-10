/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
import Model.Post;
import Model.Relation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trung
 */
@WebServlet(name = "FollowServelet", urlPatterns = {"/FollowServelet"})
public class FollowServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        System.out.println("Gọi đến servlet rồi.");
        String IDPost = req.getParameter("name");
        
        HttpSession hs = req.getSession();
        Person p = (Person) hs.getAttribute("users");
        
        List<Post> list = LoadHome.loadPost();
        
        for (Post post : list)
        {
            if( IDPost.equalsIgnoreCase(""+ post.getID() ) )
            {
                
                Relation  r = new Relation();
                r.setP1(p);
                r.setP2(post.getP());
                
                
                RelationshipDAO rdao = new RelationshipDAO();
                
                
                // check relation
                if (rdao.checkRelationShip(r) == true){
                    rdao.deleteRelation(r);
                    
                }
                else{
                    rdao.createRelation(r);
                }
                break;
                
            }
        }
//        resp.sendRedirect("/BTL_Web/Home");
//        resp.setHeader("Refresh", "5");

        
           
       
        
    }

    
}
