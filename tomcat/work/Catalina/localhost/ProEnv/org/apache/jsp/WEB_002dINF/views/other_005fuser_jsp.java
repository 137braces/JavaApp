/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-11-17 09:05:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.*;

public final class other_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- ServletからArryaListでデータ渡し -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/other_user.css\">\n");
      out.write("<link href=\"https://use.fontawesome.com/releases/v6.2.0/css/all.css\" rel=\"stylesheet\">\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/vue@2.*/dist/vue.js\"></script>\n");
      out.write("\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.js\"></script>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n");
      out.write("        <title>Java - paiza</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- セッションスコープからログインユーザーのIDを取得する -->\n");
      out.write("        ");
String user_name = (String)session.getAttribute("name");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- リクエストスコープから受け取ったidを基に他ユーザーの詳細情報を取得する -->\n");
      out.write("        ");
String id = (String)request.getAttribute("id"); 
      out.write("\n");
      out.write("        ");
String age = (String)request.getAttribute("age");
      out.write("\n");
      out.write("        ");
String other_user_name = (String)request.getAttribute("name");
      out.write("\n");
      out.write("        ");
String image = (String)request.getAttribute("image");
      out.write("\n");
      out.write("        ");
String address = (String)request.getAttribute("address");
      out.write("\n");
      out.write("        ");
String job = (String)request.getAttribute("job");
      out.write("\n");
      out.write("        \n");
      out.write("  \n");
      out.write("        <header id=\"header\">\n");
      out.write("          <h3 class=\"logo\"><a href=\"#\">Java Portfolio</a></h3>\n");
      out.write("          <nav>\n");
      out.write("            <ul class=\"nav__list\">\n");
      out.write("              <li class=\"nav__item\"><a href=\"user\">プロフィール</a></li>\n");
      out.write("              <li class=\"nav__item\"><a href=\"search\">さがす</a></li>\n");
      out.write("              <li class=\"nav__item\"><a href=\"setting\">各種設定</a></li>\n");
      out.write("              <li class=\"nav__item\"><a href=\"logout\">ログアウト</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("          <img style=\"border-radius:50%; width:150px; height:150px; border: solid 1px #6b6767;\" \n");
      out.write("          src= \"");
      out.print(request.getContextPath() );
      out.print( image );
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("  \n");
      out.write("        <p style=\"text-align: center;\"><span class=\"user-info\">");
      out.print( other_user_name );
      out.write("</span></p>\n");
      out.write("        \n");
      out.write("        <div class=\"profile_eria\">\n");
      out.write("          <h4>ABOUT</h4>\n");
      out.write("          <p>年齢 : <span class=\"user-info\">");
      out.print( age );
      out.write("歳</span></p>\n");
      out.write("          <p>居住地 : <span class=\"user-info\">");
      out.print( address );
      out.write("</span></p>\n");
      out.write("          <p>職業 : <span class=\"user-info\">");
      out.print( job );
      out.write("</span></p>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form id=\"follow_button\">\n");
      out.write("          <a type=\"submit\" name=\"followee_id\" value=\"");
      out.print(id );
      out.write("\" v-if=\"isActive\" v-on:click=\"active\" class=\"btn btn--orange btn--radius followYet\"><i class=\"fa-solid fa-heart\"></i>いいね！</a>\n");
      out.write("          <a v-else class=\"btn btn--orange btn--radius followDone\"><i class=\"fa-solid fa-heart\"></i>いいね！</a>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("  //いいね！機能\n");
      out.write("  \n");
      out.write("  const follow = new Vue ({\n");
      out.write("    el:'#follow_button',\n");
      out.write("    data:{\n");
      out.write("      isActive:true\n");
      out.write("    },\n");
      out.write("    \n");
      out.write("    methods:{\n");
      out.write("      active: function(){\n");
      out.write("        this.isActive = !this.isActive,\n");
      out.write("        axios\n");
      out.write("        .post('other_user',{followee_id:id})\n");
      out.write("        .then(response => (this.info = response))\n");
      out.write("        .catch(error => (this.error = error));\n");
      out.write("      }\n");
      out.write("  }\n");
      out.write("})\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("  .followDone{\n");
      out.write("    background-color: blue;\n");
      out.write("  }\n");
      out.write("  .followYet{\n");
      out.write("    background-color: #df5da2;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  .btn--orange,\n");
      out.write("  a.btn--orange {\n");
      out.write("    color: #fff;\n");
      out.write("    \n");
      out.write("    padding-top:20px;\n");
      out.write("    padding-bottom:20px;\n");
      out.write("    padding-left:50px;\n");
      out.write("    padding-right:50px;\n");
      out.write("  }\n");
      out.write("  /*.btn--orange:hover,\n");
      out.write("  a.btn--orange:hover {\n");
      out.write("    color: #fff;\n");
      out.write("    background: #df5da2;\n");
      out.write("  }*/\n");
      out.write("\n");
      out.write("  a.btn--radius {\n");
      out.write("    border-radius: 100vh;\n");
      out.write("    \n");
      out.write("  }\n");
      out.write("\n");
      out.write("  .buttoncolor {\n");
      out.write("    background-color: green;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  .container{\n");
      out.write("  margin-top:110px;\n");
      out.write("  display: flex;\n");
      out.write("  justify-content: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".profile_eria{\n");
      out.write("  text-align: center;\n");
      out.write("  margin-bottom: 30px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#follow_button{\n");
      out.write("  text-align: center;\n");
      out.write("}\n");
      out.write("p{\n");
      out.write("  color:#282829;\n");
      out.write("}\n");
      out.write("</style>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
