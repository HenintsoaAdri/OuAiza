<%@ include file="header.jsp" %>
<% if(request.getParameter("get") == null) response.sendRedirect("index.jsp"); 
	else{ 
	try{
		Recommandation r = TraitementRecommandation.getRecommandation(request.getParameter("get"));
 %>
      <div class="row">
      	<h3 class="flow-text"><% out.print(r.getLieu().getNom()); %></h3>
        <div class="col s12">
          <div class="flow-text row">
            <div class="col s12 left">
            	<img class="responsive-img" src="<% out.print(Traitement.getInternUrl()); %>imgRecommandation/<% out.print(r.getImage());%>">
            	<p><% out.print(r.getDescription()); %></p>
            </div>
          </div>
	      <div class="flow-text valign-wrapper row center">
	   		<div class="col m6 col offset-s2">
	   			<p class="valign"> <% out.print(r.getEtoile().getMoyenneString()); %></p>
	   		</div>
	   		<div class="col m5">
	   			<i class="material-icons medium blue-text lighten-2"><% out.print(r.getEtoile().getRate()); %></i>
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
		  	Noter cette Recommandation
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
                  <% out.print(r.getLieu().getPrixEntreeString());%> </p>
                  	<div class="divider"></div>
                      <div class="row">
                   		<p class="flow-text left-align">Menu</p>
                   		<% for(String menu : r.getLieu().getMenu()){ %>
                      	<img class="col s12 m4 materialboxed card" src="<% out.print(Traitement.getInternUrl()); %>imgMenu/<% out.print(menu); %>" width="150px">
                      	<% } %>
                      </div>
              </div>
            </li>
          </ul>
          <a class="btn center" href = "../Lieu/Detail.jsp?get=<% out.print(r.getLieu().getId()); %>">Visiter le lieu en d&eacute;tail</a>
          <div class="divider"></div>
          
          <div class="row">
          	<h4><i class="material-icons">comments</i>Commentaires</h4>
            <div class="col s12">
            <%	if(session.getAttribute("Profil") == null){ %>
            		<div class="card-panel red lighten-2">
			        	<a href="../Profil/Login.jsp" class="white-text">Connectez-vous pour pouvoir laisser un commentaire sur la recommandation de <% out.print(r.getProfil().getIdentifiant()); %> sur <% out.print(r.getLieu().getNom()); %></a>
			      	</div>
            	<%	}else{ %>
            		<div class="row card-panel">
				      <form class="col s12" id="commentaireForm">
				        <div class="row">
				          <div class="input-field col s12">
          					<i class="material-icons prefix">mode_edit</i>
          					<input id="id" value="<% out.print(r.getId()); %>" type="hidden">
          					<input id="type" value="recommandation" type="hidden">
				            <textarea id="commentaire" class="materialize-textarea"></textarea>
				            <label for="commentaire">Un commentaire sur la recommandation de <% out.print(r.getProfil().getIdentifiantString()); %> ?</label>
				            <button type="button" id="type" value="recommandation" class="right btn btn-success waves-effect waves-light">Commenter</button>
				          </div>
				        </div>
				  	  </form>
				  	</div>	
            <%	} %>
              <div id="newCommentaire"></div>
            <%	
            for(Commentaire c : r.getCommentaire()){ %>
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
<% }catch(Exception e){ 
		e.printStackTrace(); %>
		<div class="card-panel red lighten-2">
        	<span class="white-text">Probl&egrave;me! <% out.print(e.getMessage()); %></span>
      	</div>	
<%	}
} %>
<%@ include file="footer.jsp" %>