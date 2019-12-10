package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Controler.PinDAO;
import Controler.BravoDAO;
import Model.Post;
import Controler.RelationshipDAO;
import Model.Person;
import Model.Comment;
import java.util.List;

public final class Comment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Unlimited</title>\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"icon/favicon.png\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/comment.css\">\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <script >\n");
      out.write("            function BackPage() {\n");
      out.write("                alert();\n");
      out.write("//                window.history.back();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
 List<Comment> list = (List) request.getAttribute("listCmt");
            Post post = (Post) request.getAttribute("post");
            Person postP = post.getP();
            RelationshipDAO r = new RelationshipDAO();
            HttpSession hs = request.getSession();
            Person p = (Person) hs.getAttribute("users");
            BravoDAO b = new BravoDAO();
            PinDAO pin = new PinDAO();
        
      out.write("\n");
      out.write("        <div class=\"main\">\n");
      out.write("\n");
      out.write("            <div class=\"main-stt\">\n");
      out.write("                <div class=\"img-stt\">\n");
      out.write("                    <img class=\"stt\" src=\"");
      out.print(post.getUrlImg());
      out.write("\" alt=\"error\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"cmt-box\">\n");
      out.write("                    <div class=\"user\">\n");
      out.write("                        <span class=\"avata\">\n");
      out.write("                            <img class=\"imge\" src=\"");
      out.print(postP.getAvatar());
      out.write("\" alt=\"error\">\n");
      out.write("                        </span>\n");
      out.write("                        <h4>\n");
      out.write("                            ");
      out.print(postP.getFullName());
      out.write("\n");
      out.write("                            <button>");
      out.print(Utils.CovertRelation.check(r, p.getPersonID(), postP.getPersonID()));
      out.write("</button>\n");
      out.write("                        </h4>\n");
      out.write("                        <button class=\"more\" onclick=\"BackPage()\">\n");
      out.write("                            <i class=\"fa fa-ellipsis-v\" aria-hidden=\"true\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <h5>");
      out.print(post.getContent());
      out.write("</h5>\n");
      out.write("                    <span class=\"reaction\">\n");
      out.write("                        <span class=\"funtion\">\n");
      out.write("                            ");
 String color = Utils.CovertBravo.checkBravo(b, p.getPersonID(), post.getID());
      out.write("\n");
      out.write("                            <button style=\"color: ");
      out.print(color);
      out.write("\">\n");
      out.write("                                <i class=\"fa fa-sign-language\" aria-hidden=\"true\"></i>\n");
      out.write("\n");
      out.write("                                <span style= \"color: ");
      out.print(color);
      out.write('"');
      out.write('>');
      out.print(post.getNBravo() + " ");
      out.write("Bravo</span>\n");
      out.write("                            </button>\n");
      out.write("                        </span>\n");
      out.write("\n");
      out.write("                        <span class=\"funtion\">\n");
      out.write("                            <button>\n");
      out.write("                                <i class=\"fa fa-comment-o\" aria-hidden=\"true\"></i>\n");
      out.write("\n");
      out.write("                                <span>Reaction</span>\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                        </span>\n");
      out.write("\n");
      out.write("                        <span class=\"funtion\">\n");
      out.write("                            ");
 String textPin = Utils.CovertPin.checkPin(pin, p.getPersonID(), post.getUrlImg());
                                String colorPin = "";
                                if (textPin.equalsIgnoreCase("Pined")) {
                                    colorPin += "#2ecc71";
                                } else {
                                    colorPin += "null";
                                }
                            
      out.write("\n");
      out.write("                            <button style=\"color: ");
      out.print(colorPin);
      out.write("\">\n");
      out.write("                                <i class=\"fa fa-thumb-tack\" aria-hidden=\"true\" style=\"color: ");
      out.print(colorPin);
      out.write("\"></i>\n");
      out.write("                                <span>");
      out.print( textPin);
      out.write("</span>\n");
      out.write("                            </button>\n");
      out.write("                        </span>\n");
      out.write("                    </span>\n");
      out.write("                    <div class=\"box-cmt\">\n");
      out.write("                        <div class=\"list-cmt\">\n");
      out.write("                            <ul>\n");
      out.write("                                ");
 for (Comment cmt : list) {
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"user\">\n");
      out.write("                                        <span class=\"bg-img\">\n");
      out.write("                                            <img class=\"imgs\" src=\"");
      out.print(cmt.getPerson().getAvatar());
      out.write("\" alt=\"error\">\n");
      out.write("                                        </span>\n");
      out.write("                                        <div class=\"comment-cmt\">\n");
      out.write("                                            <a class=\"name\">");
      out.print(cmt.getPerson().getFullName());
      out.write("</a>\n");
      out.write("                                            <span class=\"post\">");
      out.print(cmt.getContent());
      out.write("</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                ");
}
      out.write("             \n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"answer\">\n");
      out.write("                            <div class=\"bg-img\">\n");
      out.write("                                <img class=\"imgs\" src=\"");
      out.print(p.getAvatar());
      out.write("\" alt=\"error\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"post-cmt-sec\">\n");
      out.write("                                <form method=\"GET|POST\">\n");
      out.write("                                    <input class=\"rep\" type=\"text\" placeholder=\"Add a comment...\">\n");
      out.write("                                    <button>Post</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <span class=\"close\">\n");
      out.write("                <button>\n");
      out.write("                    <i class=\"fa fa-times\" aria-hidden=\"true\"></i>\n");
      out.write("                </button>\n");
      out.write("            </span>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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
