package traitement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import dao.OrganisateurDAO;
import dao.CommentaireDAO;
import dao.EtoileDAO;
import dao.LieuDAO;
import model.Organisateur;
import model.Profil;
import model.Commentaire;
import model.Horaire;
import model.Lieu;
import model.Note;
import model.Region;

public class TraitementOrganisateur {
	
	public static void insertOrganisateur(String region, String nom, String adresse,String description, String prixEntree,
			String contact, String siteWeb, String mail) throws Exception{
		Region r = new Region();
		r.setId(Integer.parseInt(region));
		Lieu l = new Lieu();
		l.setNom(nom);
		l.setAdresse(adresse);
		l.setDescription(description);
		l.setPrixEntree(Double.parseDouble(prixEntree));
		l.setContact(contact);
		l.setSiteWeb(siteWeb);
		l.setMail(mail);
		LieuDAO.insertLieu(l);
	}
	public static void insertOrganisateur(String region, String nom, String adresse,String description, String prixEntree,
			String contact, String siteWeb, String mail, Horaire horaire) throws Exception{
		Region r = new Region();
		r.setId(Integer.parseInt(region));
		Lieu l = new Lieu();
		l.setNom(nom);
		l.setAdresse(adresse);
		l.setDescription(description);
		l.setPrixEntree(Double.parseDouble(prixEntree));
		l.setContact(contact);
		l.setSiteWeb(siteWeb);
		l.setMail(mail);
		l.setHoraire(horaire);
		l.setRegion(r);
		LieuDAO.insertLieu(l);
	}
	
	public static Vector<Organisateur> getListeOrganisateur(int offset) throws Exception{
		return OrganisateurDAO.getOrganisateur(offset);
	}

	public static Organisateur getOrganisateur(String idOrganisateur)throws Exception{
		return OrganisateurDAO.getOrganisateurById(Integer.parseInt(idOrganisateur));
	}
	public static void commenter(String commentaire, String organisateur, String dateHeure, Profil profil) throws Exception{
		Commentaire c = new Commentaire();
		c.setCommentaire(commentaire);
		c.setDateHeure(LocalDateTime.parse(dateHeure,DateTimeFormatter.ISO_DATE_TIME));
		c.setProfil(profil);
		Organisateur o = new Organisateur();
		o.setId(Integer.parseInt(organisateur));
		CommentaireDAO.insertCommentaire(c, o);
	}
	public static void noter(int note, String organisateur,Profil profil)throws Exception{
		Organisateur o = new Organisateur();
		o.setId(Integer.parseInt(organisateur));
		EtoileDAO.insertEtoile(new Note(profil,note),o);
	}
        public static Vector<Organisateur> recherche(String nomOrganisateur, int offset) throws Exception{
            return OrganisateurDAO.recherche(nomOrganisateur, offset);
        }
}
