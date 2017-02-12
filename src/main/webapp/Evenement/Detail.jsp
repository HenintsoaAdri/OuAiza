<%@ include file="header.jsp" %>
<% if(request.getParameter("get") == null) response.sendRedirect("index.jsp"); 
	else{ 
	try{
		Evenement e = TraitementEvenement.getEvenement(request.getParameter("get"));
 %>
      <div class="row">
      	<h3 class="flow-text"><% out.print(e.getNom()); %></h3>
        <div class="col s12">
          <div class="row">
            <div class="col m8 left">
              <img class="materialboxed" src="<% out.print(Traitement.getInternUrl()+"imgAffiche/"+e.getAffiche()); %>" width="400px">
            </div>
            <p><% out.print(e.getDescription()); %></p>
          </div>
        </div>
      </div>
      <div class="flow-text valign-wrapper row center">
   		<div class="col m5">
   			<i class="material-icons medium blue-text lighten-2"><% out.print(e.getEtoile().getRate()); %></i>
   		</div>
   		<div class="col m6 col offset-s2">
   			<p class="valign"> <% out.print(e.getEtoile().getMoyenneString()); %></p>
   		</div>
      </div>
      <div class="row">
      	<div class="flow-text row">
      	  <div class="col s12">
      	  	<div class="row right-align valign-wrapper">
		      	<div class="col s10 valign">
			      	par <a href="../Organisateur/Detail.jsp?get=<% out.print(e.getOrganisateur().getId()); %>"> <% out.print(e.getOrganisateur().getNom()); %> <% out.print(e.getOrganisateur().getAdresse()); %></a><br>
		      	</div>
		      	<div class="col s2">
		      		<img src="<% out.print(Traitement.getInternUrl()+"imgAffiche/"+e.getOrganisateur().getLogo()); %>" class="responsive-img" width="200px"/>
		      	</div>
      	  	</div>
      	  	<div class="row valign-wrapper">
		      	<div class="col s3 l2 valign">
		      		<i class="material-icons large orange-text">event</i>
		      	</div>
		      	<div class="col s9 l10">
			      	Rendez vous le <b><% out.print(e.getDebutString()); %></b> <br>
			      	jusqu'au <i><% out.print(e.getFinString()); %></i>
		      	</div>
      	  	</div>
      	  	<div class="row right-align valign-wrapper">
		      	<div class="col s10 valign">
			      	<a href="../Lieu/Detail.jsp?get=<% out.print(e.getLieu().getId()); %>"> <% out.print(e.getLieu().getNom()); %> <% out.print(e.getLieu().getAdresse()); %></a><br>
			      	<% out.print(e.getLieu().getRegion().getRegion()); %>
		      	</div>
		      	<div class="col s2">
		      		<img src="../img/<% out.print(e.getLieu().getRegion().getImageRegion()); %>" class="responsive-img" width="200px"/>
		      	</div>
      	  	</div>
      		<div class="fixed-action-btn horizontal hide-on-small-only">
                        <a class="btn-floating btn-large red lighten-2">
                          <i class="large material-icons">star_border</i>
                        </a>
                  <ul class="valign-wrapper" style="width:450px">
                <% if(p != null){ %>	
                        <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
                        <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
                        <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
                        <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
                        <li class="note"><a class="red-text lighten-2 valign"><i class="material-icons medium">star_border</i></a></li>
                <% } else out.print("Vous devez vous connecter pour noter cet &eacute;v&eacute;nement !");%>
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
                <% } else out.print("Vous devez vous connecter pour noter cet &eacute;v&eacute;nement !");%>
                  </div>
                  <div class="col s3">
                        Noter cet &Eacute;v&eacute;nement
                  </div>
                </div>
      	  </div>
      	</div>
        <div class="col s12">
          <ul class="collapsible" data-collapsible="expandable">
            <li>
              <div class="collapsible-header"><i class="material-icons">restaurant_menu</i>Tarifs</div>
              <div class="collapsible-body">
                  <p class="flow-text center">
                  <% out.print(e.getPrixEntreeString()); %> <br>
                  Conditions : <% out.print(e.getConditionString()); %></p>
                  <div class="divider"></div>
                  <!-- <div class="row">
	                  <p class="flow-text left-align">Menu </p>
	                  <img class="col s12 m4 materialboxed card" src="../img/background.jpg" width="150px">
	                  <img class="col s12 m4 materialboxed card" src="../img/background.jpg" width="150px">
	                  <img class="col s12 m4 materialboxed card" src="../img/background.jpg" width="150px">
	                  <img class="col s12 m4 materialboxed card" src="../img/background.jpg" width="150px">
	                  <img class="col s12 m4 materialboxed card" src="../img/background.jpg" width="150px">
                  </div> -->
              </div>
            </li>
          </ul>
          <div class="divider"></div>
          <h4><i class="material-icons">comments</i>Commentaires</h4>
          <div class="col s12">
            <%	if(session.getAttribute("Profil") == null){ %>
            		<div class="card-panel red lighten-2">
			        	<a href="../Profil/Login.jsp" class="white-text">Connectez-vous pour pouvoir laisser un commentaire sur "<% out.print(e.getNom()); %>" ...</a>
			      	</div>
            	<%	}else{ %>
            		<div class="row">
				      <form class="col s12" id="commentaireForm">
				        <div class="row">
				          <div class="input-field col s12">
          					<i class="material-icons prefix">mode_edit</i>
          					<input id="id" value="<% out.print(e.getId()); %>" type="hidden">
				            <textarea id="commentaire" class="materialize-textarea" required></textarea>
				            <label for="commentaire">Un commentaire sur <% out.print(e.getNom()); %> ?</label>
				            <button type="button" id="type" value="evenement" class="right btn btn-success waves-effect waves-light">Commenter</button>
				          </div>
				        </div>
				  	  </form>
				  	</div>	
            <%	} %>
            <div id="newCommentaire"></div>
          <%	for(Commentaire c : e.getCommentaire()){ %>
              <div class="row valign-wrapper">
                <div class="col s2 l1">
                  <img src="<% out.print(Traitement.getInternUrl()+"imgProfil/"+c.getProfil().getPhoto()); %>" alt="" class="circle responsive-img">
                </div>
                <div class="col s10 l11">
                	<a href="../Profil/Compte.jsp?account=<% out.print(c.getProfil().getIdentifiant()); %>">@<% out.print(c.getProfil().getIdentifiant()); %></a>
                  	<p><% out.print(c.getDateHeureString()); %></p>
                  <p class="black-text">
                    <% out.print(c.getCommentaire()); %>
                  </p>
                </div>
              </div>
              <% } %>
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
