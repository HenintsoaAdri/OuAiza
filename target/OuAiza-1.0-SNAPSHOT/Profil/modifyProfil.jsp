<%@ include file="header.jsp" %>
<% if(session.getAttribute("Profil")==null)response.sendRedirect("Login.jsp");
	else{
		Profil p = (Profil)session.getAttribute("Profil"); %>
      <h3 class="flow-text"><i class="material-icons small">person</i>Modifier mon Profil</h3>
      <div class="card-panel row">
      	<a href="../Profil/" class="btn floating"><i class="material-icons">chevron_left</i></a>
<%		if(request.getParameter("modifier")!=null){
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			String email = request.getParameter("email");
			String sexe = request.getParameter("sexe");
			String dateNaissance = request.getParameter("dateNaissance");
			String region = request.getParameter("region");
			String identifiant = request.getParameter("identifiant");
			try{
				TraitementProfil.modifier(p, nom, prenom, identifiant, adresse, email, sexe, dateNaissance, region);
			}catch(Exception e){ %>
           		<div class="card-panel red lighten-2">
  		          <span class="white-text">Probl&egrave;me! <% out.print(e.getMessage()); %></span>
  		        </div>
<%			}
		}
%>
        <div class="col s12 center-align">
          <img src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(p.getPhoto()); %>" alt="" class="circle responsive-img" width="250px">
          <a class="btn-floating btn-large waves-effect waves-light red lighten-2" href="#modifierPhoto"><i class="material-icons">add_a_photo</i></a>
        </div>
        <div class="col s12">
          <div class="row">
              <form class="col s12" method="post">
                <div class="row">
                  <div class="input-field col s6">
                  	<i class="material-icons small prefix">account_circle</i>
                    <input name="nom" type="text" class="validate" value="<% out.print(p.getNom()); %>">
                    <label for="nom">Nom</label>
                  </div>
                  <div class="input-field col s6">
                    <input name="prenom" type="text" class="validate" value="<% out.print(p.getPrenom()); %>">
                    <label for="prenom">Pr&eacute;nom</label>
                  </div>
                </div>
                <div class="row">
                  <div class="input-field col s6">
                  	<i class="material-icons small prefix">mail_outline</i>
                    <input name="email" type="email" class="validate" value="<% out.print(p.getEmail()); %>">
                    <label for="email">Email</label>
                  </div>
                  <div class="input-field col s6">
                  	<i class="material-icons small prefix">fingerprint</i>
                    <input name="identifiant" type="text" class="validate" value="<% out.print(p.getIdentifiant()); %>">
                    <label for="identifiant">Identifiant</label>
                  </div>
                </div>
                <div class="row">
                  <div class="input-field col s6">
                  	<i class="material-icons small prefix">home</i>
                    <input name="adresse" type="text" class="validate" value="<% out.print(p.getAdresse()); %>">
                    <label for="adresse">Adresse</label>
                  </div>
                  <div class="input-field col s6">
			        <select class="icons" name="region"  required>
			          <option disabled selected data-icon="../img/<% out.print(p.getRegion().getImageRegion()); %>"><% out.print(p.getRegion().getRegion()); %></option>
			        <% for(model.Region r : TraitementLieu.getRegion()) { %>
			          <option value="<% out.print(r.getId()); %>" data-icon="../img/<% out.print(r.getImageRegion()); %>"><% out.print(r.getRegion()); %></option>
			        <% } %>
			        </select>
			    	<label>R&eacute;gion</label>
			      </div>
                </div>
                <div class="row">
                  <div class="input-field col s6">
                  	<i class="material-icons small prefix">event</i>
                    <label for="dateNaissance">Date de naissance</label>
                    <input name="dateNaissance" type="date" class="datepicker" value="<% out.print(p.getDateNaissance()); %>">
                  </div>
                  <div class="input-field col s6">
                  	<i class="material-icons small prefix">wc</i>
                    <input class="with-gap" name="sexe" type="radio" id="homme" name="homme" <% if(p.isHomme()) out.print("checked"); %> />
                  	<label for="homme">Homme</label>
                  	<input class="with-gap" name="sexe" type="radio" id="femme" name="femme" <% if(p.isFemme()) out.print("checked"); %> />
                  	<label for="femme">Femme</label>
                  </div>
                </div>
                <div class="row right-align">
                  <div class="input-field col s12">
                    <button class="waves-effect waves-light btn" name="modifier" type="submit"><i class="material-icons left">edit</i>Modifier</button>
                  </div>
                </div>
              </form>
            </div>
        </div>
  <div id="modifierPhoto" class="modal">
	<form action="/ProjetOuAiza/fileUpload" enctype="multipart/form-data" method="post">
    <div class="modal-content">
      <h4>Ajouter une Photo de profil</h4>
		    <div class="file-field input-field">
		      <div class="btn">
		        <span>Photo</span>
		        <input type="file" name="photo" id="photo">
		      </div>
		        <input type="hidden" name="nomFichier" value="<% out.print(p.getIdentifiant()+"-profil"); %>">
		      <div class="file-path-wrapper">
		        <input class="file-path validate" type="text">
		      </div>
		    </div>
    </div>
    <div class="modal-footer">
      <button type="submit" name="path" value="imgProfil" class=" modal-action modal-close waves-effect waves-green btn-flat">Ajouter</button>
    </div>
	</form>
  </div>
<% } %>
<%@ include file="footer.jsp" %>
