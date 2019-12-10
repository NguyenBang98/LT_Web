package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ResetPassWord_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Password Reset</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/send_pass.css\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"icon/favicon.png\" />\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Cookie cookie[] = request.getCookies();
            Cookie cook;
            String email = "";
            if (cookie != null) {
                for (int i = 0; i < cookie.length; i++) {
                    cook = cookie[i];
                    if (cook.getName().equalsIgnoreCase("email")) {
                        email += cook.getValue();
                    }

                }
            }
        
      out.write("\n");
      out.write("        <div class=\"container_header\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        <img src=\"icon/infinity.png\" alt=\"Unlimited\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"title\">Password Reset</div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container_main\">\n");
      out.write("\n");
      out.write("            <form action=\"\">\n");
      out.write("\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"title_big\">\n");
      out.write("                        <div class=\"text1\">\n");
      out.write("\n");
      out.write("                            <h2>How do you want to reset your password?</h2>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"title_small\">\n");
      out.write("                        <div class=\"text2\">\n");
      out.write("                            We found the following information associated with your account.\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"option\">\n");
      out.write("\n");
      out.write("                        <div class=\"detail_option\">\n");
      out.write("\n");
      out.write("                            <input type=\"radio\" name=\"gender\" class=\"checker\" value=\"text\">\n");
      out.write("                            <label for=\"text\">Text a code to my phone ending in <strong>51</strong>.</label>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"option2\">\n");
      out.write("                        <div class=\"detail_option\">\n");
      out.write("                            <input type=\"radio\" name=\"gender\" class=\"checker\" value=\"text2\">\n");
      out.write("                            <label for=\"text2\">Email a link to <strong>");
      out.print(email);
      out.write("</strong>.</label>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <form class = \"sendcode\" action=\"NewServlet\" method= \"GET\" >\n");
      out.write("                        <li class=\"button\" >\n");
      out.write("\n");
      out.write("                            <button name=\"email\" value = \"");
      out.print(email);
      out.write("\" type = \"submit\">Continue</button>\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                    </form>\n");
      out.write("                    <li class=\"link\">\n");
      out.write("                        <div class=\"more_inf\">\n");
      out.write("                            <a href=\"\">I don't have access to any of these</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
