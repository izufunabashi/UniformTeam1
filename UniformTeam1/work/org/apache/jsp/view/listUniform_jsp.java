/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2022-06-27 00:23:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import bean.*;

public final class listUniform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/headerAdmin.jsp", Long.valueOf(1655949770442L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("bean");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.ArrayList");
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--\r\n");
      out.write("プログラム名\t\t：ユニフォーム受注管理システム E組チーム１  listUniform.jsp\r\n");
      out.write("プログラムの説明\t：ユニフォーム受注管理システムの商品一覧画面です。\r\n");
      out.write("作成者\t\t\t\t：松本 楓\r\n");
      out.write("作成日\t\t\t\t：2022年6月24日\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

ArrayList<Uniform> list = (ArrayList<Uniform>) request.getAttribute("uniform_list");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/css/style.css\">\r\n");
      out.write("<title>商品一覧</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- ヘッダー部分 -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<!-- http://localhost:8080/UniformTeam1/common/headerAdmin.jsp -->\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\">\r\n");
      out.write("\t\t<title>ヘッダー</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<h2 class = \"admin\">ユニフォーム受注管理システム</h2>\r\n");
      out.write("\t\t<hr class=\"adminhr\">\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- メニュー部分 -->\r\n");
      out.write("\r\n");
      out.write("\t\t<h2 class=\"user\">商品一覧</h2>\r\n");
      out.write("\t\t<hr class=\"userhr\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<table class=\"ctable\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"200\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/logout\"><button>ログアウト</button></a></td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td width=\"50\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/login\"><button>ログイン</button></a></td>\r\n");
      out.write("\t\t\t\t<td width=\"50\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/showCart\"><button>カートを確認</button></a></td>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<hr class=\"userhr\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 商品一覧のコンテンツ部分 -->\r\n");
      out.write("\t\t<table class=\"uniformList\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\">商品名</td>\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\">商品画像</td>\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\">価格</td>\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\">数量</td>\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

                 //商品の数だけ繰り返す
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Uniform uniform = (Uniform) list.get(i);
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- リンクタグにidを追加（0627船橋） -->\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/detailUniform?id=");
      out.print( uniform.getId() );
      out.write('"');
      out.write('>');
      out.print(uniform.getUniformName());
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/image/tmp/");
      out.print(uniform.getImage() );
      out.write("\"\r\n");
      out.write("\t\t\t\t\talt=\"");
      out.print(uniform.getUniformName());
      out.write("\" width=\"100\"></td>\r\n");
      out.write("\t\t\t\t<td class=\"solidtd\">");
      out.print(uniform.getPrice());
      out.write("円</td>\r\n");
      out.write("\t\t\t\t<td  class=\"solidtd\">\r\n");
      out.write("\t\t\t\t\t<select name=\"uniformQuantity\">\r\n");
      out.write("\t\t\t\t\t\t");

							//在庫数の数だけ繰り返す
							int j = 0;
							for (j = 1; j <= uniform.getStock(); j++) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=");
      out.print(j);
      out.write('>');
      out.print(j);
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>着\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td  class=\"solidtd\">\r\n");
      out.write("\t\t\t\t\t<form action = \"");
      out.print(request.getContextPath());
      out.write("/insertIntoCart\" >\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" value=\"");
      out.print(uniform.getId());
      out.write("\" name=\"uniform_id\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value =\"カートに追加\" class = \"button\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t");

						}
							
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

					}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br> <br>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- フッター部分 -->\r\n");
      out.write("\t\t<hr class=\"userhr\">\r\n");
      out.write("\t\t<h4 class=\"user\">Copyright (C) 2022 All Rights Reserved.</h4>\r\n");
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