<%@ include file="header.jsp" %>
      <h5 class="flow-text right-center"><i class="material-icons small right">search</i>Rechercher un &eacute;v&eacute;nement</h5>
      <div class="row card-panel">
    <% int offset = 0; 
    if(request.getParameter("page")!=null) offset = Integer.valueOf(request.getParameter("page"));
       String nom = "";
       String lieu = "";
       String organisateur = "";
       String prixMin = "";
       String prixMax = "";
       String dateMin = "";
       String dateMax = "";
       Vector<Evenement> ltevenement = TraitementEvenement.getListeEvenement(offset*10);
       if(request.getParameter("search") != null){
    	   nom = request.getParameter("nom");
    	   lieu = request.getParameter("lieu");
    	   organisateur = request.getParameter("organisateur");
    	   prixMin = request.getParameter("prixMin");
    	   prixMax = request.getParameter("prixMax");
    	   dateMin = request.getParameter("dateMin");
    	   dateMax = request.getParameter("dateMax");
       }
    %>
      	<div class="col s12">
          <form method="get">
            <div class="row">
              <div class="input-field col s4">
                <i class="material-icons prefix">label</i>
                <input name="nom" type="text" class="validate" value="<% out.print(nom); %>">
                <label for="nom">Nom de l'&eacute;v&eacute;nement</label>
              </div>
              <div class="input-field col s4">
                <i class="material-icons prefix">place</i>
                <input name="lieu" type="text" class="validate" value="<% out.print(lieu); %>">
                <label for="lieu">Nom de lieu</label>
              </div>
              <div class="input-field col s4">
                <i class="material-icons prefix">group</i>
                <input name="organisateur" type="text" class="validate" value="<% out.print(organisateur); %>">
                <label for="organisateur">Nom de l'organisateur</label>
              </div>

            </div>
            <div class="row">
			  <div class="col s6">
	              <div class="row">
	           		<div class="input-field col s6">
	                  <i class="material-icons prefix">date_range</i>
	      			  <input type="date" name="dateMin" id="dateMin" min="0" class="datepicker" value="<% out.print(dateMin); %>"/>
	              	  <label for="dateMin">Date de d&eacute;but</label>
	            	</div>
	           		<div class="input-field col s6">
	      			  <input type="date" name="dateMax" id="dateMax" min="10" class="datepicker" value="<% out.print(dateMax); %>"/>
	              	  <label for="dateMax">Date de fin</label>
	            	</div>
	              </div>
            	</div>
            	
			  <div class="col s6">
	              <div class="row">
	           		<div class="input-field col s6">
	                  <i class="material-icons prefix">account_balance_wallet</i>
	      			  <input type="number" name="prixMin" id="prixMin" min="0" value="<% out.print(prixMin); %>"/>
	              	  <label for="prixMin">Prix d'entr&eacute;e minimum</label>
	            	</div>
	           		<div class="input-field col s6">
	      			  <input type="number" name="prixMax" id="prixMax" min="10" value="<% out.print(prixMax); %>"/>
	              	  <label for="prixMax">Prix d'entr&eacute;e maximum</label>
	            	</div>
	              	  <span class="badge new" data-badge-caption="Ariary"></span>
	              </div>
            	</div>
            </div>
            <button name="search" type="submit" class="btn-large waves-effect waves-light red right lighten-2">Rechercher</button>
          </form>
          <% if(request.getParameter("search") != null)ltevenement = TraitementEvenement.recherche(nom, lieu, organisateur, prixMin, prixMax, dateMin, dateMax, offset); %>
      </div>
    </div>
    <div class="row">
      <h3 class="flow-text">R&eacute;sultats :</h3>
      <div class="row">
        <div class="col s12">
          <table class="table bordered highlight">
            <tbody>
            <% for(Evenement e : ltevenement){ %>
              <tr>
                <td><img width ="100px" src="<% out.print(Traitement.getInternUrl()); %>imgAffiche/<% out.print(e.getAffiche()); %>" alt=""></td>
                <td><% out.print(e.getNom()); %></td>
                <td><% out.print(e.getPrixEntreeString()); %>
                </td>
                <td>
                  <i class="material-icons tiny"><% out.print(e.getEtoile().getRate()); %></i>
                </td>
                <td><% out.print(e.getLieu().getNom()); %></td>
                <td><img src="../img/<% out.print(e.getLieu().getRegion().getImageRegion()); %>" width="40px"/><% out.print(e.getLieu().getRegion().getRegion()); %></td>
                <td><a href="Detail.jsp?get=<% out.print(e.getId()); %>"><i class="material-icons">chevron_right</i></a></td>
              </tr>
              <% } %>
            </tbody>
          </table>
          
          <ul class="pagination center">
            <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
            <% for(int i=0;i<5;i++){ 
            	if(i == offset){ %>
            <li class="waves-effect active">
            	<a><%out.print(i+1);%></a>
            </li>
            <% }else{ %>
            <li class="waves-effect<%if(i == offset)out.print(" active");%>">
            	<a href="?page=<%out.print(i);%>"><%out.print(i+1);%></a>
            </li>	
			<% }
              } %>
            <li class="waves-effect"><a href="?page=<% out.print(offset+1);%>"><i class="material-icons">chevron_right</i></a></li>
          </ul>
        </div>
      </div>
<%@ include file="footer.jsp" %>