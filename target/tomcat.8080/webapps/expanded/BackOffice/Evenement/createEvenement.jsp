<%@page import="utilitaire.StringUtil,dao.*,java.util.Vector,traitement.*,java.time.*,model.*"%>
<%@ include file="header.jsp" %>
            <h4>Cr&eacute;er un &Eacute;v&eacute;nement</h4>
            <div class="row">
              <form class="col s12" action="#" method="post">
<%
try{
	Vector<Lieu> ltlieu = TraitementLieu.getListeLieu(0);
	Vector<Organisateur> ltorganisateur = TraitementOrganisateur.getListeOrganisateur(0);
	
	String idLieu = "";
	String idOrganisateur = "";
	String nom = "";
	String dateEvenement = "";
	String dateFinEvenement = "";
	LocalTime heureEvenement = LocalTime.now();
	LocalTime heureFinEvenement = LocalTime.now().plusHours(1);
	String description = "";
	String prixEntree = "";
	String condition = "";
	String autreInfo = "";
	String affiche = "";
	Lieu lieu = new Lieu();
	Organisateur organisateur = new Organisateur();
	if(request.getParameter("add")!=null){
		idLieu = request.getParameter("idLieu");
		idOrganisateur = request.getParameter("idOrganisateur");
		nom = request.getParameter("nom");
		dateEvenement = request.getParameter("dateEvenement");
		dateFinEvenement = request.getParameter("dateFinEvenement");
		heureEvenement = StringUtil.stringToTime(request.getParameter("heureEvenementH"),request.getParameter("heureEvenementM"));
		heureFinEvenement = StringUtil.stringToTime(request.getParameter("heureFinEvenementH"),request.getParameter("heureFinEvenementM"));
		prixEntree = request.getParameter("prixEntree");
		condition = request.getParameter("condition");
		autreInfo = request.getParameter("autreInfo");
		affiche = request.getParameter("affiche");
		lieu = LieuDAO.getLieuById(Integer.parseInt(idLieu));
		organisateur = OrganisateurDAO.getOrganisateurById(Integer.parseInt(idOrganisateur));
	}

    	
%>
                <div class="row">
                  <div class="input-field col s6">
                    <i class="material-icons prefix">location_on</i>
                    <input name="nom" type="text" class="validate" value="<% out.print(nom); %>">
                    <label for="nom">Nom de l'e&eacute;v&eacute;nement</label>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Affiche</span>
                      <input type="file" name="affiche">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="input-field col s6">
				    <select class="icons" name="lieu">
				      <option disabled selected>Choisissez un lieu</option>
				      <% for(Lieu r : ltlieu) { %>
				      <option value="<% out.print(r.getId()); %>" data-icon="../../img/<% out.print(r.getLogo()); %>"><% out.print(r.getNom()); %></option>
				      <% } %>
				    </select>
				    <label>Lieu</label>
				  </div>
                  <div class="input-field col s6">
				    <select class="icons" name="organisateur">
				      <option disabled selected>Choisissez un organisateur</option>
				      <% for(Organisateur r : ltorganisateur) { %>
				      <option value="<% out.print(r.getId()); %>" data-icon="../../img/<% out.print(r.getLogo()); %>"><% out.print(r.getNom()); %></option>
				      <% } %>
				    </select>
				    <label>Organisateur</label>
				  </div>
                  <h5>Calendrier</h5>
                  <div class="row">
                  	  <div class="input-field col s6">
	                  	  <div class="row">
			           		<div class="input-field col s6">
			                  <i class="material-icons prefix">date_range</i>
			      			  <input type="date" name="dateEvenement" id="dateEvenement" min="0" class="datepicker" value="<% out.print(dateEvenement); %>"/>
			              	  <label for="dateEvenement">Date de d&eacute;but</label>
			            	</div>
			           		<div class="input-field col s6">
			      			  <input type="date" name="dateFinEvenement" id="dateFinEvenement" min="10" class="datepicker" value="<% out.print(dateFinEvenement); %>"/>
			              	  <label for="dateFinEvenement">Date de fin</label>
			            	</div>
			              </div>
		              </div>
		            <div class="input-field col s6">
		            	<div class="row">
							<div class="input-field col s3">
		                      <i class="material-icons prefix">alarm_on</i>
		                      <input name="heureEvenementH" type="number" class="validate" min="00" max="23">
		                      <label for="heureEvenementH">D&eacute;but</label>
		                    </div>
		                    <div class="input-field col s3">
		                      <i class="material-icons prefix">:</i>
		                      <input name="heureEvenementM" type="number" class="validate" min="00" max="59">
		                      <label for="heureEvenementM">D&eacute;but</label>
		                    </div>
		                    
		                    <div class="input-field col s3">
		                      <i class="material-icons prefix">alarm_off</i>
		                      <input name="heureFinEvenementH" type="number" class="validate" min="00" max="23">
		                      <label for="heureFinEvenementH">Fin</label>
		                    </div>
		                    <div class="input-field col s3">
		                      <i class="material-icons prefix">:</i>
		                      <input name="heureFinEvenementM" type="number" class="validate" min="00" max="59">
		                      <label for="heureFinEvenementM">Fin</label>
		                    </div>
	                    </div>
                  	</div>
                  </div>

                  <div class="input-field col s12">
                    <i class="material-icons prefix">edit</i>
                    <textarea name="description" class="materialize-textarea"><% out.print(description); %></textarea>
                    <label for="description">Description</label>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">edit</i>
                    <textarea name="condition" class="validate"><% out.print(condition); %></textarea>
                    <label for="condition">Condition</label>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">edit</i>
                    <textarea name="condition" class="validate"><% out.print(autreInfo); %></textarea>
                    <label for="condition">Autres informations</label>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">monetization_on</i>
                    <input name="prixEntree" type="number" class="validate">
                    <label for="prixEntree">Prix d'entr&eacute;e</label>
                  </div>
                  <div class="input-field col s12">
                    <button class="btn waves-effect waves-teal" type="submit" name="add">Cr&eacute;er
                      <i class="material-icons right">send</i>
                    </button>
                  </div>
                </div>
     <%
     	if(request.getParameter("add")!=null){
			TraitementEvenement.insertEvenement(lieu, organisateur, nom, dateEvenement, dateFinEvenement, description, prixEntree, condition, autreInfo, affiche);
     	} 
		}catch(Exception e){ %>
		<div class="alert alert-warning">
		  <strong>Probl&egrave;me!</strong> <% out.print(e.getMessage()); e.printStackTrace();%>
		</div>
		<% } %>
              </form>
            </div>
<%@ include file="footer.jsp" %>
