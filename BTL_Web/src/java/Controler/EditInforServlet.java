/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vieet
 */
@WebServlet(name = "EditInforServlet", urlPatterns = {"/EditInforServlet"})
public class EditInforServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs = request.getSession();
        Person p = (Person) hs.getAttribute("users");

        String quotes = request.getParameter("Quotes");
        String work = request.getParameter("work");
        String study = request.getParameter("study");
        String live = request.getParameter("live");
        String follow = request.getParameter("follow");
        int follow1 = Integer.parseInt(follow);
        String email = request.getParameter("email");

        PersonDAO personDAO = new PersonDAO();
        AcountDAO acountDAO = new AcountDAO();
        
        p.setQuotes(quotes);
        p.setWork(work);
        p.setStudy(study);
        p.setAddress(live);
        p.setFlower(follow1);
        
//        System.out.println("ID cua nguoi"+p.getPersonID());
        acountDAO.updateEmail(email, p.getID());
        personDAO.updateInfor(p, p.getPersonID());
        
        String url = "/Profile.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

}
