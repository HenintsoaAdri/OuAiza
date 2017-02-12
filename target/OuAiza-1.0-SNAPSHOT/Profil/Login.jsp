<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="traitement.*"%>
<% if(session.getAttribute("Profil") != null){
	response.sendRedirect("index.jsp");
} %>
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
      <a href="<% out.print(Traitement.getInternUrl()); %>menu.jsp"><img src="../img/logo.png" alt="" width="250px" class="right"/></a>
      <div class="row">
        <div class="col m6">
          <div class="row card-panel valign-wrapper hoverable">
            <div class="col s12">
              <p class="flow-text">
                Connectez vous.
              </p>
            </div>
            <% String email = "";
            if(request.getParameter("email")!=null){
            	email = request.getParameter("email");
            } %>
            <form class="col s12 valign" method="post" action="#">
              <div class="row">
                <div class="input-field col s12">
                  <i class="material-icons prefix">mail_outline</i>
                  <input name="email" type="email" class="validate" value="<% out.print(email); %>">
                  <label for="email" data-error="invalide" data-success="valide">Adresse email</label>
                </div>
                <div class="input-field col s12">
                  <i class="material-icons prefix">lock_outline</i>
                  <input name="password" type="password" class="validate">
                  <label for="password">Mot de passe</label>
                </div>
                <div class="input-field col s12">
                  <button type="submit" name="connect" class="waves-effect waves-light btn"><i class="material-icons right">chevron_right</i>Connexion</button>
                </div>
              </div>
              	Vous n'avez pas encore de compte? <a href = "SignUp.jsp">Inscrivez - vous gratuitement</a>
              <% try{
            	  if(request.getParameter("connect")!=null){
            		  String password = request.getParameter("password");
            		  TraitementProfil.connexion(email, password, session, response);
            	  }
              }catch(Exception e){ 
           		e.printStackTrace(); %>
           		<div class="card-panel red lighten-2">
  		          <span class="white-text">Probl&egrave;me! <% out.print(e.getMessage()); %></span>
  		        </div>
           <% } %>
            </form>
          </div>
        </div>
        <div class="col s6 right-align flow-text">
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
