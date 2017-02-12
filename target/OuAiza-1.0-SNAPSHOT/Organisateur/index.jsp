<%@ include file="header.jsp" %>
<% int offset = 0;
	if(request.getParameter("page")!=null) offset = Integer.valueOf(request.getParameter("page"));
try{
	Vector<Organisateur> org = TraitementOrganisateur.getListeOrganisateur(offset*10);
%>
      <div class="row">
        <div class="col s12 l8">
           <% if(org.isEmpty()){ %>
          	 <div class="card-panel red lighten-2">
        		<span class="white-text">Probl&egrave;me! Aucun lieu &agrave; vous proposer</span>
      		  </div>
          	 <% } %>
          <ul class="text-left collection">
          <% for(Organisateur o : org){ %>
            <li class="collection-item avatar">
              <a href="../Organisateur/Detail.jsp?get=<% out.print(o.getId()); %>">
	            <img class="circle" src="<% out.print(Traitement.getInternUrl()); %>imgOrganisateur/<% out.print(o.getLogo()); %>" alt="">
	            <% out.print(o.getNom()); %><br>
	            <i class="material-icons"><% out.print(o.getEtoile().getRate()); %></i><br>
	            <% out.print(o.getRegion().getRegion()); %><br>
              </a>
	            <a href="../Organisateur/Detail.jsp?get=<% out.print(o.getId()); %>" class="secondary-content"><i class="material-icons">chevron_right</i></a>
            </li>
			<% } %>
          </ul>
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
        <div class="col s12 l4">
        	<h5 class="center">Recommandations</h5>
        <% for(Recommandation r : TraitementRecommandation.getRecommandation(0)){ %>
          <div class="row">
            <div class="col s6 l12">
              <div class="card">
                  <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="<% out.print(Traitement.getInternUrl()); %>imgRecommandation/<% out.print(r.getImage()); %>">
                  </div>
                  <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4"><% out.print(r.getLieu().getNom()); %><i class="material-icons right">more_vert</i></span>
                    <div class="row">
                    	<div class="col s3">
                    		<img src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(r.getProfil().getPhoto()); %>" alt="" class="circle responsive-img">
                    	</div>
                    	<div class="col s9">
                    		<p><a href="../Profil/Compte.jsp?account=<% out.print(r.getProfil().getIdentifiant()); %>">@<% out.print(r.getProfil().getIdentifiant()); %></a></p>
                    		<i class="material-icons red-text lighten-2" title="<% out.print(r.getEtoile().getVoteString());%>">
                    			<% out.print(r.getEtoile().getRate()); %>
                    		</i>
                    		<p><% out.print(r.getEtoile().getMoyenneString()); %></p>
                    	</div>
                    </div>
                    		<p><a href="../Recommandation/Detail.jsp?get=<% out.print(r.getId()); %>">Voir les détails</a></p>
                  </div>
                  <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4"><% out.print(r.getLieu().getNom()); %><i class="material-icons right">close</i></span>
                    <div class="row valign-wrapper">
                      <div class="col s3">
                        <img src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(r.getProfil().getPhoto()); %>" alt="" class="circle responsive-img">
                      </div>
                      <div class="col s9">
                      	<a href="../Profil/Compte.jsp?account=<% out.print(r.getProfil().getIdentifiant()); %>"><span>@<% out.print(r.getProfil().getIdentifiant()); %></span></a>
                        <span class="black-text">
                          <% out.print(r.getDescription()); %>
                        </span>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
          </div>
        <% } %>
        </div>
      </div>
<% }catch(Exception e){ 
		e.printStackTrace(); %>
		<div class="card-panel red lighten-2">
        	<span class="white-text">Probl&egrave;me! <% out.print(e.getMessage()); %></span>
      	</div>	
<%	} %>
<%@ include file="footer.jsp" %>