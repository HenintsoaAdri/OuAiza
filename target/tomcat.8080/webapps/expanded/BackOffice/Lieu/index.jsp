<%@ include file="header.jsp" %>
            <h4>Liste des Lieux</h4>
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
                 <% for(Lieu l : TraitementLieu.getListeLieu(0)){ %>
                   <tr>
                     <td><img width="40px" src="<% out.print(Traitement.getInternUrl()); %>imgLieu/<% out.print(l.getLogo());%>" alt="" class="circle"></td>
                     <td><% out.print(l.getNom()); %></td>
                     <td><% out.print(l.getAdresse()); %></td>
                     <td><% out.print(l.getContact()); %></td>
                     <td><% out.print(l.getMail()); %></td>
                     <td><% out.print(l.getSiteWeb()); %></td>
                     <td><a class="waves-effect waves-red btn red lighten-2"><i class="material-icons left">delete_sweep</i>Retirer</a></td>
                   </tr>
                   <% } %>
                 </tbody>
               </table>
              </div>
            </div>
<%@ include file="footer.jsp" %>