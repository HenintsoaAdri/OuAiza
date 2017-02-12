package traitement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Vector;

import dao.CommentaireDAO;
import dao.EtoileDAO;
import dao.EvenementDAO;
import model.*;

public class TraitementEvenement {
	

	public static void insertEvenement(Lieu lieu, Organisateur organisateur, String nom, 
		    String dateEvenement,String dateFinEvenement, String description,
		    String prixEntree, String condition, String autreInfo, String affiche) throws Exception{
		  Evenement e = new Evenement();
		  e.setLieu(lieu);
		  e.setOrganisateur(organisateur);
		  e.setNom(nom);
		  e.setDateDebutEvenement(LocalDateTime.parse(dateEvenement));
		  e.setDateFinEvenement(LocalDateTime.parse(dateFinEvenement));
		  e.setDescription(description);
		  e.setPrixEntree(Double.parseDouble(prixEntree));
		  e.setCondition(condition);
		  e.setAutreInfo(autreInfo);
		  e.setAffiche(affiche);
		  EvenementDAO.insertEvenement(e);
	}
	
	public static Vector<Evenement> getListeEvenement(int offset) throws Exception{
		return EvenementDAO.getEvenement(offset);
	}

	public static Evenement getEvenement(String idEvenement)throws Exception{
		return EvenementDAO.getEvenementById(Integer.parseInt(idEvenement));
	}
	public static void commenter(String commentaire, String evenement, String dateHeure, Profil profil) throws Exception{
		Commentaire c = new Commentaire();
		c.setCommentaire(commentaire);
		c.setDateHeure(LocalDateTime.parse(dateHeure,DateTimeFormatter.ISO_DATE_TIME));
		c.setProfil(profil);
		Evenement e = new Evenement();
		e.setId(Integer.parseInt(evenement));
		CommentaireDAO.insertCommentaire(c, e);
	}
	public static void noter(int note, String evenement,Profil profil)throws Exception{
		Evenement e = new Evenement();
		e.setId(Integer.parseInt(evenement));
		EtoileDAO.insertEtoile(new Note(profil,note),e);
	}
	public static Vector<Evenement> recherche(String nom, String lieu, String organisateur, String prixMin, String prixMax, String dateMin, String dateMax, int offset) throws Exception{
		int prixMinValue = 0;
		int prixMaxValue = 100000;
		LocalDate dateMinValue = LocalDate.now().minusYears(1);
		LocalDate dateMaxValue = LocalDate.now().plusYears(20);
		try{
			prixMinValue = Integer.parseInt(prixMin);
		}catch(Exception e){}
		try{
			prixMaxValue = Integer.parseInt(prixMax);
		}catch(Exception e){}
		try{
			dateMinValue = LocalDate.parse(dateMin);
		} catch (DateTimeParseException e) {
			try{
				DateTimeFormatter format = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("d MMMM, uuuu").toFormatter(Locale.FRANCE);
				dateMinValue = LocalDate.parse(dateMin, format);
			}catch(Exception e1){
				e1.printStackTrace();			
			}
		}
		try {
			dateMaxValue = LocalDate.parse(dateMax);
		}catch (DateTimeParseException e) {
			try{
				DateTimeFormatter format = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("d MMMM, uuuu").toFormatter(Locale.FRANCE);
				dateMaxValue = LocalDate.parse(dateMax, format);
			}catch(Exception e1){
				e1.printStackTrace();			
			}
		}
		return EvenementDAO.rechercheEvenement(nom, lieu, organisateur, prixMinValue, prixMaxValue, dateMinValue, dateMaxValue, offset);
	}
        public static Vector<Evenement> recherche(String nomEvenement, int offset) throws Exception{
            return recherche(nomEvenement,"", "", "", "", "", "", offset);
        }
}
