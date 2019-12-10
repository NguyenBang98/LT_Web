/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
import Model.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
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
@WebServlet(name = "DeletePostServlet", urlPatterns = {"/DeletePostServlet"})
public class DeletePostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String PostID = req.getParameter("postDel");
        
        // Del đi trong database là xong
        
        // check xem bài này có phải người ta đăng không đã
        
        HttpSession hs = req.getSession();
        Person person = (Person) hs.getAttribute("users");
        
        // kiểm tra list đó có Post nào là PostID không => nếu có thì remove 
        PostDAO pdao = new PostDAO();
        
        int ID = Integer.parseInt(PostID);
        
        // xóa brao in postID
        
        BravoDAO bdao = new BravoDAO();
        
        bdao.deleteBRAVO(ID);
        
        CommentDAO c = new CommentDAO();
        
        c.deleteComment(ID);
        
        NotificationDAO ndao = new NotificationDAO();
        
        ndao.deleteNoti(ID);
        // xóa cmt in post ID
        
        pdao.deletePost(ID);

        
    }

    

}
