<%@page import="traitement.TraitementProfil"%>
<%@ include file="header.jsp" %>
<% if(session.getAttribute("Profil") == null){
		response.sendRedirect("Login.jsp");
	}
	else{
		Profil p = (Profil)session.getAttribute("Profil");
		TraitementProfil.getRecommandation(p);
%>	
    <div class="row">
      <h3 class="flow-text"><i class="material-icons small">person</i>Mon Profil</h3>
      <div class="card-panel col s12">
        <div class="row">
          <div class="col s4 offset-s4 center">
            <img src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(p.getPhoto()); %>" alt="" class="circle responsive-img" width="200px">
          </div>
          <div class="col s12">
            <h3 class="flow-text center"><% out.print(p.getFullName()); %></h3>
            <p class="center"><% out.print(p.getFullDateNaissanceString());%> <br>
            <% out.print(p.getSexeString()); %> <br> 
            <% out.print(p.getAdresse()); %> <br>
            <img width="20px" alt="<% out.print(p.getRegion().getRegion()); %>" src="../img/<% out.print(p.getRegion().getImageRegion()); %>"><% out.print(p.getRegion().getRegion()); %>
            </p>
            <a class="waves-effect waves-light btn" href="modifyProfil.jsp"><i class="material-icons left">edit</i>Modifier mon profil</a>
          </div>
        </div>
      </div>
      <div class="divider"></div>
      <div class="col s12">
	     <div class="row">
		    <div class="col s12"> 
		       <h4 class="flow-text">Mes Recommandations</h4>
		        <div class="row">
				    <div class="col s12 m6 l4">
		            <div class="card">
		              <div class="card-image">
		                <img src="../img/default.jpg">
		                <a href="../Recommandation/CreateRecommandation.jsp" class="btn-large btn-floating halfway-fab waves-effect waves-light red lighten-2"><i class="material-icons">add</i></a>
		              </div>
		              <div class="card-content">
		                <span class="card-title">Ajouter une recommandation</span>
		              </div>
		            </div>
		          </div>
		        <% for(Recommandation r : p.getRecommandation()){ %>
		          <div class="col s12 m4">
		            <div class="card">
		              <div class="card-image waves-effect waves-block waves-light">
		                <img class="activator" src="<% out.print(Traitement.getInternUrl()); %>imgRecommandation/<% out.print(r.getImage());%>">
		              </div>
		              <div class="card-content">
		                <span class="card-title activator grey-text text-darken-4"><% out.print(r.getLieu().getNom()); %><i class="material-icons right">more_vert</i></span>
		                <p><a href="../Recommandation/Detail.jsp?get=<% out.print(r.getId()); %>" class="truncate"><% out.print(r.getDescription()); %></a></p>
		              </div>
		              <div class="card-reveal">
		                <span class="card-title grey-text text-darken-4"><% out.print(r.getLieu().getNom()); %><i class="material-icons right">close</i></span>
		                <p><% out.print(r.getDescription()); %></p>
		              </div>
		            </div>
		          </div>
		          <% } %>
		       </div>
		     </div>
	       </div>
    	</div>
    </div>
<% } %>
<%@ include file="footer.jsp" %>