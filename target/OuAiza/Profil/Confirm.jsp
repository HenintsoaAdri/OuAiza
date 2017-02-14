<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="traitement.*,utilitaire.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>O&ugrave; Aiza</title>
    <link rel="stylesheet" href="../css/materialize.min.css">
    <link rel="stylesheet" href="../fonts/material-icons.css">
    <link rel="stylesheet" href="../css/main.css" media="screen" title="no title" charset="utf-8">
    <link rel="apple-touch-icon" sizes="57x57" href="../img/icon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="../img/icon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="../img/icon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="../img/icon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="../img/icon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="../img/icon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="../img/icon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="../img/icon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="../img/icon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192"  href="../img/icon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../img/icon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../img/icon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../img/icon/favicon-16x16.png">
    <link rel="manifest" href="../img/icon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="../img/icon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
  </head>
  <body class="grey lighten-5">
    <div class="container">
      <img src="../img/logo.png" alt="" width="250px" class="right"/>
      <div class="row">
        <div class="col m6">
          <div class="row card-panel valign-wrapper hoverable">
            <div class="col s12">
              <% try{
            	  System.out.print((Boolean)session.getAttribute("newAccount"));
            	   if(request.getParameter("account")!=null){
	          			String account = request.getQueryString();
	          			try {
	          				TraitementProfil.confirm(account);
	          				session.removeAttribute("newAccount");
	          				response.sendRedirect("index.jsp");
	          			} catch (Exception e) {
	          				e.printStackTrace();
	          				throw new Exception("Lien erronn&eacute;");
	          			}
	          		}
            	   else if(session.getAttribute("newAccount")!=null)out.print("Veuillez v&eacute;rifier votre boite email et confirmer la création de votre nouveau compte!");
            	   else{
	          			throw new Exception("Vous vous trompez de chemin ! <a href = \""+Traitement.getInternUrl()+"\">C'est par ici</a>");
	          		}
	              }catch(Exception e){ 
	           		e.printStackTrace(); 
	           		out.print(e.getMessage()); 
	           	   } %>
            </div>
          </div>
        </div>
        <div class="col s6 right-align">
          O&ugrave; Aiza ? Le réseau qui réunit les malgaches aux festivit&eacute;s dans tout Madagascar.
          Vous y retrouverez les &eacute;v&eacute;nements &agrave; ne pas rater, les lieux les plus pris&eacute;s mais aussi les recommandations des internautes, sans oublier les organisateurs du pays !
          N'attendez plus, rejoignez nous au plus vite et poster vos recommandations !
        </div>
      </div>
    </div>
    <script src="../js/jquery.min.js" charset="utf-8"></script>
    <script src="../js/materialize.min.js" charset="utf-8"></script>
    <script>
      $(document).ready(function() {
        Materialize.updateTextFields();
      });
    </script>
  </body>
</html>
