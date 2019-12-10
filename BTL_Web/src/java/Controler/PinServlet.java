/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Notification;
import Model.Person;
import Model.Pin;
import Model.Post;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PinServlet", urlPatterns = {"/PinServlet"})
public class PinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String pinImg = req.getParameter("pinImg");
        
        HttpSession hs = req.getSession();
        Person person = (Person) hs.getAttribute("users");
        
        Post post = new Post();
        post.setUrlImg(pinImg);
        
        Pin pin = new Pin(person, post);
        
        PinDAO pinDAO = new PinDAO();
        
        pinDAO.save(pin);
        
//        if (person.getPersonID() !=  post.getP().getPersonID())
//        {
//            NotificationDAO ndao = new NotificationDAO();
//            ndao.saveNotice(new Notification(p, post.getP(), "has bravo your post", post));
//        }
        
    }

   

}
