          </div>
      </div>
    </div>
    <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
    <script src="../../js/jquery.min.js" charset="utf-8"></script>
    <script src="../../js/materialize.min.js" charset="utf-8"></script>
    <script type="text/javascript">
      $(document).ready(function() {
       $('select').material_select();
       $('.button-collapse').sideNav({
    	      menuWidth: 300, // Default is 240
    	      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
    	      draggable: true // Choose whether you can drag to open on touch screens
    	    });
       $('.datepicker').pickadate({
          selectMonths: true, // Creates a dropdown to control month
          selectYears: 15 // Creates a dropdown of 15 years to control year
        });
      });
    </script>
  </body>
</html>