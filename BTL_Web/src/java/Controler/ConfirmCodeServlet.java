/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Acount;
import Utils.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.ProcessBuilder.Redirect.to;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vieet
 */
@WebServlet(name = "ConfirmCodeServlet", urlPatterns = {"/ConfirmCodeServlet"})
public class ConfirmCodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Controler.ConfirmCodeServlet.doPost()");
        String code_enter = req.getParameter("enter_code");
        Cookie cookie[] = req.getCookies();
        Cookie cook;
        String username = "";
        String password = "";
        String email = "";
        String code = "";

        if (cookie != null) {
            for (int i = 0; i < cookie.length; i++) {
                cook = cookie[i];
                if (cook.getName().equalsIgnoreCase("username")) {
                    username += cook.getValue();
                }

                if (cook.getName().equalsIgnoreCase("password")) {
                    password += cook.getValue();
                }
                if (cook.getName().equalsIgnoreCase("email1")) {
                    email += cook.getValue();
                }
                if (cook.getName().equalsIgnoreCase("code")) {
                    code += cook.getValue();
                }
            }
        }

        String password1 = Utils.Function.getSHAHash(password);
        Acount account = new Acount(username, password1, email);

        AcountDAO acountDAO = new AcountDAO();
        PersonDAO personDAO = new PersonDAO();
        System.out.println(account);
        if (username.length() > 0 && username.length() > 0 && email.length() > 0 && code_enter.equals(code)) {
            try {
                acountDAO.addAccount(account);
                Acount account1 = acountDAO.getAccountByUsername(username);
                personDAO.addPersonByAccID(account1.getID());
//                req.getRequestDispatcher("/BTL_Web/SignIn.jsp").forward(req, resp);
                    resp.sendRedirect("/BTL_Web/Home");

            } catch (SQLException ex) {
                Logger.getLogger(ConfirmCodeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
