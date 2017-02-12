<%@ include file="header.jsp" %>
<%
	String id = request.getParameter("with");
	if(id == null)response.sendRedirect("../Lieu/Recherche.jsp");
	else{ 
	try{
		Lieu l = TraitementLieu.getLieu(request.getParameter("with"));
 %>
      <div class="row">
      	<h3 class="flow-text"><i class="material-icons right">share</i>Ajouter une recommandation sur <% out.print(l.getNom()); %></h3>
        <div class="col s12">
          <div class="row card-panel">
            <div class="col s7">
      	<a href="../Lieu/Detail.jsp?get=<% out.print(l.getId()); %>" class="btn floating orange lighten-2"><i class="material-icons">chevron_left</i></a>
            	<%	if(session.getAttribute("Profil") == null){ %>
            		<div class="card-panel orange lighten-2">
			        	<a href="../Profil/Login.jsp" class="white-text">Connectez-vous pour pouvoir pouvoir poster une recommandation sur <% out.print(l.getNom()); %></a>
			      	</div>
            	<%	}else{ %>
	            <form class="col s12" enctype="multipart/form-data" action="<% out.print(Traitement.getInternUrl()); %>RecommandationServlet" method="post">
			      <div class="row">
				    <div class="input-field">
				      <textarea id="description" name="description" class="materialize-textarea"></textarea>
				      <label for="description">Vos impressions ?</label>
				    </div>
			      </div>
			      <div class="row">
			        <div class="file-field input-field">
				      <div class="btn">
				        <span>Photo</span>
				        <input type="file" name="imageRecommandation">
				      </div>
				      <div class="file-path-wrapper">
				        <input class="file-path validate" type="text">
				      </div>
				    </div>
				  </div>
				  <input type="hidden" name="id" value="<% out.print(l.getId()); %>">
				  <input type="hidden" name="nomFichier" value="reco<%out.print(LocalDate.now()+l.getNom()+LocalTime.now().toNanoOfDay()); %>">
			      <button type="submit" name="path" value="recommandation" class="right waves-effect waves-default btn-flat">Recommander</button>
				</form>
				<% } %>
            </div>
	      	<div class="col s5">
              <img class="responsive-img" src="<% out.print(Traitement.getInternUrl()); %>imgLieu/<% out.print(l.getGalerie().get(0));%>">
           	  <p><% out.print(l.getDescription()); %></p>
   			  <p class="right-align"><i class="material-icons small blue-text lighten-2 right-align"><% out.print(l.getEtoile().getRate()); %></i></p>
   			  <p class="right-align"> <% out.print(l.getEtoile().getMoyenneString()); %></p>
   			  <ul class="collection">
   			  	<li class="collection-item avatar">
	      			<i class="material-icons circle red lighten-2">assignment</i> 
		  			<p><% out.print(l.getAdresse()); %>, <% out.print(l.getRegion().getRegion()); %></p>
		  			<p><% out.print(l.getContact()); %></p>
		  			<p><% out.print(l.getMail()); %></p>
	  			</li>
   			  </ul>
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
