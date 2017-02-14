<%@ include file="header.jsp" %>
<% if(request.getParameter("get") == null) response.sendRedirect("index.jsp"); 
	else{ 
	try{
		Lieu l = TraitementLieu.getLieu(request.getParameter("get"));
 %>
      <div class="row">
      	<h3 class="flow-text"><% out.print(l.getNom()); %></h3>
        <div class="col s12">
	      <div class="valign-wrapper row center">
	   		<div class="col m6 col offset-s2 flow-text">
	   			<p class="valign"> <% out.print(l.getEtoile().getMoyenneString()); %></p>
	   		</div>
	   		<div class="col m5">
	   			<i class="material-icons medium blue-text lighten-2"><% out.print(l.getEtoile().getRate()); %></i>
	   		</div>
	      </div>
          <div class="row">
            <div class="col s12 m8 left">
              <div class="carousel" data-indicators="true">
                <h4 class="center">Galerie</h4>
                <% for(String s : l.getGalerie()){ %>
                <a class="carousel-item" href="#one!"><img src="<% out.print(Traitement.getInternUrl()); %>imgLieu/<% out.print(s);%>"></a>
                <% } %>
              </div>
            </div>
            <p><% out.print(l.getDescription()); %></p>
          </div>
      	  <div class="fixed-action-btn horizontal hide-on-small-only">
                <a class="btn-floating btn-large red lighten-2">
                  <i class="large material-icons">star_border</i>
                </a>
                <a href="../Recommandation/CreateRecommandation.jsp?with=<% out.print(l.getId()); %>" class="btn-floating btn-large orange lighten-2">
                  <i class="large material-icons">share</i>
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
                Noter ce Lieu
                </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <ul class="collapsible" data-collapsible="expandable">
			<li>
              <div class="collapsible-header"><i class="material-icons">restaurant_menu</i>Tarifs</div>
              <div class="collapsible-body">
                  <p class="flow-text center">
                  <% out.print(l.getPrixEntreeString());%> </p>
                  	<div class="divider"></div>
                      <div class="row">
                   		<p class="flow-text left-align">Menu</p>
                   <% for(String menu : l.getMenu()){ %>
                      	<img class="col s12 m4 materialboxed card" src="<% out.print(Traitement.getInternUrl()); %>imgMenu/<% out.print(menu); %>" width="150px">
                    <% } %>
                      </div>
              </div>
            </li>
            <li>
              <div class="collapsible-header"><i class="material-icons">event</i>&Eacute;v&eacute;nements</div>
              <div class="collapsible-body">
                <div class="row">
                <% if(l.getTop3().isEmpty())out.print("Aucun &eacute;v&eacute;nement pour ce lieu");
                for(Evenement e : l.getTop3()){ %>
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
            <li>
              <div class="collapsible-header"><i class="material-icons">access_time</i>Horaire</div>
              <div class="collapsible-body">
                <table class="table responsive-table highlight centered">
                  <thead>
                 	<tr>
                 	  <th></th>
                 	  <th>Lundi</th>
                 	  <th>Mardi</th>
                 	  <th>Mercredi</th>
                 	  <th>Jeudi</th>
                 	  <th>Vendredi</th>
                 	  <th>Samedi</th>
                 	  <th>Dimanche</th>
                 	</tr>
                  </thead>
                  <tbody>
                  	<tr>
                 	  <td>Ouverture</td>
                 	  <td ><% out.print(l.getHoraire().getLundi().getOuverture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getMardi().getOuverture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getMercredi().getOuverture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getJeudi().getOuverture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getVendredi().getOuverture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getSamedi().getOuverture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getDimanche().getOuverture()); %></td>
                 	</tr>
                  	<tr>
                 	  <td>Fermeture</td>
                 	  <td ><% out.print(l.getHoraire().getLundi().getFermeture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getMardi().getFermeture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getMercredi().getFermeture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getJeudi().getFermeture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getVendredi().getFermeture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getSamedi().getFermeture()); %></td>
                 	  <td ><% out.print(l.getHoraire().getDimanche().getFermeture()); %></td>
                 	</tr>
                  </tbody>
                </table>
              </div>
            </li>
          </ul>
          <div class="divider"></div>
          
          <div class="row">
          	<h4><i class="material-icons">comments</i>Commentaires</h4>
            <div class="col s12">
            <%	if(session.getAttribute("Profil") == null){ %>
            		<div class="card-panel red lighten-2">
			        	<a href="../Profil/Login.jsp" class="white-text">Connectez-vous pour pouvoir laisser un commentaire sur <% out.print(l.getNom()); %></a>
			      	</div>
            	<%	}else{ %>
            		<div class="row card-panel">
				      <form class="col s12" id="commentaireForm">
				        <div class="row">
				          <div class="input-field col s12">
          					<i class="material-icons prefix">mode_edit</i>
          					<input id="id" value="<% out.print(l.getId()); %>" type="hidden">
				            <textarea id="commentaire" class="materialize-textarea" required></textarea>
				            <label for="commentaire">Un commentaire sur <% out.print(l.getNom()); %> ?</label>
				            <button type="button" id="type" value="lieu" class="right btn btn-success waves-effect waves-light">Commenter</button>
				          </div>
				        </div>
				  	  </form>
				  	</div>	
            <%	} %>
              <div id="newCommentaire"></div>
            <%	
            for(Commentaire c : l.getCommentaire()){ %>
              <div class="row valign-wrapper">
                <div class="col s2 l1">
                  <img src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(c.getProfil().getPhoto()); %>" alt="" class="circle responsive-img">
                </div>
                <div class="col s10 l11">
                	<a href="../Profil/Compte.jsp?account=<% out.print(c.getProfil().getIdentifiant()); %>"><% out.print(c.getProfil().getIdentifiantString()); %></a>
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

  <div id="addRecommandation" class="modal">
    <div class="modal-content">
      <h4>Ajouter une recommandation</h4>
		<form class="col s12" action="#" method="post">
	      <div class="row">
	        <div class="input-field col s12">
	          <textarea name="description" class="materialize-textarea"></textarea>
	          <label for="description">Vos impressions ?</label>
	        </div>
	      </div>
	      <div class="file-field input-field">
		      <div class="btn">
		        <span>Photo</span>
		        <input type="file" name="photoRecommandation">
		      </div>
		      <div class="file-path-wrapper">
		        <input class="file-path validate" type="text">
		      </div>
		  </div>
	    </form>
    </div>
    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Recommander</a>
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
