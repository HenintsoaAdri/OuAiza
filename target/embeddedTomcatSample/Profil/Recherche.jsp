<%@ include file="header.jsp" %>
<%@page import="java.util.Vector" %>
      <br>
      <div class="row card-panel">
    <% int offset = 0; 
    if(request.getParameter("page")!=null) offset = Integer.valueOf(request.getParameter("page"));
       String nomRecherche = "";
       Vector<Evenement> ltevenement = new Vector<Evenement>();
       Vector<Lieu> ltlieu = new Vector<Lieu>();
       Vector<Organisateur> ltorganisateur = new Vector<Organisateur>();
       if(request.getParameter("nomRecherche") != null){
    	   nomRecherche = request.getParameter("nomRecherche");
       }
    %>
      	<div class="col s12">
          <form method="get">
            <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">label</i>
                <input name="nomRecherche" type="text" class="validate" value="<% out.print(nomRecherche); %>">
                <label for="nomRecherche">Recherche</label>
              </div>
            <button type="submit" class="btn-large waves-effect waves-light red right lighten-2"><i class="material-icons small right">search</i>Rechercher</button>
            </div>
          </form>
          <% if(request.getParameter("nomRecherche") != null){
              ltevenement = TraitementEvenement.recherche(nomRecherche,offset);
              ltlieu = TraitementLieu.recherche(nomRecherche,offset);
              ltorganisateur = TraitementOrganisateur.recherche(nomRecherche,offset);
          } %>
      </div>
    </div>
    <div class="row">
      <div class="row">
        <h3 class="flow-text">Lieux</h3>
        <div class="col s12">
          <table class="table bordered highlight responsive">
            <tbody>
            <% for(Lieu l : ltlieu){ %>
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
      <div class="row">
          <h3 class="flow-text">&Eacute;v&eacute;nements</h3>
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
            <li class="waves-effect active teal">
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
      <div class="row">
        <h3 class="flow-text">Organisateurs</h3>
        <div class="col s12">
          <table class="table bordered highlight responsive">
            <tbody>
            <% for(Organisateur o : ltorganisateur){ %>
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
            <li class="waves-effect active orange lighten-2">
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