/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Acount;
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
@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        
        Acount a = new Acount(userName, password);
        
        AcountDAO adao = new AcountDAO();
        
        a = adao.getUserByID(a);
        
//        System.out.println("ID của người dùng : "  + a.getID());
        
        if(a.getID() != -1){
           
           PersonDAO personDAO = new PersonDAO();
           Person p = personDAO.getPersonByAcountID(a.getID());
           p.setUsername(userName);
           p.setPassword(password);
           p.setID(a.getID());
           
           System.out.println(p);
           HttpSession hs = req.getSession();
           hs.setAttribute("users", p);
           
//           List<Post> list = LoadHome.loadPost();
//           Collections.reverse(list);
//           hs.setAttribute("data", list);
           
           resp.sendRedirect("/BTL_Web/Home");
        }
        else {
            req.setAttribute("errMessage", "Thông tin tài khoản đăng nhập không chính xác"); 
            req.getRequestDispatcher("/SignIn.jsp").forward(req, resp);
        }
        
    }

  
}
