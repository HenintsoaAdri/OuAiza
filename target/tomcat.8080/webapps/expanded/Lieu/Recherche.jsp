<%@ include file="header.jsp" %>
      <h5 class="flow-text right-center"><i class="material-icons small right">search</i>Rechercher un lieu</h5>
      <div class="row card-panel">
    <% int offset = 0; 
    if(request.getParameter("page")!=null) offset = Integer.valueOf(request.getParameter("page"));
       String nom = "";
       String prixMin = "";
       String prixMax = "";
       String region = "1";
       boolean ouvert = false;
       Vector<Lieu> lieu = TraitementLieu.getListeLieu(offset*10);
       if(request.getParameter("search") != null){
    	   nom = request.getParameter("nom");
    	   prixMin = request.getParameter("prixMin");
    	   prixMax = request.getParameter("prixMax");
    	   region = request.getParameter("region");
    	   ouvert = request.getParameter("ouvert") != null;
       }
    %>
      	<div class="col s12">
          <form method="get">
            <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">label</i>
                <input name="nom" type="text" class="validate" value="<% out.print(nom); %>">
                <label for="nom">Nom de lieu</label>
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
              	  <span class="badge new" data-badge-caption="">Ariary</span>
              </div>
            </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">map</i>
		      	<select class="icons" name="region"  required>
			      <option disabled selected>Choisissez une r&eacute;gion</option>
			     <% for(model.Region r : TraitementLieu.getRegion()) { %>
			      <option value="<% out.print(r.getId()); %>" data-icon="../img/<% out.print(r.getImageRegion()); %>"><% out.print(r.getRegion()); %></option>
			     <% } %>
			    </select>
			    <label>R&eacute;gion</label>
			  </div>
            </div>
            <div class="row">
          	  <div class="input-field col s6">
                <i class="material-icons prefix">today</i>
      			<input type="checkbox" name="ouvert" id="ouvert" <% if(ouvert)out.print("checked"); %> />
              	<label for="ouvert">Ouvert en ce moment</label>
              </div>
            </div>
            <button name="search" type="submit" class="btn-large waves-effect waves-light red right lighten-2">Rechercher</button>
          </form>
          <% if(request.getParameter("search") != null)lieu = TraitementLieu.recherche(nom, region, prixMin, prixMax, ouvert, offset); %>
      </div>
    </div>
    <div class="row">
      <h3 class="flow-text">R&eacute;sultats :</h3>
      <div class="row">
        <div class="col s12">
          <table class="table bordered highlight responsive">
            <tbody>
            <% for(Lieu l : lieu){ %>
              <tr>
                <td><img width="100px" class="responsive-img" src="<% out.print(Traitement.getInternUrl()); %>imgLieu/<% out.print(l.getLogo()); %>" alt=""></td>
                <td><% out.print(l.getNom()); %></td>
                <td>
                  <i class="material-icons tiny"><% out.print(l.getEtoile().getRate()); %></i>
                </td>
                <td><% out.print(l.getRegion().getRegion()); %></td>
                <td><a href="../Recommandation/CreateRecommandation.jsp?with=<% out.print(l.getId()); %>" class="btn wave-effect wave-ligth">Recommander</a></td>
                <td><a href="Detail.jsp?get=<% out.print(l.getId()); %>"><i class="material-icons">chevron_right</i></a></td>
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