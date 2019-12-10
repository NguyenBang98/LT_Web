package Controler;

import Model.Acount;
import Utils.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterDAO")
public class RegisterDAO extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("haha");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        String username_err = "";
        String email_err = "";
        String password_err = "";
        String repassword_err = "";
        String check_pass = "";
        String check_email = "";
        String check_username_same = "";
        String check_email_same = "";

        //xử lý bỏ trống 
        if (username.equals("")) {
            username_err = "Vui lòng nhập tên đăng nhập!";
        }
        if (username_err.length() > 0) {
            request.setAttribute("username_err", username_err);
        }

        if (email.equals("")) {
            email_err = "Vui lòng nhập email!";
        }
        if (email_err.length() > 0) {
            request.setAttribute("email_err", email_err);
        }

        if (password.equals("")) {
            password_err = "Vui lòng nhập password!";
        }
        if (password_err.length() > 0) {
            request.setAttribute("password_err", password_err);
        }

        if (repassword.equals("")) {
            repassword_err = "Vui lòng nhập repassword!";
        }
        if (repassword_err.length() > 0) {
            request.setAttribute("repassword_err", repassword_err);
        }

        //xử lý password và re-password không giống nhau
        if (password.equals(repassword) == false) {
            check_pass = "re-password không chính xác, nhập lại!";

        }
        if (check_pass.length() > 0) {
            request.setAttribute("check_pass", check_pass);
        }

        //xử lý nhập sai định dạng email
        if (validate_email(email) == true) {
            check_email = "";
        }
        if (validate_email(email) == false && email.length() > 0) {
            check_email = "định dạng email không hợp lệ!";
        }

        if (check_email.length() > 0) {
            request.setAttribute("check_email", check_email);
        }
        
        
        AcountDAO adao = new AcountDAO();
   
        //check_accounts
        if (adao.checkUserExist(username)) {
            check_username_same = "Username đã tồn tại!";
        }
        if (adao.checkEmailExist(email)) {
            check_email_same = "Email đã tồn tại!";
        }

        if (check_username_same.length() > 0 || check_email_same.length() > 0) {
            request.setAttribute("check_username_same", check_username_same);
            request.setAttribute("check_email_same", check_email_same);

        }

        //thêm tài khoản
        Acount account = new Acount(username, password, email);

        String usern = account.getUsername();
        String pass = account.getPassword();
        String mail = account.getEmail();

        //chuyển sang login
        String url = "/Register.jsp";
        if (username_err.length() == 0 && email_err.length() == 0 && password_err.length() == 0
                && repassword_err.length() == 0 && check_email.length() == 0 && password.equals(repassword)
                && check_username_same.length() == 0 && check_email_same.length() == 0) {

            url = "ConfirmCode.jsp";

        }

        SendEmail sendEmail = new SendEmail();
        String code = sendEmail.send(email);
        
        //chuyển trang
        //cookie
        System.out.println(username + " " + password + " " + email);
        Cookie firstName = new Cookie("username", username);
        firstName.setMaxAge(60 * 60 * 1);
        response.addCookie(firstName);

        Cookie firstName2 = new Cookie("password", password);
        firstName.setMaxAge(60 * 60 * 1);
        response.addCookie(firstName2);

        Cookie firstName3 = new Cookie("email1", email);
        firstName.setMaxAge(60 * 60 * 1);
        response.addCookie(firstName3);

        Cookie firstName4 = new Cookie("code", code);
        firstName.setMaxAge(60 * 60 * 1);
        response.addCookie(firstName4);

        request.getRequestDispatcher(url).forward(request, response);

    }

    public boolean validate_email(String email) {
        //EMAIL_REGEX là biểu thức chính quy
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        boolean b = email.matches(EMAIL_REGEX);
        return b;
    }

}
