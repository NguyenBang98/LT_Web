package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignIn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Unlimited - Sign In</title>\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"icon/favicon.png\" />\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/singIn.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <script src=\"js/signIn.js\"></script>\n");
      out.write("        <div class=\"limited\">\n");
      out.write("            <div class=\"login\">\n");
      out.write("\n");
      out.write("                <span class=\"title\">\n");
      out.write("                    <h1>Welcome</h1>\n");
      out.write("                </span>\n");
      out.write("                <span class=\"avatar\">\n");
      out.write("                    <img src=\"icon/avatar-01.jpg\" alt=\"Avatar\" height=\"120\" weight=\"120\">\n");
      out.write("                </span>\n");
      out.write("\n");
      out.write("                <span style=\"color:red\" class=\"inforLogin\">\n");
      out.write("                    ");
      out.print((request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage"));
      out.write("\n");
      out.write("                </span>\n");
      out.write("\n");
      out.write("                <form action=\"SignIn\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("                    <div class=\"input_user\">\n");
      out.write("                        <input class=\"username\" type=\"text\" placeholder=\"Username\" value=\"\" name = \"username\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"input_user\">\n");
      out.write("                        <input class=\"password\" type=\"password\" placeholder=\"Password\" value=\"\" name = \"password\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"button_login\">\n");
      out.write("                        <button class=\"btn_login\" onclick=\"validateForm()\">LOGIN</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <ul class=\"login_more\">\n");
      out.write("                    <li class=\"link_1\">\n");
      out.write("                        <span class=\"txt1\">\n");
      out.write("                            Forgot\n");
      out.write("                        </span>\n");
      out.write("                        <a href=\"/BTL_Web/FogetPass.jsp\" class=\"txt2\"> Username / Password?</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"link_2\">\n");
      out.write("                        <span class=\"txt1\">\n");
      out.write("                            Don’t have an account?\n");
      out.write("                        </span>\n");
      out.write("                        <a class=\"txt2\" href=\"#\">Sign up</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
