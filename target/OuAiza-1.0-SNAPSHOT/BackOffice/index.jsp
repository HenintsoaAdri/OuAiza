<%@page contentType="text/html" pageEncoding="UTF-8"%>
% if(session.getAttribute("Admin")==null) sendRedirect("login.jsp");%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Back Office - Administrateur</title>
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
  <div class="container">
    <div class="row">
      <header>
        <div class="col m3 l2">
          <ul id="slide-out" class="side-nav fixed">
            <li class="logo center"><img src="../img/logo1-negatif.png" alt="" width="200px"></li>
            <li><a class="waves-effect waves-teal" href="Lieu"><i class="material-icons">location_on</i> Lieu</a></li>
            <li><a class="waves-effect waves-teal" href="Evenement"><i class="material-icons">local_bar</i> Ev&egrave;nement</a></li>
            <li><a class="waves-effect waves-teal" href="Organisateur"><i class="material-icons">group</i> Organisateur</a></li>
            <li><a class="waves-effect waves-teal" href="Utilisateurs"><i class="material-icons">person</i> Utilisateurs</a></li>
            <li><a class="waves-effect waves-teal" href="Statistiques"><i class="material-icons">pie_chart</i> Statistiques</a></li>
            <li><a class="waves-effect waves-teal" href="Signalements"><i class="material-icons">warning</i> Signalements</a></li>
          </ul>
          <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
        </div>
      </header>
      <div class="col m9 l10">
        <div class="row">

        </div>
      </div>
    </div>
  </div>
    <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
    <script src="../js/jquery.min.js" charset="utf-8"></script>
    <script src="../js/materialize.min.js" charset="utf-8"></script>
  </body>
</html>
