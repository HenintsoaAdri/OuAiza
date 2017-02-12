package traitement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import dao.CommentaireDAO;
import dao.EtoileDAO;
import dao.LieuDAO;
import dao.RecommandationDAO;
import model.Commentaire;
import model.DetailHoraire;
import model.Horaire;
import model.Lieu;
import model.Note;
import model.Profil;
import model.Recommandation;
import model.Region;
import utilitaire.StringUtil;

public class TraitementLieu {

	public static Vector<Region> getRegion() throws Exception{
		return LieuDAO.getRegion();
	}
	public static void insertRegion(String region, String imageRegion)throws Exception{
		Region r = new Region(region,imageRegion);
		LieuDAO.insertRegion(r);
	}
	public static void insertLieu(String region, String nom, String adresse,String description, String prixEntree,
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
	public static void insertLieu(String region, String nom, String adresse,String description, String prixEntree,
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
	public static Horaire createHoraire(String lundiO, String lundiF,
			String mardiO, String mardiF,
			String mercrediO, String mercrediF,
			String jeudiO, String jeudiF,
			String vendrediO, String vendrediF,
			String samediO, String samediF,
			String dimancheO, String dimancheF
			){
		return createHoraire(LocalTime.parse(lundiO),LocalTime.parse(lundiO),
				LocalTime.parse(mardiO),LocalTime.parse(mardiF),
				LocalTime.parse(mercrediO), LocalTime.parse(mercrediF),
				LocalTime.parse(jeudiO), LocalTime.parse(jeudiF),
				LocalTime.parse(vendrediO),LocalTime.parse(vendrediF),
				LocalTime.parse(samediO), LocalTime.parse(samediF),
				LocalTime.parse(dimancheO), LocalTime.parse(dimancheF)
				);
	}
	public static Horaire createHoraire(LocalTime lundiO, LocalTime lundiF,
			LocalTime mardiO, LocalTime mardiF,
			LocalTime mercrediO, LocalTime mercrediF,
			LocalTime jeudiO, LocalTime jeudiF,
			LocalTime vendrediO, LocalTime vendrediF,
			LocalTime samediO, LocalTime samediF,
			LocalTime dimancheO, LocalTime dimancheF
			){
		Horaire h = new Horaire();
		h.setLundi(new DetailHoraire(lundiO, lundiO));
		h.setMardi(new DetailHoraire(mardiO, mardiF));
		h.setMercredi(new DetailHoraire(mercrediO, mercrediF));
		h.setJeudi(new DetailHoraire(jeudiO, jeudiF));
		h.setVendredi(new DetailHoraire(vendrediO, vendrediF));
		h.setSamedi(new DetailHoraire(samediO, samediF));
		h.setDimanche(new DetailHoraire(dimancheO, dimancheF));
		return h;
	}
	public static Horaire createHoraire(HttpServletRequest request) {
		return createHoraire(
    			StringUtil.stringToTime(request.getParameter("lundiHO"),request.getParameter("lundiMO")),
    			StringUtil.stringToTime(request.getParameter("lundiHF"), request.getParameter("lundiMF")), 
    			StringUtil.stringToTime(request.getParameter("mardiHO"),request.getParameter("mardiMO")),
    			StringUtil.stringToTime(request.getParameter("mardiHF"), request.getParameter("mardiMF")),
    			StringUtil.stringToTime(request.getParameter("mercrediHO"),request.getParameter("mercrediMO")),
    			StringUtil.stringToTime(request.getParameter("mercrediHF"), request.getParameter("mercrediMF")), 
    			StringUtil.stringToTime(request.getParameter("jeudiHO"),request.getParameter("jeudiMO")),
    			StringUtil.stringToTime(request.getParameter("jeudiHF"), request.getParameter("jeudiMF")),
    			StringUtil.stringToTime(request.getParameter("vendrediHO"),request.getParameter("vendrediMO")),
    			StringUtil.stringToTime(request.getParameter("vendrediHF"), request.getParameter("vendrediMF")),
    			StringUtil.stringToTime(request.getParameter("samediHO"),request.getParameter("samediMO")),
    			StringUtil.stringToTime(request.getParameter("samediHF"), request.getParameter("samediMF")),
    			StringUtil.stringToTime(request.getParameter("dimancheHO"),request.getParameter("dimancheMO")),
    			StringUtil.stringToTime(request.getParameter("dimancheHF"), request.getParameter("dimancheMF"))
    	);
	}
	public static Vector<Lieu> getListeLieu(int offset) throws Exception{
		return LieuDAO.getLieu(offset);
	}

	public static Lieu getLieu(String idLieu)throws Exception{
		return LieuDAO.getLieuById(Integer.parseInt(idLieu));
	}
	public static void commenter(String commentaire, String lieu, String dateHeure, Profil profil) throws Exception{
		Commentaire c = new Commentaire();
		c.setCommentaire(commentaire);
		c.setDateHeure(LocalDateTime.parse(dateHeure,DateTimeFormatter.ISO_DATE_TIME));
		c.setProfil(profil);
		Lieu l = new Lieu();
		l.setId(Integer.parseInt(lieu));
		CommentaireDAO.insertCommentaire(c, l);
	}
	public static void noter(int note, String lieu,Profil profil)throws Exception{
		Lieu l = new Lieu();
		l.setId(Integer.parseInt(lieu));
		EtoileDAO.insertEtoile(new Note(profil,note),l);
	}
	public static void recommander(String description, String image, Profil profil, String lieu)
			throws Exception {
		Recommandation r = new Recommandation();
		r.setDescription(description);
		r.setImage(image);
		r.setProfil(profil);
		 Lieu l = new Lieu();
		 l.setId(Integer.parseInt(lieu));
		r.setLieu(l);
		RecommandationDAO.insertRecommandation(r);
	}
	public static Vector<Lieu> recherche(String nom, String region, String prixMin, String prixMax, Boolean ouvert, int offset) throws Exception{
		int regionValue = 0;
		int prixMinValue = 0;
		int prixMaxValue = 100000;
		try{
			regionValue = Integer.parseInt(region);	
		}catch(Exception e){}
		try{
			prixMinValue = Integer.parseInt(prixMin);
		}catch(Exception e){}
		try{
			prixMaxValue = Integer.parseInt(prixMax);
		}catch(Exception e){}
		return LieuDAO.rechercheLieu(nom, regionValue, prixMinValue, prixMaxValue, ouvert, offset);
	}
        public static Vector<Lieu> recherche(String nomLieu, int offset) throws Exception{
            return recherche(nomLieu,"", "", "", false, offset);
        }
}
