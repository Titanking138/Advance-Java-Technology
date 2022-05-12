package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license\n");
      out.write("Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>login form</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"SignInContaier\">\n");
      out.write("            <div class=\"column\">\n");
      out.write("                <div class=\"header\">\n");
      out.write("                    <h3>Sign In</h3>\n");
      out.write("                    <span>Continue to Result Portal </span>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"valid.jsp\" method=\"POST\">\n");
      out.write("                    <input type=\"text\" name=\"uname\" id=\"uname\" placeholder=\"uname\" />\n");
      out.write("                    <input type=\"text\" name=\"test\" />\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Password\" />\n");
      out.write("                    <input type=\"submit\" value=\"SUBMIT\" name=\"submitButton\" />\n");
      out.write("                    <!--<script>alert(\"entered\");</script>-->\n");
      out.write("                </form>\n");
      out.write("                <!--<span> have account ? Make one <a href=\"\" class=\"signInMessage\">here</a></span>-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
