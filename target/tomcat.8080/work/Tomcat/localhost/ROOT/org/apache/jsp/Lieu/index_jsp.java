/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.30
 * Generated at: 2017-02-13 17:04:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Lieu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.*;
import traitement.*;
import java.util.Vector;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/Lieu/header.jsp", Long.valueOf(1486907156000L));
    _jspx_dependants.put("/Lieu/footer.jsp", Long.valueOf(1486777940000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("traitement");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Vector");
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
      out.write("\r\n");
	Profil p = (Profil)session.getAttribute("Profil"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("  \t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>O&ugrave; Aiza - Lieu</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/materialize.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/default.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../fonts/material-icons.css\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"../img/icon/apple-icon-57x57.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"../img/icon/apple-icon-60x60.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"../img/icon/apple-icon-72x72.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"../img/icon/apple-icon-76x76.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"../img/icon/apple-icon-114x114.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"../img/icon/apple-icon-120x120.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"../img/icon/apple-icon-144x144.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"../img/icon/apple-icon-152x152.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"../img/icon/apple-icon-180x180.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"192x192\" href=\"../img/icon/android-icon-192x192.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"../img/icon/favicon-32x32.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"../img/icon/favicon-96x96.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"../img/icon/favicon-16x16.png\">\r\n");
      out.write("    <link rel=\"manifest\" href=\"../img/icon/manifest.json\">\r\n");
      out.write("    <meta name=\"msapplication-TileColor\" content=\"#ffffff\">\r\n");
      out.write("    <meta name=\"msapplication-TileImage\" content=\"/img/icon/ms-icon-144x144.png\">\r\n");
      out.write("    <meta name=\"theme-color\" content=\"#ffffff\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <nav class=\"teal accent-4\">\r\n");
      out.write("      <div class=\"nav-wrapper\">\r\n");
      out.write("        <a href=\"");
 out.print(Traitement.getInternUrl()); 
      out.write("menu.jsp\" class=\"brand-logo\"><img src=\"../img/logo.png\" width=\"150px\"></a>\r\n");
      out.write("        <a href=\"\" data-activates=\"mobile-demo\" class=\"button-collapse\"><i class=\"material-icons\">menu</i></a>\r\n");
      out.write("        <a href=\"\" data-activates=\"slide-out\" class=\"button-collapse right hide-on-large-only\"><i class=\"material-icons right\">view_module</i></a>\r\n");
      out.write("        <ul class=\"right hide-on-med-and-down\">\r\n");
      out.write("          <li><a href=\"\" data-activates=\"slide-out\" class=\"button-collapse show-on-large\"><i class=\"material-icons left\">view_module</i>Menu</a></li>\r\n");
      out.write("          <li><a href=\"Recherche.jsp\"><i class=\"material-icons left\">search</i>Recherche</a></li>\r\n");
      out.write("          ");
 if(session.getAttribute("Profil")!=null){ 
      out.write("\r\n");
      out.write("          <li><a href=\"../Profil/Deconnexion?logout=true\"><i class=\"material-icons left\">exit_to_app</i>Deconnexion</a></li>\r\n");
      out.write("        \t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t  <li><a href=\"../Profil/Login.jsp\"><i class=\"material-icons left\">input</i>Se connecter</a>\r\n");
      out.write("\t\t  <li><a href=\"../Profil/SignUp.jsp\"><i class=\"material-icons left\">plus_one</i>S'inscrire</a>\r\n");
      out.write("\t\t  \t");
 } 
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"side-nav\" id=\"mobile-demo\">\r\n");
      out.write("          <li><a href=\"Recherche.jsp\"><i class=\"material-icons left\">search</i>Recherche</a></li>\r\n");
      out.write("          ");
 if(session.getAttribute("Profil")!=null){ 
      out.write("\r\n");
      out.write("          <li><a href=\"../Profil/Deconnexion?logout=true\"><i class=\"material-icons left\">exit_to_app</i>Deconnexion</a></li>\r\n");
      out.write("        \t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t  <li><a href=\"../Profil/Login.jsp\"><i class=\"material-icons left\">input</i>Se connecter</a>\r\n");
      out.write("\t\t  <li><a href=\"../Profil/SignUp.jsp\"><i class=\"material-icons left\">plus_one</i>S'inscrire</a>\r\n");
      out.write("\t\t  \t");
 } 
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <ul id=\"slide-out\" class=\"side-nav\">\r\n");
      out.write("      <li>\r\n");
      out.write("      ");
 if(p!=null){ 
      out.write("\r\n");
      out.write("      <div class=\"userView\">\r\n");
      out.write("        <div class=\"background\">\r\n");
      out.write("          <img src=\"../img/party.jpg\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <a href=\"../Profil\"><img class=\"circle\" src=\"");
 out.print(Traitement.getInternUrl()); 
      out.write("imgProfil/");
 out.print(p.getPhoto());
      out.write("\"></a>\r\n");
      out.write("        <a href=\"../Profil\"><span class=\"white-text name\">@");
 out.print(p.getIdentifiant()); 
      out.write("</span></a>\r\n");
      out.write("        <a href=\"../Profil\"><span class=\"white-text name\">");
 out.print(p.getFullName()); 
      out.write("</span></a>\r\n");
      out.write("        <a href=\"../Profil\"><span class=\"white-text email\">");
 out.print(p.getEmail()); 
      out.write("</span></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"active\"><a class=\"waves-effect\" href=\"../Lieu\"><i class=\"material-icons\">place</i> Lieu</a></li>\r\n");
      out.write("      <li><a class=\"waves-effect\" href=\"../Evenement\"><i class=\"material-icons\">local_bar</i> &Eacute;v&eacute;nement</a></li>\r\n");
      out.write("      <li><a class=\"waves-effect\" href=\"../Organisateur\"><i class=\"material-icons\">group</i> Organisateur</a></li>\r\n");
      out.write("      <li><a class=\"waves-effect\" href=\"../Profil\"><i class=\"material-icons\">person</i> Mon Profil</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\t\t<h3><i class=\"material-icons small\">place</i>Lieu</h3>\r\n");
      out.write("      \t<div class=\"divider\"></div>");
      out.write('\r');
      out.write('\n');
  int offset = 0;
	if(request.getParameter("page")!=null) offset = Integer.valueOf(request.getParameter("page"));
	try{
	Vector<Lieu> lieu = TraitementLieu.getListeLieu(offset*10);

      out.write("\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col s12 l8\">\r\n");
      out.write("           ");
 if(lieu.isEmpty()){ 
      out.write("\r\n");
      out.write("          \t <div class=\"card-panel red lighten-2\">\r\n");
      out.write("        \t\t<span class=\"white-text\">Probl&egrave;me! Aucun lieu &agrave; vous proposer</span>\r\n");
      out.write("      \t\t  </div>\r\n");
      out.write("          \t ");
 } 
      out.write("\r\n");
      out.write("          <div class=\"card\">\r\n");
      out.write("            <ul class=\"text-left collection\">\r\n");
      out.write("          ");
 for(Lieu l : lieu){ 
      out.write("\r\n");
      out.write("              <li class=\"collection-item avatar row\">\r\n");
      out.write("      \t\t\t<img src=\"");
 out.print(Traitement.getInternUrl()); 
      out.write("imgLieu/");
 out.print(l.getLogo()); 
      out.write("\" alt=\"\" class=\"circle\">\t\r\n");
      out.write("                <p>");
 out.print(l.getNom()); 
      out.write("</p>\r\n");
      out.write("              \t<p>\r\n");
      out.write("               \t<i class=\"material-icons red-text lighten-2\">");
 out.print(l.getEtoile().getRate()); 
      out.write("</i>\r\n");
      out.write("             \t</p>\r\n");
      out.write("             \t<p><img width=\"20px\" alt=\"");
 out.print(l.getRegion().getRegion()); 
      out.write("\" src=\"../img/");
 out.print(l.getRegion().getImageRegion()); 
      out.write("\"> \r\n");
      out.write("                ");
 out.print(l.getRegion().getRegion()); 
      out.write("\r\n");
      out.write("              \t</p>\r\n");
      out.write("              \t<p><a href=\"../Recommandation/CreateRecommandation.jsp?with=");
 out.print(l.getId()); 
      out.write("\" class=\"btn btn-success waves-effect waves-light\">Recommander</a></p>\r\n");
      out.write("                <a href=\"Detail.jsp?get=");
 out.print(l.getId()); 
      out.write("\" class=\"secondary-content\"><i class=\"material-icons\">chevron_right</i></a>\r\n");
      out.write("              </li>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("          <ul class=\"pagination center\">\r\n");
      out.write("            <li class=\"disabled\"><a href=\"#!\"><i class=\"material-icons\">chevron_left</i></a></li>\r\n");
      out.write("            ");
 for(int i=0;i<5;i++){ 
            	if(i == offset){ 
      out.write("\r\n");
      out.write("            <li class=\"waves-effect active\">\r\n");
      out.write("            \t<a>");
out.print(i+1);
      out.write("</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            ");
 }else{ 
      out.write("\r\n");
      out.write("            <li class=\"waves-effect");
if(i == offset)out.print(" active");
      out.write("\">\r\n");
      out.write("            \t<a href=\"?page=");
out.print(i);
      out.write('"');
      out.write('>');
out.print(i+1);
      out.write("</a>\r\n");
      out.write("            </li>\t\r\n");
      out.write("\t\t\t");
 }
              } 
      out.write("\r\n");
      out.write("            <li class=\"waves-effect\"><a href=\"?page=");
 out.print(offset+1);
      out.write("\"><i class=\"material-icons\">chevron_right</i></a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col s12 l4\">\r\n");
      out.write("        \t<h5 class=\"center\">Recommandations</h5>\r\n");
      out.write("        ");
 for(Recommandation r : TraitementRecommandation.getRecommandation(0)){ 
      out.write("\r\n");
      out.write("          <div class=\"row\">\r\n");
      out.write("            <div class=\"col s12\">\r\n");
      out.write("              <div class=\"card\">\r\n");
      out.write("                  <div class=\"card-image waves-effect waves-block waves-light\">\r\n");
      out.write("                    <img class=\"activator\" src=\"");
 out.print(Traitement.getInternUrl()); 
      out.write("imgRecommandation/");
 out.print(r.getImage()); 
      out.write("\">\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"card-content\">\r\n");
      out.write("                    <span class=\"card-title activator grey-text text-darken-4\">");
 out.print(r.getLieu().getNom()); 
      out.write("<i class=\"material-icons right\">more_vert</i></span>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                    \t<div class=\"col s3\">\r\n");
      out.write("                    \t\t<img src=\"");
 out.print(Traitement.getInternUrl()); 
      out.write("imgProfil/");
 out.print(r.getProfil().getPhoto()); 
      out.write("\" alt=\"\" class=\"circle responsive-img\">\r\n");
      out.write("                    \t</div>\r\n");
      out.write("                    \t<div class=\"col s9\">\r\n");
      out.write("                    \t\t<p><a href=\"../Profil/Compte.jsp?account=");
 out.print(r.getProfil().getIdentifiant()); 
      out.write('"');
      out.write('>');
      out.write('@');
 out.print(r.getProfil().getIdentifiant()); 
      out.write("</a></p>\r\n");
      out.write("                    \t\t<i class=\"material-icons red-text lighten-2\" title=\"");
 out.print(r.getEtoile().getVoteString());
      out.write("\">\r\n");
      out.write("                    \t\t\t");
 out.print(r.getEtoile().getRate()); 
      out.write("\r\n");
      out.write("                    \t\t</i>\r\n");
      out.write("                    \t\t<p>");
 out.print(r.getEtoile().getMoyenneString()); 
      out.write("</p>\r\n");
      out.write("                    \t</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \t\t<p><a href=\"../Recommandation/Detail.jsp?get=");
 out.print(r.getId()); 
      out.write("\">Voir les détails</a></p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"card-reveal\">\r\n");
      out.write("                    <span class=\"card-title grey-text text-darken-4\">");
 out.print(r.getLieu().getNom()); 
      out.write("<i class=\"material-icons right\">close</i></span>\r\n");
      out.write("                    <div class=\"row valign-wrapper\">\r\n");
      out.write("                      <div class=\"col s3\">\r\n");
      out.write("                        <img src=\"");
 out.print(Traitement.getInternUrl()); 
      out.write("imgProfil/");
 out.print(r.getProfil().getPhoto()); 
      out.write("\" alt=\"\" class=\"circle responsive-img\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div class=\"col s9\">\r\n");
      out.write("                      \t<a href=\"../Profil/Compte.jsp?account=");
 out.print(r.getProfil().getIdentifiant()); 
      out.write("\"><span>@");
 out.print(r.getProfil().getIdentifiant()); 
      out.write("</span></a>\r\n");
      out.write("                        <span class=\"black-text\">\r\n");
      out.write("                          ");
 out.print(r.getDescription()); 
      out.write("\r\n");
      out.write("                        </span>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
 }catch(Exception e){ 
		e.printStackTrace(); 
      out.write("\r\n");
      out.write("\t\t<div class=\"card-panel red lighten-2\">\r\n");
      out.write("        \t<span class=\"white-text\">Probl&egrave;me! ");
 out.print(e.getMessage()); 
      out.write("</span>\r\n");
      out.write("      \t</div>\t\r\n");
	} 
      out.write('\r');
      out.write('\n');
      out.write("    </div>\r\n");
      out.write("    <script src=\"../js/jquery.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"../js/materialize.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"../js/function.js\" charset=\"utf-8\"></script> \r\n");
      out.write("    <script>\r\n");
      out.write("\t    $(document).ready(function(){\r\n");
      out.write("\t\t  $('select').material_select();\r\n");
      out.write("\t\t  $(\".button-collapse\").sideNav();\r\n");
      out.write("\t      $('.carousel').carousel();\r\n");
      out.write("\t      $('.modal').modal();\r\n");
      out.write("\t    });\r\n");
      out.write("    </script>\r\n");
      out.write("  </body>\r\n");
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
