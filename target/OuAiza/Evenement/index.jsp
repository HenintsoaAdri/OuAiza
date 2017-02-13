<%@ include file="header.jsp" %>
<% int offset = 0;
	if(request.getParameter("page")!=null) offset = Integer.valueOf(request.getParameter("page"));
try{
	Vector<Evenement> evenement = TraitementEvenement.getListeEvenement(offset*10);
%>
      <div class="row">
        <div class="col s12">
          <div class="row">
           <% if(evenement.isEmpty()){ %>
           	<div class="col m6 s12">
          	 <div class="card-panel red lighten-2 small">
        		<span class="white-text">Probl&egrave;me! Aucun &eacute;v&eacute;nement à venir</span>
      		  </div>
      		 </div>
          	 <% } %>
          <% for(Evenement e : evenement){ %>
          	<div class="col m6 card">
          		<div class="card-image">
	          		<img src="<% out.print(Traitement.getInternUrl()+"imgAffiche/"+e.getAffiche()); %>" alt="" class="responsive-img materialboxed">
          		</div>
	          <ul class="text-left collection">
	            <li class=" collection-item avatar">
	              <p><% out.print(e.getNom()); %>,</p>
	              par <% out.print(e.getOrganisateur().getNom()); %>
	              <p>
	                <i class="material-icons"><% out.print(e.getEtoile().getRate()); %></i>
	              </p>
	              <p><i class="material-icons">place</i><% out.print(e.getLieu().getNom()); %> - 
	              <% out.print(e.getLieu().getRegion().getRegion()); %></p>
	              <a href="Detail.jsp?get=<% out.print(e.getId()); %>" class="secondary-content"><i class="material-icons">chevron_right</i></a>
	            </li>
	          </ul>
          	</div>
          	<% } %>
          </div>
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
<% }catch(Exception e){ 
		e.printStackTrace(); %>
		<div class="card-panel red lighten-2">
        	<span class="white-text">Probl&egrave;me! <% out.print(e.getMessage()); %></span>
      	</div>	
<%	} %>
<%@ include file="footer.jsp" %>