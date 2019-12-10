/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

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
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("ISO-8859-1");
        String postID = req.getParameter("postID");
        String content = req.getParameter("Text");
        
        Post p = new Post();
        p.setID(Integer.parseInt(postID));
        p.setContent(content);
        
        
        PostDAO pdao = new PostDAO();
//        System.out.println(postID + "  " + content );
        
        pdao.updateBV(p);
        
        resp.setContentType("text/plain");
        resp.getWriter().write("Edited Success!");
    }

    

}
