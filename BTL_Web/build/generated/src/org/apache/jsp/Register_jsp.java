package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title> Unlimited - Register </title>\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"icon/favicon.png\" />\n");
      out.write("\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/Register.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            String username_err = "", email_err = "", password_err = "", repassword_err = "", check_pass = "", check_email = "", check_username_same = "", check_email_same = "";
            if (request.getAttribute("username_err") != null) {
                username_err = (String) request.getAttribute("username_err");
            }
            if (request.getAttribute("email_err") != null) {
                email_err = (String) request.getAttribute("email_err");
            }
            if (request.getAttribute("password_err") != null) {
                password_err = (String) request.getAttribute("password_err");
            }
            if (request.getAttribute("repassword_err") != null) {
                repassword_err = (String) request.getAttribute("repassword_err");
            }
            if (request.getAttribute("check_pass") != null) {
                check_pass = (String) request.getAttribute("check_pass");
            }
            if (request.getAttribute("check_email") != null) {
                check_email = (String) request.getAttribute("check_email");
            }

            if (request.getAttribute("check_username_same") != null) {
                check_username_same = (String) request.getAttribute("check_username_same");
            }
            if (request.getAttribute("check_email_same") != null) {
                check_email_same = (String) request.getAttribute("check_email_same");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"JS/Register.js\"></script>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <form action=\"RegisterDAO\" method=\"post\" onsubmit=\"validateForm()\">\n");
      out.write("            <div class=\"main_title\">\n");
      out.write("                <h2> Sign Up </h2>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"form_group\">\n");
      out.write("\n");
      out.write("                <ul style=\"list-style-type: none;\">\n");
      out.write("                    <li id=\"user_name\">\n");
      out.write("\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( username_err);
      out.write("  </p>\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( check_username_same);
      out.write("  </p>\n");
      out.write("\n");
      out.write("                        <i class=\"fa fa-user-circle-o\" aria-hidden=\"true\"></i>\n");
      out.write("                        <input type=\"text\" placeholder=\"Your Name\" id=\"name_user\" size=\"33\" value=\"\" name = \"username\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li id=\"user_mail\">\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( email_err);
      out.write("  </p>\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( check_email);
      out.write("  </p>\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( check_email_same);
      out.write("  </p>\n");
      out.write("\n");
      out.write("                        <i class=\"fa fa-envelope\" aria-hidden=\"true\"></i>\n");
      out.write("                        <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Your Email\" size=\"33\">\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li id=\"pass\">\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( password_err);
      out.write("  </p>\n");
      out.write("                        <i class=\"fa fa-lock\" aria-hidden=\"true\"></i>\n");
      out.write("                        <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Password\" size=\"33\">\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li id=\"repass\">\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( repassword_err);
      out.write("  </p>\n");
      out.write("                        <p style=\"color: red\"> ");
      out.print( check_pass);
      out.write("  </p>\n");
      out.write("\n");
      out.write("                        <i class=\"fa fa-unlock-alt\" aria-hidden=\"true\"></i>\n");
      out.write("                        <input type=\"password\" name=\"repassword\" id=\"repassword\" placeholder=\"Repeat Your Password\" size=\"33\">\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <!--                    <li id=\"check_box\">\n");
      out.write("                                            <input type=\"checkbox\" id=\"label02\" name=\"label02\" value=\"\" />\n");
      out.write("                                            I agree all statements in <a href=\"#\" class=\"term-service\">Terms of service</a>\n");
      out.write("                                        </li>-->\n");
      out.write("                    <li id=\"button_register\">\n");
      out.write("                        <button> Register</button>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"img_group\">\n");
      out.write("                <img src=\"icon/signup-image.jpg\" alt=\"img_back\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"back_login\">\n");
      out.write("                <a href=\"SignIn.jsp\" target=\"_blank\">I am already member</a>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
