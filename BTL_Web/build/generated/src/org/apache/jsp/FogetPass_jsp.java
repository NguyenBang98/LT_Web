package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FogetPass_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/forgetPass.css\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"icon/favicon.png\" />\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("        <div class = \"container_form\">\n");
      out.write("            <form class = \"find_acount\" action=\"CheckAcount\" method=\"POST\">\n");
      out.write("\n");
      out.write("                <ul class = \"list_menu\">\n");
      out.write("\n");
      out.write("                    <li class \"title_main\">\n");
      out.write("                        <div>\n");
      out.write("                            <h2>Find your Ulimited account</h2>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class = \"descrip\">\n");
      out.write("                        <div class=\"descrip_detail\">Enter your email, phone number or username.</div>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <span style=\"color:red\" class=\"inforLogin\">\n");
      out.write("                            ");
      out.print((request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage"));
      out.write("\n");
      out.write("                        </span>\n");
      out.write("                    </li>\n");
      out.write("                    <li class = \"input_user\">\n");
      out.write("                        <input name=\"email\" class=\"email\" type=\"text\">\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class = \"confirn\">\n");
      out.write("                        <button type=\"submit\">Search</button>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
