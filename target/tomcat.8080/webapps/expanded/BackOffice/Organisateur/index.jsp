<%@page import="traitement.*, model.*"%>
<%@ include file="header.jsp" %>
            <h4>Liste des Organisateurs</h4>
            <div class="row">
              <div class="col s12">
                <table class="table-responsive highlight bordered">
                 <thead>
                   <tr>
                    <th></th>
                    <th>Nom</th>
                    <th>Adresse</th>
                    <th>Contact</th>
                    <th>Email</th>
                    <th>Site Web</th>
                    <th></th>
                   </tr>
                 </thead>

                 <tbody>
                 <% for(Organisateur o : TraitementOrganisateur.getListeOrganisateur(0)){ %>
                   <tr>
                     <td><img width="40px" src="<% out.print(Traitement.getInternUrl()); %>imgOrganisateur/<% out.print(o.getLogo()); %>" alt="" class="circle"></td>
                     <td><% out.print(o.getNom()); %></td>
                     <td><% out.print(o.getAdresse()); %></td>
                     <td><% out.print(o.getContact()); %></td>
                     <td><% out.print(o.getMail()); %></td>
                     <td><% out.print(o.getSiteWeb()); %></td>
                     <td><a class="waves-effect waves-red btn red lighten-2"><i class="material-icons left">delete_sweep</i>Retirer</a></td>
                   </tr>
                  <% } %>
                 </tbody>
               </table>
              </div>
            </div>
<%@ include file="footer.jsp" %>
