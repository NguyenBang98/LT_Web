/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Comment;
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
@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        System.out.println("Được gọi Cmt");
        String postID = req.getParameter("postID");
        HttpSession hs = req.getSession();
        
        Person obj = (Person)hs.getAttribute("users");
        CommentDAO commentDAO = new CommentDAO();
        List<Comment> list = commentDAO.getCmtByIDPost(Integer.parseInt(postID));
//        Comment c = list.get(0).getPost().getP();
    
        PostDAO pdao = new PostDAO();
        Post post = pdao.getPostByID(Integer.parseInt(postID));
        
        
        if (obj.getPersonID() !=  post.getP().getPersonID())
        {
            NotificationDAO ndao = new NotificationDAO();
            ndao.saveNotice(new Notification(obj, post.getP(), "has commented your post", post));
        }
        
        
//        System.out.println(obj);
        req.setAttribute("post", post);
        req.setAttribute("users", obj);
        req.setAttribute("listCmt", list);
//        System.out.println("Chuyển trang nè");
//        response.setContentType("text/html");
        req.getRequestDispatcher("/Comment.jsp").forward(req, resp);
        
    }

    

}
