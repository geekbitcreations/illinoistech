/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.5
 * Generated at: 2018-04-27 01:06:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class delivery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Hitch: Request a Delivery</title>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Khand\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write(" <header>\r\n");
      out.write("    <img src=\"images/hitch.png\" id=\"logo\">\r\n");
      out.write("    <h1 class=\"myheader\">HITCH</h1>\r\n");
      out.write("      \r\n");
      out.write("    <nav id=\"navmenu\">\r\n");
      out.write("      <ul>\r\n");
      out.write("        <li id=\"nav-home\"><a href=\"main.jsp\">Home</a></li>\r\n");
      out.write("        <li id=\"nav-ride\"><a href=\"ride.jsp\">Ride</a></li>\r\n");
      out.write("        <li id=\"nav-profile\"><a href=\"profile.jsp\">Profile</a></li>\r\n");
      out.write("        <li id=\"nav-delivery\"><a href=\"delivery.jsp\">Delivery</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("  </header>\r\n");
      out.write("  <img class=\"services\" src=\"images/delivery.png\">\r\n");
      out.write("  <h1 class=\"request\">Request a Delivery</h1>\r\n");
      out.write("    <form class=\"delivery\" action=\"/action_page.php\" target=\"_blank\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("      <h3 class=\"location\">PICK-UP LOCATION:</h3>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>Street Address:</label>\r\n");
      out.write("        <input type=\"text\" name=\"street1\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>City:</label>\r\n");
      out.write("        <input type=\"text\" name=\"city1\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>State:</label>\r\n");
      out.write("        <select name=\"state1\">\r\n");
      out.write("\t\t\t<option value=\"AL\">Alabama</option>\r\n");
      out.write("\t\t\t<option value=\"AK\">Alaska</option>\r\n");
      out.write("\t\t\t<option value=\"AZ\">Arizona</option>\r\n");
      out.write("\t\t\t<option value=\"AR\">Arkansas</option>\r\n");
      out.write("\t\t\t<option value=\"CA\">California</option>\r\n");
      out.write("\t\t\t<option value=\"CO\">Colorado</option>\r\n");
      out.write("\t\t\t<option value=\"CT\">Connecticut</option>\r\n");
      out.write("\t\t\t<option value=\"DE\">Delaware</option>\r\n");
      out.write("\t\t\t<option value=\"DC\">District Of Columbia</option>\r\n");
      out.write("\t\t\t<option value=\"FL\">Florida</option>\r\n");
      out.write("\t\t\t<option value=\"GA\">Georgia</option>\r\n");
      out.write("\t\t\t<option value=\"HI\">Hawaii</option>\r\n");
      out.write("\t\t\t<option value=\"ID\">Idaho</option>\r\n");
      out.write("\t\t\t<option value=\"IL\">Illinois</option>\r\n");
      out.write("\t\t\t<option value=\"IN\">Indiana</option>\r\n");
      out.write("\t\t\t<option value=\"IA\">Iowa</option>\r\n");
      out.write("\t\t\t<option value=\"KS\">Kansas</option>\r\n");
      out.write("\t\t\t<option value=\"KY\">Kentucky</option>\r\n");
      out.write("\t\t\t<option value=\"LA\">Louisiana</option>\r\n");
      out.write("\t\t\t<option value=\"ME\">Maine</option>\r\n");
      out.write("\t\t\t<option value=\"MD\">Maryland</option>\r\n");
      out.write("\t\t\t<option value=\"MA\">Massachusetts</option>\r\n");
      out.write("\t\t\t<option value=\"MI\">Michigan</option>\r\n");
      out.write("\t\t\t<option value=\"MN\">Minnesota</option>\r\n");
      out.write("\t\t\t<option value=\"MS\">Mississippi</option>\r\n");
      out.write("\t\t\t<option value=\"MO\">Missouri</option>\r\n");
      out.write("\t\t\t<option value=\"MT\">Montana</option>\r\n");
      out.write("\t\t\t<option value=\"NE\">Nebraska</option>\r\n");
      out.write("\t\t\t<option value=\"NV\">Nevada</option>\r\n");
      out.write("\t\t\t<option value=\"NH\">New Hampshire</option>\r\n");
      out.write("\t\t\t<option value=\"NJ\">New Jersey</option>\r\n");
      out.write("\t\t\t<option value=\"NM\">New Mexico</option>\r\n");
      out.write("\t\t\t<option value=\"NY\">New York</option>\r\n");
      out.write("\t\t\t<option value=\"NC\">North Carolina</option>\r\n");
      out.write("\t\t\t<option value=\"ND\">North Dakota</option>\r\n");
      out.write("\t\t\t<option value=\"OH\">Ohio</option>\r\n");
      out.write("\t\t\t<option value=\"OK\">Oklahoma</option>\r\n");
      out.write("\t\t\t<option value=\"OR\">Oregon</option>\r\n");
      out.write("\t\t\t<option value=\"PA\">Pennsylvania</option>\r\n");
      out.write("\t\t\t<option value=\"RI\">Rhode Island</option>\r\n");
      out.write("\t\t\t<option value=\"SC\">South Carolina</option>\r\n");
      out.write("\t\t\t<option value=\"SD\">South Dakota</option>\r\n");
      out.write("\t\t\t<option value=\"TN\">Tennessee</option>\r\n");
      out.write("\t\t\t<option value=\"TX\">Texas</option>\r\n");
      out.write("\t\t\t<option value=\"UT\">Utah</option>\r\n");
      out.write("\t\t\t<option value=\"VT\">Vermont</option>\r\n");
      out.write("\t\t\t<option value=\"VA\">Virginia</option>\r\n");
      out.write("\t\t\t<option value=\"WA\">Washington</option>\r\n");
      out.write("\t\t\t<option value=\"WV\">West Virginia</option>\r\n");
      out.write("\t\t\t<option value=\"WI\">Wisconsin</option>\r\n");
      out.write("\t\t\t<option value=\"WY\">Wyoming</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("      </p>\r\n");
      out.write("      <h3 class=\"location\">DROP-OFF LOCATION:</h3>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>Street Address:</label>\r\n");
      out.write("        <input type=\"text\" name=\"street2\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>City:</label>\r\n");
      out.write("        <input type=\"text\" name=\"city2\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>State:</label>\r\n");
      out.write("        <select name=\"state2\">\r\n");
      out.write("\t\t\t<option value=\"AL\">Alabama</option>\r\n");
      out.write("\t\t\t<option value=\"AK\">Alaska</option>\r\n");
      out.write("\t\t\t<option value=\"AZ\">Arizona</option>\r\n");
      out.write("\t\t\t<option value=\"AR\">Arkansas</option>\r\n");
      out.write("\t\t\t<option value=\"CA\">California</option>\r\n");
      out.write("\t\t\t<option value=\"CO\">Colorado</option>\r\n");
      out.write("\t\t\t<option value=\"CT\">Connecticut</option>\r\n");
      out.write("\t\t\t<option value=\"DE\">Delaware</option>\r\n");
      out.write("\t\t\t<option value=\"DC\">District Of Columbia</option>\r\n");
      out.write("\t\t\t<option value=\"FL\">Florida</option>\r\n");
      out.write("\t\t\t<option value=\"GA\">Georgia</option>\r\n");
      out.write("\t\t\t<option value=\"HI\">Hawaii</option>\r\n");
      out.write("\t\t\t<option value=\"ID\">Idaho</option>\r\n");
      out.write("\t\t\t<option value=\"IL\">Illinois</option>\r\n");
      out.write("\t\t\t<option value=\"IN\">Indiana</option>\r\n");
      out.write("\t\t\t<option value=\"IA\">Iowa</option>\r\n");
      out.write("\t\t\t<option value=\"KS\">Kansas</option>\r\n");
      out.write("\t\t\t<option value=\"KY\">Kentucky</option>\r\n");
      out.write("\t\t\t<option value=\"LA\">Louisiana</option>\r\n");
      out.write("\t\t\t<option value=\"ME\">Maine</option>\r\n");
      out.write("\t\t\t<option value=\"MD\">Maryland</option>\r\n");
      out.write("\t\t\t<option value=\"MA\">Massachusetts</option>\r\n");
      out.write("\t\t\t<option value=\"MI\">Michigan</option>\r\n");
      out.write("\t\t\t<option value=\"MN\">Minnesota</option>\r\n");
      out.write("\t\t\t<option value=\"MS\">Mississippi</option>\r\n");
      out.write("\t\t\t<option value=\"MO\">Missouri</option>\r\n");
      out.write("\t\t\t<option value=\"MT\">Montana</option>\r\n");
      out.write("\t\t\t<option value=\"NE\">Nebraska</option>\r\n");
      out.write("\t\t\t<option value=\"NV\">Nevada</option>\r\n");
      out.write("\t\t\t<option value=\"NH\">New Hampshire</option>\r\n");
      out.write("\t\t\t<option value=\"NJ\">New Jersey</option>\r\n");
      out.write("\t\t\t<option value=\"NM\">New Mexico</option>\r\n");
      out.write("\t\t\t<option value=\"NY\">New York</option>\r\n");
      out.write("\t\t\t<option value=\"NC\">North Carolina</option>\r\n");
      out.write("\t\t\t<option value=\"ND\">North Dakota</option>\r\n");
      out.write("\t\t\t<option value=\"OH\">Ohio</option>\r\n");
      out.write("\t\t\t<option value=\"OK\">Oklahoma</option>\r\n");
      out.write("\t\t\t<option value=\"OR\">Oregon</option>\r\n");
      out.write("\t\t\t<option value=\"PA\">Pennsylvania</option>\r\n");
      out.write("\t\t\t<option value=\"RI\">Rhode Island</option>\r\n");
      out.write("\t\t\t<option value=\"SC\">South Carolina</option>\r\n");
      out.write("\t\t\t<option value=\"SD\">South Dakota</option>\r\n");
      out.write("\t\t\t<option value=\"TN\">Tennessee</option>\r\n");
      out.write("\t\t\t<option value=\"TX\">Texas</option>\r\n");
      out.write("\t\t\t<option value=\"UT\">Utah</option>\r\n");
      out.write("\t\t\t<option value=\"VT\">Vermont</option>\r\n");
      out.write("\t\t\t<option value=\"VA\">Virginia</option>\r\n");
      out.write("\t\t\t<option value=\"WA\">Washington</option>\r\n");
      out.write("\t\t\t<option value=\"WV\">West Virginia</option>\r\n");
      out.write("\t\t\t<option value=\"WI\">Wisconsin</option>\r\n");
      out.write("\t\t\t<option value=\"WY\">Wyoming</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>Package Size:</label>\r\n");
      out.write("            <select name=\"pkgsize\">\r\n");
      out.write("              <option value=\"xsmall\">EXTRA SMALL</option>\r\n");
      out.write("              <option value=\"small\">SMALL</option>\r\n");
      out.write("              <option value=\"medium\">MEDIUM</option>\r\n");
      out.write("              <option value=\"large\">LARGE</option>\r\n");
      out.write("              <option value=\"xlarge\">EXTRA LARGE</option>\r\n");
      out.write("            </select>\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>When would you like it delivered:</label>\r\n");
      out.write("            <select name=\"when\">\r\n");
      out.write("              <option value=\"asap\">ASAP</option>\r\n");
      out.write("              <option value=\"later\">LATER</option>\r\n");
      out.write("            </select>\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>Time:</label>\r\n");
      out.write("        <input type=\"time\" name=\"usertime\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <input type=\"submit\" value=\"Submit\" onclick=\"main.jsp\">\r\n");
      out.write("    </form>\r\n");
      out.write("  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\r\n");
      out.write("  <script  src=\"js/index.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
