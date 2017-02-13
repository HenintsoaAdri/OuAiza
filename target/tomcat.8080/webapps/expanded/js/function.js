var id = document.getElementById('id');
var commentaire = document.getElementById("commentaire");
var type = document.getElementById("type");
var dateHeure = new Date();
var options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric' };

$("#type").click(function(){
    $.ajax({
       url : '/OuAiza/addCommentaire',
       type : 'POST',
       data : 'type=' + type.value + '&commentaire=' + commentaire.value + '&idModel=' + id.value + '&dateHeure=' + dateHeure.toISOString(),
       success : function(id, statut){
         $("#newCommentaire").load("/OuAiza/templates/commentaire.jsp",{"new":"commentaire","commentaire":commentaire.value,"dateHeure":dateHeure.toLocaleString("fr-FR",options)});
         document.getElementById("commentaireForm").reset();
       },
       error : function(resultat, statut, erreur){
       }
    });
});
$(document).ready(function(){
	$(".note").hover(function(){
	    $(this).find('i').text('star');
	    $(this).prevAll().find('i').text('star');
	    $(this).nextAll().find('i').text('star_border');
	});
});
$(".note").click(function(){
	var note = $(this).index()+1;
	$.ajax({
		url : '/OuAiza/addNote',
		type : 'POST',
		data : 'type=' + type.value + '&idModel=' + id.value + '&note=' + note,
		success : function(id, statut){
	    },
	    error : function(resultat, statut, erreur){
	    }
	});
});