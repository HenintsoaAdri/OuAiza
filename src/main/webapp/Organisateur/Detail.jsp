<%@ include file="header.jsp" %>
<% if(request.getParameter("get") == null) response.sendRedirect("index.jsp"); 
	else{ 
	try{
		Organisateur o = TraitementOrganisateur.getOrganisateur(request.getParameter("get"));
 %>
      <div class="row">
      	<h3 class="flow-text"><% out.print(o.getNom()); %></h3>
        <div class="col s12">
          <div class="row">
            <div class="col m8 left">
              <img src="<% out.print(Traitement.getInternUrl()); %>imgAffiche/<% out.print(o.getLogo()); %>" alt="<% out.print(o.getNom()); %>" width="400px">
            </div>
            <p><% out.print(o.getDescription()); %></p>
          </div>
      	  <div class="row right-align valign-wrapper">
		    <div class="col s10 valign">
		    	<% out.print(o.getAdresse()); %><br>
			    <% out.print(o.getRegion().getRegion()); %>
		    </div>
		    <div class="col s2">
		      <img src="../img/<% out.print(o.getRegion().getImageRegion()); %>" class="responsive-img" width="200px"/>
		    </div>
      	  </div>
        </div>
      </div>
      <div class="flow-text valign-wrapper row">
          <div class="col m4">
                  <i class="material-icons medium red-text lighten-2"><% out.print(o.getEtoile().getRate()); %></i>
          </div>
          <div class="col m4">
                  <p class="valign"> <% out.print(o.getEtoile().getMoyenneString()); %></p>
          </div>
      </div>
      <div class="fixed-action-btn horizontal hide-on-small-only">
            <a class="btn-floating btn-large red lighten-2">
              <i class="large material-icons">star_border</i>
            </a>
            <ul class="valign-wrapper flow-text" style="width:450px">
            <% if(p != null){ %>	
             <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
             <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
             <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
             <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
             <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
            <% } else out.print("Vous devez vous connecter pour noter cet organisateur !");%>
            </ul>
      </div>
      <div class="row hide-on-med-and-up valign-wrapper card-panel">
        <div class="col s9">
            <% if(p != null){ %>
              <a class="red-text lighten-2 note"><i class="material-icons medium">star_border</i></a>
              <a class="red-text lighten-2 note"><i class="material-icons medium">star_border</i></a>
              <a class="red-text lighten-2 note"><i class="material-icons medium">star_border</i></a>
              <a class="red-text lighten-2 note"><i class="material-icons medium">star_border</i></a>
              <a class="red-text lighten-2 note"><i class="material-icons medium">star_border</i></a>
            <% } else out.print("Vous devez vous connecter pour noter cet organisateur !");%>
            </div>
            <div class="col s3">
            Noter ce Lieu
            </div>
      </div>
      <div class="row">
        <div class="col s12">
          <ul class="collapsible" data-collapsible="expandable">
            <li>
              <div class="collapsible-header"><i class="material-icons">event</i>&Eacute;v&eacute;nements</div>
              <div class="collapsible-body">
                <div class="row">
                <% if(o.getTop3().isEmpty())out.print("Aucun &eacute;v&eacute;nement pour cet organisateur");
                for(Evenement e : o.getTop3()){ %>
                  <div class="col s12 m4 card">
                   	<div class="card-image">
                     		<img src="<% out.print(Traitement.getInternUrl()); %>imgAffiche/<% out.print(e.getAffiche()); %>" />
                   	</div>
                   	<div class="card-content center-align">
                      <a href="../Evenement/Detail.jsp?get=<% out.print(e.getId()); %>" class="promo-caption"><% out.print(e.getNom()); %></a>
                      <div class="divider"></div>
                      <a href="../Evenement/Detail.jsp?get=<% out.print(e.getId()); %>" class="light center truncate"><% out.print(e.getDescription()); %></a>
                   	</div>
                  </div>
                  <% } %>
                </div>
              </div>
           </li>
          </ul>
          <div class="divider"></div>
          <h4><i class="material-icons">comments</i>Commentaires</h4>
          <div class="row">
            <div class="col s12">
            <%	if(session.getAttribute("Profil") == null){ %>
            		<div class="card-panel red lighten-2">
			        	<a href="../Profil/Login.jsp" class="white-text">Connectez-vous pour pouvoir laisser un commentaire sur <% out.print(o.getNom()); %></a>
			      	</div>
            	<%	}else{ %>
            		<div class="row card-panel">
				      <form class="col s12" id="commentaireForm">
				        <div class="row">
				          <div class="input-field col s12">
          					<i class="material-icons prefix">mode_edit</i>
          					<input id="id" value="<% out.print(o.getId()); %>" type="hidden">
				            <textarea id="commentaire" class="materialize-textarea"></textarea>
				            <label for="commentaire">Un commentaire sur <% out.print(o.getNom()); %> ?</label>
				            <button type="button" id="type" value="organisateur" class="right btn btn-success waves-effect waves-light">Commenter</button>
				          </div>
				        </div>
				  	  </form>
				  	</div>	
            <%	} %>
              <div id="newCommentaire"></div>
            <% for(Commentaire c : o.getCommentaire()){ %>
              <div class="row valign-wrapper">
                <div class="col s2 l1">
                  <img src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(c.getProfil().getPhoto()); %>" alt="" class="circle responsive-img">
                </div>
                <div class="col s10 l11">
                	<a href="../Profil/Compte.jsp?account=<% out.print(c.getProfil().getIdentifiant()); %>">@<% out.print(c.getProfil().getIdentifiant()); %></a>
                  	<span><% out.print(c.getDateHeureString()); %></span>
                  <p class="black-text">
                    <% out.print(c.getCommentaire()); %>
                  </p>
                </div>
              </div>
              <% } %>
            </div>
          </div>
        </div>
      </div>
<% }catch(Exception e){ 
		e.printStackTrace(); %>
		<div class="card-panel red lighten-2">
        	<span class="white-text">Probl&egrave;me! <% out.print(e.getMessage()); %></span>
      	</div>	
<%	}
} %>
<%@ include file="footer.jsp" %>