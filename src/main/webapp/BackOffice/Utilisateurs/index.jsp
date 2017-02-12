<%@page import="traitement.*,model.*"%>
<%@ include file="header.jsp" %>
            <h4>Liste des Utilisateurs</h4>
            <div class="row">
              <div class="col s12">
                <table class="table-responsive highlight bordered">
                 <thead>
                   <tr>
                    <th></th>
                    <th>Nom &amp; Pr&eacute;nom</th>
                    <th>Date de naissance</th>
                    <th>Sexe</th>
                    <th>Email</th>
                    <th>Adresse</th>
                    <th>Confirm&eacute;</th>
                    <th></th>
                   </tr>
                 </thead>

                 <tbody>
                 <% for(Profil p : TraitementProfil.getListProfil(0)){ %>
                   <tr>
                     <td><img width="40px" src="<% out.print(Traitement.getInternUrl()); %>imgProfil/<% out.print(p.getPhoto()); %>" alt="" class="circle"></td>
                     <td><% out.print(p.getFullName()); %></td>
                     <td><% out.print(p.getDateNaissanceString()); %></td>
                     <td><% out.print(p.getSexeString()); %></td>
                     <td><% out.print(p.getEmail()); %></td>
                     <td><% out.print(p.getAdresse()); %></td>
                     <td><i class="material-icons"><% if(p.isConfirmed())out.print("check_box");else out.print("check_box_outline_blank"); %></i></td>
                     <td><a class="waves-effect waves-red btn red lighten-2"><i class="material-icons left">delete_sweep</i>Retirer</a></td>
                   </tr>
                   <% } %>
                 </tbody>
               </table>
              </div>
            </div>
<%@ include file="header.jsp" %>
