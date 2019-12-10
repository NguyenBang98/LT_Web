/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Comment;
import Model.Person;
import Model.Post;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trung
 */
@WebServlet(name = "CommentUpdate", urlPatterns = {"/CommentUpdate"})
public class CommentUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Servlet Cmt");
        String receive = req.getParameter("name");
        String content = req.getParameter("data");
        String [] ID = receive.split(" ");
        
        int postID = Integer.parseInt(ID[0]);
        int personID = Integer.parseInt(ID[1]);
        
        Post post = new Post();
        post.setID(postID);
        
        Person person = new Person();
        
        person.setPersonID(personID);
        if(!content.equalsIgnoreCase(""))
        {
            Comment comment = new Comment(person, content, post);
        
            CommentDAO cdao = new CommentDAO();
            cdao.saveCmt(comment);
        }
        
        
    }

}
