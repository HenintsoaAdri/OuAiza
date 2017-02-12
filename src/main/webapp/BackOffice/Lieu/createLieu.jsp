<%@page import="utilitaire.StringUtil"%>
<%@ include file="header.jsp" %>
            <h4>Cr&eacute;er un Lieu</h4>
            <div class="row">
              <form class="col s12" action="#" method="post">
<%
try{
	String nom = "";
	String adresse = "";
        String latitude = "";
        String longitude = "";
	String region = "";
	String description = "";
	String telephone = "";
	String email = "";
	String site = "";
	String prix = "";
		if(request.getParameter("add")!=null){
			nom = request.getParameter("nomLieu");
			adresse = request.getParameter("adresse");
                        latitude = request.getParameter("latitude");
                        longitude = request.getParameter("longitude");
			region = request.getParameter("region");
			description = request.getParameter("description");
			telephone = request.getParameter("telephone");
			email = request.getParameter("email");
			site = request.getParameter("siteweb");
			prix = request.getParameter("prixentree");
		}
    	
%>
                <div class="row">
                  <div class="input-field col s6">
                    <i class="material-icons prefix">location_on</i>
                    <input name="nomLieu" type="text" class="validate" value="<% out.print(nom); %>">
                    <label for="nomLieu">Nom du Lieu</label>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Logo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">home</i>
                    <input name="adresse" type="tel" class="validate" value="<% out.print(adresse); %>">
                    <label for="adresse">Adresse</label>
                  </div>
                  <div class="input-field col s6">
				    <select class="icons" name="region">
				      <option disabled selected>Choisissez une r&eacute;gion</option>
				      <% for(model.Region r : TraitementLieu.getRegion()) { %>
				      <option value="<% out.print(r.getId()); %>" data-icon="../../img/<% out.print(r.getImageRegion()); %>"><% out.print(r.getRegion()); %></option>
				      <% } %>
				    </select>
				    <label>R&eacute;gion</label>
				  </div>
                  <h5>Horaire</h5>
                  <div class="row">
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_on</i>
                      <input name="lundiHO" type="number" class="validate" min="00" max="23">
                      <label for="lundiHO">Lundi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="lundiMO" type="number" class="validate" min="00" max="59">
                      <label for="lundiMO">Lundi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_off</i>
                      <input name="lundiHF" type="number" class="validate" min="00" max="23">
                      <label for="lundiHF">Lundi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="lundiMF" type="number" class="validate" min="00" max="59">
                      <label for="lundiMF">Lundi</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_on</i>
                      <input name="mardiHO" type="number" class="validate" min="00" max="23">
                      <label for="mardiHO">Mardi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="mardiMO" type="number" class="validate" min="00" max="59">
                      <label for="mardiMO">Mardi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_off</i>
                      <input name="mardiHF" type="number" class="validate" min="00" max="23">
                      <label for="mardiHF">Mardi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="mardiMF" type="number" class="validate" min="00" max="59">
                      <label for="mardiMF">Mardi</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_on</i>
                      <input name="mercrediHO" type="number" class="validate" min="00" max="23">
                      <label for="mercrediHO">Mercredi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="mercrediMO" type="number" class="validate" min="00" max="59">
                      <label for="mercrediMO">Mercredi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_off</i>
                      <input name="mercrediHF" type="number" class="validate" min="00" max="23">
                      <label for="mercrediHF">Mercredi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="mercrediMF" type="number" class="validate" min="00" max="59">
                      <label for="mercrediMF">Mercredi</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_on</i>
                      <input name="jeudiHO" type="number" class="validate" min="00" max="23">
                      <label for="jeudiHO">Jeudi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="jeudiMO" type="number" class="validate" min="00" max="59">
                      <label for="jeudiMO">Jeudi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_off</i>
                      <input name="jeudiHF" type="number" class="validate" min="00" max="23">
                      <label for="jeudiHF">Jeudi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="jeudiMF" type="number" class="validate" min="00" max="59">
                      <label for="jeudiMF">Jeudi</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_on</i>
                      <input name="vendrediHO" type="number" class="validate" min="00" max="23">
                      <label for="vendrediHO">Vendredi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="vendrediMO" type="number" class="validate" min="00" max="59">
                      <label for="vendrediMO">Vendredi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_off</i>
                      <input name="vendrediHF" type="number" class="validate" min="00" max="23">
                      <label for="vendrediHF">Vendredi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="vendrediMF" type="number" class="validate" min="00" max="59">
                      <label for="vendrediMF">Vendredi</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_on</i>
                      <input name="samediHO" type="number" class="validate" min="00" max="23">
                      <label for="samediHO">Samedi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="samediMO" type="number" class="validate" min="00" max="59">
                      <label for="samediMO">Samedi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_off</i>
                      <input name="samediHF" type="number" class="validate" min="00" max="23">
                      <label for="samediHF">Samedi</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="samediMF" type="number" class="validate" min="00" max="59">
                      <label for="samediMF">Samedi</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_on</i>
                      <input name="dimancheHO" type="number" class="validate" min="00" max="23">
                      <label for="dimancheHO">Dimanche</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="dimancheMO" type="number" class="validate" min="00" max="59">
                      <label for="dimancheMO">Dimanche</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">alarm_off</i>
                      <input name="dimancheHF" type="number" class="validate" min="00" max="23">
                      <label for="dimancheHF">Dimanche</label>
                    </div>
                    <div class="input-field col s2">
                      <i class="material-icons prefix">:</i>
                      <input name="dimancheMF" type="number" class="validate" min="00" max="59">
                      <label for="dimancheMF">Dimanche</label>
                    </div>
                  </div>

                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Photo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Photo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Photo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Photo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Photo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="input-field col s12">
                    <i class="material-icons prefix">edit</i>
                    <textarea name="description" class="materialize-textarea"><% out.print(description); %></textarea>
                    <label for="description">Description</label>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">phone</i>
                    <input name="telephone" type="text" class="validate"  value="<% out.print(site); %>">
                    <label for="telephone">T&eacute;l&eacute;phone</label>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">mail</i>
                    <input name="email" type="email" class="validate" value="<% out.print(email); %>">
                    <label for="email">Email</label>
                  </div>
                  <div class="input-field col s12">
                    <i class="material-icons prefix">http</i>
                    <input name="siteweb" type="text" class="validate">
                    <label for="siteweb">Site Web</label>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">monetization_on</i>
                    <input name="prixentree" type="number" class="validate">
                    <label for="prixentree">Prix d'entr&eacute;e</label>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Menu</span>
                      <input type="file" multiple>
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text" placeholder="T&eacute;l&eacute;chargez une ou plusieurs photo">
                    </div>
                  </div>
                  <div class="input-field col s12">
                    <button class="btn waves-effect waves-teal" type="submit" name="add">Cr&eacute;er
                      <i class="material-icons right">send</i>
                    </button>
                  </div>
                </div>
     <%
     	if(request.getParameter("add")!=null){
	    	Horaire h = TraitementLieu.createHoraire(request);
		TraitementLieu.insertLieu(region, nom, adresse, latitude, longitude, description, prix, telephone, site, email,h);
	}
     }
		catch(Exception e){ %>
		<div class="alert alert-warning">
		  <strong>Probl&egrave;me!</strong> <% out.print(e.getMessage()); e.printStackTrace();%>
		</div>
	<% } %>
              </form>
            </div>
<%@ include file="footer.jsp" %>
