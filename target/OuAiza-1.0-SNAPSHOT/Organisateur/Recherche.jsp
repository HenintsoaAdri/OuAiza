<%@ include file="header.jsp" %>
      <h5 class="flow-text right-center"><i class="material-icons small right">search</i>Rechercher un organisateur</h5>
      <div class="row card-panel">
    <% int offset = 0; 
    if(request.getParameter("page")!=null) offset = Integer.valueOf(request.getParameter("page"));
       String nomOrganisateur = "";
       Vector<Organisateur> organisateur = TraitementOrganisateur.getListeOrganisateur(offset*10);
       if(request.getParameter("nomOrganisateur")!=null){
    	   nomOrganisateur = request.getParameter("nomOrganisateur");
       }
    %>
      	<div class="col s12">
          <form method="get">
            <div class="row">
                <div class="input-field col s6">
                  <i class="material-icons prefix">search</i>
                  <input id="nomOrganisateur" type="text" class="validate" name="nomOrganisateur">
                  <label for="nomOrganisateur">Rechercher un organisateur</label>
                </div>
                <div class="input-field col s6">
                    <button type="submit" class="btn-large waves-effect waves-light red right lighten-2">Rechercher</button>
                </div>
            </div>
          </form>
          <% if(!nomOrganisateur.isEmpty())organisateur = TraitementOrganisateur.recherche(nomOrganisateur, offset); %>
      </div>
    </div>
    <div class="row">
      <h3 class="flow-text">R&eacute;sultats :</h3>
      <div class="row">
        <div class="col s12">
          <table class="table bordered highlight responsive">
            <tbody>
            <% for(Organisateur o : organisateur){ %>
              <tr>
                <td><img width="100px" class="responsive-img" src="<% out.print(Traitement.getInternUrl()); %>imgOrganisateur/<% out.print(o.getLogo()); %>" alt=""></td>
                <td><% out.print(o.getNom()); %></td>
                <td>
                  <i class="material-icons tiny"><% out.print(o.getEtoile().getRate()); %></i>
                </td>
                <td><% out.print(o.getAdresse()); %></td>
                <td><% out.print(o.getRegion().getRegion()); %></td>
                <td><a href="Detail.jsp?get=<% out.print(o.getId()); %>"><i class="material-icons">chevron_right</i></a></td>
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