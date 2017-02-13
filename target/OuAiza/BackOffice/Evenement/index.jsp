<%@page import="model.Evenement,traitement.*"%>
<%@ include file="header.jsp" %>
            <h4>Liste des &Eacute;v&eacute;nements</h4>
            <div class="row">
              <div class="col s12">
                <table class="table-responsive highlight bordered">
                 <thead>
                   <tr>
                    <th></th>
                    <th>Nom de l'&eacute;v&egrave;nement</th>
                    <th>Date de début</th>
                    <th>Date de fin </th>
                    <th>Lieu</th>
                    <th>Prix d'entr&eacute;e</th>
                    <th>Organisateur</th>
                    <th></th>
                   </tr>
                 </thead>

                 <tbody>
                   <tr>
                   <% for(Evenement e : TraitementEvenement.getListeEvenement(0)){ %>
                     <td><img width="40px" src="<% out.print(Traitement.getInternUrl()); %>imgAffiche/<% out.print(e.getAffiche()); %>" alt="" class="circle"></td>
                     <td><% out.print(e.getNom()); %></td>
                     <td><% out.print(e.getDebutString()); %></td>
                     <td><% out.print(e.getFinString()); %></td>
                     <td><% out.print(e.getLieu().getNom()); %></td>
                     <td><% out.print(e.getPrixEntreeString()); %></td>
                     <td><% out.print(e.getOrganisateur().getNom()); %></td>
                     <td><a class="waves-effect waves-red btn red lighten-2"><i class="material-icons left">delete_sweep</i>Retirer</a></td>
                   <% } %>
                   </tr>
                 </tbody>
               </table>
              </div>
            </div>
<%@ include file="footer.jsp" %>
