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
 * @author vieet
 */
@WebServlet(name = "ProfileGuest", urlPatterns = {"/ProfileGuest"})
public class ProfileGuest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String personID = req.getParameter("PersonID");
        
        req.setAttribute("personID", personID);
        req.getRequestDispatcher("/ProfileGuest.jsp").forward(req, resp);
        
    }

   

}
