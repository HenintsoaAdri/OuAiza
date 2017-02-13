<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="traitement.*,java.sql.Date"%>
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
 <% String nom = ""; String prenom = ""; String email = ""; String dateN = "" ; String adresse = "";  %>
  <body class="grey lighten-5">
    <div class="container">
      <a href="<% out.print(Traitement.getInternUrl()); %>menu.jsp"><img src="../img/logo.png" alt="" width="250px" class="right"/></a>
      <div class="row">
        <div class="col m8 l6">
          <div class="row card-panel hoverable">
            <div class="col s12">
              <p class="flow-text">
                Inscrivez vous.
              </p>
            </div>
            <% 
         try{
            if(request.getParameter("inscription")!=null){
	           	nom = request.getParameter("nom");
	           	prenom = request.getParameter("prenom");
	           	email = request.getParameter("email");
	           	dateN = request.getParameter("dateN");
	           	adresse = request.getParameter("adresse");
            }
            %>
            <form class="col s12" action="#" method="post">
              <div class="row">
                <div class="input-field col s6">
                  <i class="material-icons prefix">account_circle</i>
                  <input name="nom" type="text" class="validate" value="<% out.print(nom); %>">
                  <label for="nom">Votre nom</label>
                </div>
                <div class="input-field col s6">
                  <input name="prenom" type="text" class="validate" value="<% out.print(prenom); %>">
                  <label for="prenom">Votre pr&eacute;nom</label>
                </div>
                <div class="input-field col s12">
                  <i class="material-icons prefix">mail</i>
                  <input name="email" type="email" class="validate" value="<% out.print(email); %>">
                  <label for="email" data-error="invalide" data-success="valide">Votre Adresse email</label>
                </div>
                <div class="input-field col s6">
                  <i class="material-icons prefix">lock_outline</i>
                  <input name="password" type="password" class="validate">
                  <label for="password">Votre Mot de passe</label>
                </div>                
                <div class="input-field col s6">
                  <input name="confirmpassword" type="password" class="validate">
                  <label for="confirmpassword">Confirmez votre mot de passe</label>
                </div>
                <div class="input-field col s12">
                  <i class="material-icons prefix">event</i>
                  <input name="dateN" type="date" class="datepicker" value="<% out.print(dateN); %>">
                  <label for="dateN">Votre Date de naissance</label>
                </div>
                <p class="col s12">
                  <i class="material-icons prefix">wc</i>
                  <input class="with-gap" name="sexe" type="radio" value="homme" id="homme" />
                  <label for="homme">Homme</label>
                  
                  <input class="with-gap" name="sexe" type="radio" value="femme" id="femme" />
                  <label for="femme">Femme</label>
                </p>
                <div class="input-field col s6">
                   <i class="material-icons prefix">home</i>
                   <input name="adresse" type="tel" class="validate" value="<% out.print(adresse); %>">
                   <label for="adresse">Adresse</label>
                </div>
                <div class="input-field col s6">
			      <select class="icons" name="region"  required>
			        <option disabled selected>Choisissez une r&eacute;gion</option>
			      <% for(model.Region r : TraitementLieu.getRegion()) { %>
			        <option value="<% out.print(r.getId()); %>" data-icon="../img/<% out.print(r.getImageRegion()); %>"><% out.print(r.getRegion()); %></option>
			      <% } %>
			      </select>
			      <label>R&eacute;gion</label>
			    </div>
                <div class="input-field col s12">
                  <button class="waves-effect waves-light btn" type="submit" name="inscription"><i class="material-icons right">chevron_right</i>Inscription</button>
                </div>
              </div>
              Vous avez d&eacute;j&agrave; un compte? <a href = "Login.jsp">Connectez - vous ici !</a>
              <% if(request.getParameter("inscription") != null){
            	  	String region = request.getParameter("region");
            	  	String password = request.getParameter("password");
            	  	String confirmpassword = request.getParameter("confirmpassword");
            	  	String sexe = request.getParameter("sexe");
              		TraitementProfil.inscription(region, nom, prenom, dateN, sexe, email, password, confirmpassword, adresse);
              		session.setAttribute("newAccount", true);
              		response.sendRedirect("Confirm.jsp");
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
        <div class="col m4 l6 right-align flow-text">
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
        $('select').material_select();
        Materialize.updateTextFields();
        $('.datepicker').pickadate({
           max: new Date(),
           selectMonths: true,
           selectYears: 110
         });
      });
    </script>
  </body>
</html>