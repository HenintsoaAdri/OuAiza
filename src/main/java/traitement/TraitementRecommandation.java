package traitement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import dao.CommentaireDAO;
import dao.EtoileDAO;
import dao.RecommandationDAO;
import model.Commentaire;
import model.Lieu;
import model.Note;
import model.Profil;
import model.Recommandation;

public class TraitementRecommandation {
	public static Vector<Recommandation> getRecommandation(int offset) throws Exception{
		return RecommandationDAO.getRecommandation(offset);
	}
	public static Recommandation getRecommandation(String idRecommandation)throws Exception{
		return RecommandationDAO.getRecommandationById(Integer.parseInt(idRecommandation));
	}
	public static void commenter(String commentaire, String recommandation, String dateHeure, Profil profil) throws Exception{
		Commentaire c = new Commentaire();
		c.setCommentaire(commentaire);
		c.setDateHeure(LocalDateTime.parse(dateHeure,DateTimeFormatter.ISO_DATE_TIME));
		c.setProfil(profil);
		Recommandation r = new Recommandation();
		r.setId(Integer.parseInt(recommandation));
		CommentaireDAO.insertCommentaire(c, r);
	}
	public static void noter(int note, String recommandation,Profil profil)throws Exception{
		Recommandation r = new Recommandation();
		r.setId(Integer.parseInt(recommandation));
		EtoileDAO.insertEtoile(new Note(profil,note),r);
	}
	public static void insert(String idLieu, Profil profil, String description, String image) throws Exception{
		Lieu l = new Lieu();
		l.setId(Integer.parseInt(idLieu));
		
		Recommandation r = new Recommandation();
		r.setProfil(profil);
		r.setDescription(description);
		r.setImage(image);
		r.setLieu(l);
		
		RecommandationDAO.insertRecommandation(r);
	}
}
