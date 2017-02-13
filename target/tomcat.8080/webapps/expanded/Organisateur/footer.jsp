    </div>
    <div id="recherche" class="modal">
        <form action="Recherche.jsp">
        <div class="modal-content">
          <div class="input-field col s6">
            <i class="material-icons prefix">search</i>
            <input id="nomOrganisateur" type="text" class="validate" name="nomOrganisateur">
            <label for="nomOrganisateur">Rechercher un organisateur</label>
          </div>
        </div>
        <div class="modal-footer">
            <button type="submit" class=" modal-action modal-close waves-effect waves-green btn-flat">Rechercher</button>
        </div>
        </form>
    </div>
    <script src="../js/jquery.min.js" charset="utf-8"></script>
    <script src="../js/materialize.min.js" charset="utf-8"></script>
    <script src="../js/function.js" charset="utf-8"></script>
    <script>
	    $(document).ready(function(){
              $('.modal').modal();
	      $('.carousel').carousel();
	      $(".button-collapse").sideNav();
	    });
    </script>
  </body>
</html>