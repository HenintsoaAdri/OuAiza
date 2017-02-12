<%@ page import="model.Profil" %>
<% if(request.getParameter("new").compareToIgnoreCase("commentaire") == 0){ 
	Profil p = (Profil)session.getAttribute("Profil");
%>
<div class="row valign-wrapper">
  <div class="col s2 l1">
    <img src="../imgProfil/<% out.print(p.getPhoto()); %>" alt="" class="circle responsive-img">
  </div>
  <div class="col s10 l11">
  	<a href="../Profil/Compte.jsp?account=<% out.print(p.getIdentifiant()); %>">@<% out.print(p.getIdentifiant()); %></a>
    <% out.print(request.getParameter("dateHeure")); %>
    <p class="black-text">
      <% out.print(request.getParameter("commentaire")); %>
    </p>
  </div>
</div>
<% } %>