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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trung
 */
@WebServlet(name = "CheckAcount", urlPatterns = {"/CheckAcount"})
public class CheckAcount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        // check email co trong acount khoong
        System.out.println("Check TK có hay không");
        AcountDAO adao = new AcountDAO();
        boolean kt = adao.checkEmail(email);
        if(kt){
//            resp.setAttribute("email", email);
            Cookie firstName = new Cookie("email", email);
            firstName.setMaxAge(60 * 60 * 1);

            resp.addCookie(firstName);
//            req.getRequestDispatcher("/ResetPassWord.jsp").forward(req, resp);
            resp.sendRedirect("/BTL_Web/ResetPassWord.jsp");
        }
        else{
            
            req.setAttribute("errMessage", "Email is not exist! ");
            req.getRequestDispatcher("/FogetPass.jsp").forward(req, resp);
        }
        
        

    }

}
