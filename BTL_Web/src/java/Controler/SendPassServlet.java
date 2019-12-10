/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

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
@WebServlet(name = "SendPassServlet", urlPatterns = {"/SendPassServlet"})
public class SendPassServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Sevlet gui email");
        
        String email = req.getParameter("email");
        // send email 
        
        
        String code = Utils.SendEmail.send(email);
        
        // update pass for email 
        String encode = Utils.Function.getSHAHash(code);
        
        AcountDAO adao = new AcountDAO();
        
        adao.changePassword(email, encode);
        
//        req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        resp.sendRedirect("/BTL_Web/Home");
    }

  
}
