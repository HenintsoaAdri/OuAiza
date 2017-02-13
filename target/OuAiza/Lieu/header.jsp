<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*,traitement.*,java.util.Vector"%>
<%	Profil p = (Profil)session.getAttribute("Profil"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <title>O&ugrave; Aiza - Lieu</title>
    <link rel="stylesheet" href="../css/materialize.min.css">
    <link rel="stylesheet" href="../css/default.css">
    <link rel="stylesheet" href="../fonts/material-icons.css">
    <link rel="apple-touch-icon" sizes="57x57" href="../img/icon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="../img/icon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="../img/icon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="../img/icon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="../img/icon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="../img/icon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="../img/icon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="../img/icon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="../img/icon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="../img/icon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../img/icon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../img/icon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../img/icon/favicon-16x16.png">
    <link rel="manifest" href="../img/icon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/img/icon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
  </head>
  <body>
    <nav class="teal accent-4">
      <div class="nav-wrapper">
        <a href="<% out.print(Traitement.getInternUrl()); %>menu.jsp" class="brand-logo"><img src="../img/logo.png" width="150px"></a>
        <a href="" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
        <a href="" data-activates="slide-out" class="button-collapse right hide-on-large-only"><i class="material-icons right">view_module</i></a>
        <ul class="right hide-on-med-and-down">
          <li><a href="" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons left">view_module</i>Menu</a></li>
          <li><a href="Recherche.jsp"><i class="material-icons left">search</i>Recherche</a></li>
          <% if(session.getAttribute("Profil")!=null){ %>
          <li><a href="../Profil/Deconnexion?logout=true"><i class="material-icons left">exit_to_app</i>Deconnexion</a></li>
        	<% }else{ %>
		  <li><a href="../Profil/Login.jsp"><i class="material-icons left">input</i>Se connecter</a>
		  <li><a href="../Profil/SignUp.jsp"><i class="material-icons left">plus_one</i>S'inscrire</a>
		  	<% } %>
        </ul>
        <ul class="side-nav" id="mobile-demo">
          <li><a href="Recherche.jsp"><i class="material-icons left">search</i>Recherche</a></li>
          <% if(session.getAttribute("Profil")!=null){ %>
          <li><a href="../Profil/Deconnexion?logout=true"><i class="material-icons left">exit_to_app</i>Deconnexion</a></li>
        	<% }else{ %>
		  <li><a href="../Profil/Login.jsp"><i class="material-icons left">input</i>Se connecter</a>
		  <li><a href="../Profil/SignUp.jsp"><i class="material-icons left">plus_one</i>S'inscrire</a>
		  	<% } %>
        </ul>
      </div>
    </nav>
    <ul id="slide-out" class="side-nav">
      <li>
      <% if(p!=null){ %>
      <div class="userView">
        <div class="background">
          <img src="../img/party.jpg">
        </div>
        <a href="../Profil"><img class="circle" src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(p.getPhoto());%>"></a>
        <a href="../Profil"><span class="white-text name">@<% out.print(p.getIdentifiant()); %></span></a>
        <a href="../Profil"><span class="white-text name"><% out.print(p.getFullName()); %></span></a>
        <a href="../Profil"><span class="white-text email"><% out.print(p.getEmail()); %></span></a>
      </div>
      <% } %>
      </li>
      <li class="active"><a class="waves-effect" href="../Lieu"><i class="material-icons">place</i> Lieu</a></li>
      <li><a class="waves-effect" href="../Evenement"><i class="material-icons">local_bar</i> &Eacute;v&eacute;nement</a></li>
      <li><a class="waves-effect" href="../Organisateur"><i class="material-icons">group</i> Organisateur</a></li>
      <li><a class="waves-effect" href="../Profil"><i class="material-icons">person</i> Mon Profil</a></li>
    </ul>
    <div class="container">
		<h3><i class="material-icons small">place</i>Lieu</h3>
      	<div class="divider"></div>