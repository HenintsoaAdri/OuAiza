		</div>
      </div>
    </div>
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
      });
    </script>
  </body>
</html>