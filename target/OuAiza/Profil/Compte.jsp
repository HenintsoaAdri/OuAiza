<%@page import="traitement.TraitementProfil"%>
<%@ include file="header.jsp" %>
<% if(request.getParameter("account")!=null){ 
	Profil account = TraitementProfil.getProfil(request.getParameter("account"));
	TraitementProfil.getRecommandation(account);
%>	
    <div class="row">
      <h3 class="flow-text"><i class="material-icons small">person</i>Profil</h3>
      <div class="col s12">
        <div class="row card-panel">
          <div class="col s4 offset-s4 center">
            <img src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(account.getPhoto()); %>" alt="" class="circle responsive-img">
          </div>
          <div class="col s12">
            <h3 class="flow-text center"><% out.print(account.getFullName()); %></h3>
            <p class="center"><% out.print(account.getFullDateNaissanceString());%> <br>
            <% out.print(account.getSexeString()); %> <br> 
            <% out.print(account.getAdresse()); %> <br>
            <img width="20px" alt="<% out.print(account.getRegion().getRegion()); %>" src="../img/<% out.print(account.getRegion().getImageRegion()); %>"><% out.print(account.getRegion().getRegion()); %>
            </p>
          </div>
        </div>
      </div>
      <div class="divider"></div>
      <div class="col s12">
	     <div class="row">
		    <div class="col s12"> 
		       <h4 class="flow-text">Recommandations</h4>
		        <div class="row">
		        <% if(account.getRecommandation().isEmpty())out.print("Aucune recommandation disponible de ce profil");
		        for(Recommandation r : account.getRecommandation()){ %>
		          <div class="col s12 m6 l4">
		            <div class="card">
		            <a class="btn-large btn-floating halfway-fab waves-effect waves-light red lighten-2"><i class="material-icons">star</i></a>
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