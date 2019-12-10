/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
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
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession hs = req.getSession();
        
        Person obj = (Person)hs.getAttribute("users");
//        System.out.println(obj);
        
        if (obj != null)
        {
            req.setAttribute("user", obj);
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
//            resp.sendRedirect("/BTL_Web/Home.jsp");// 
        }
        else{
            req.getRequestDispatcher("/SignIn.jsp").forward(req, resp);
        }
    }
       
}
