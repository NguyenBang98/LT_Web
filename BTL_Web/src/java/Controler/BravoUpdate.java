/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Bravo;
import Model.Notification;
import Model.Person;
import Model.Post;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "BravoUpdate", urlPatterns = {"/BravoUpdate"})
public class BravoUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Thực hiện Bravo");
        String barvo = req.getParameter("bravo");
        String postID = req.getParameter("postID");
        System.out.println(barvo);
        HttpSession hs = req.getSession();
        Person p = (Person) hs.getAttribute("users");
//        System.out.println(p);
        PostDAO pdao = new PostDAO();
        Post post = pdao.getPostByID(Integer.parseInt(postID));
        if (barvo.equalsIgnoreCase("add")) {
            System.out.println("addddddddddddd");
            post.setNBravo(post.getNBravo() + 1);
            Bravo b = new Bravo();
            b.setPerson(p);
            b.setPost(post);

            BravoDAO bdao = new BravoDAO();
            bdao.save(b);
        } else {
            post.setNBravo(post.getNBravo() - 1);
            Bravo b = new Bravo();
            b.setPerson(p);
            b.setPost(post);

            BravoDAO bdao = new BravoDAO();
            bdao.delete(b);
        }
        pdao.updatePost(post);
        
        if (p.getPersonID() !=  post.getP().getPersonID())
        {
            NotificationDAO ndao = new NotificationDAO();
            ndao.saveNotice(new Notification(p, post.getP(), "has bravo your post", post));
        }
        
        String result = "" + post.getNBravo() + " Bravo";
        resp.setContentType("text/plain");
        resp.getWriter().write(result);

    }

}


