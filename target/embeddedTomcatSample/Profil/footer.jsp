    </div>
    
    <div id="recherche" class="modal">
        <form action="Recherche.jsp">
        <div class="modal-content">
          <div class="input-field col s6">
            <i class="material-icons prefix">search</i>
            <input id="nomRecherche" type="text" class="validate" name="nomRecherche">
            <label for="nomRecherche">Rechercher</label>
          </div>
        </div>
        <div class="modal-footer">
            <button type="submit" class=" modal-action modal-close waves-effect waves-green btn-flat">Rechercher</button>
        </div>
        </form>
    </div>
    <script src="../js/jquery.min.js" charset="utf-8"></script>
    <script src="../js/materialize.min.js" charset="utf-8"></script>
    <script>
	    $(document).ready(function(){
	      $('select').material_select();
	      $(".button-collapse").sideNav();
	      $('.datepicker').pickadate({
    	  	max : new Date(),
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 110 // Creates a dropdown of 15 years to control year
              });
               $('.modal').modal();
	    });
    </script>
  </body>
</html>