package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.Vector;

import model.Administrateur;
import model.Commentaire;
import model.DetailHoraire;
import model.Etoile;
import model.Evenement;
import model.Horaire;
import model.Lieu;
import model.LieuRetire;
import model.Organisateur;
import model.Profil;
import model.Recommandation;
import model.Region;

public class Creation {

	public Creation() {}
	
	public static Region creerRegion(ResultSet res) throws SQLException{
		Region model = new Region(
				res.getInt("IDREGION"), 
				res.getString("REGION"),
				res.getString("IMAGEREGION"));
		return model;
	}
	public static Region creerRegionRecommandation(ResultSet res) throws SQLException{
		Region model = new Region(
				res.getInt("IDREGIONP"), 
				res.getString("REGIONP"),
				res.getString("IMAGEREGIONP"));
		return model;
	}
	
	public static Profil creerProfil(ResultSet res) throws Exception{
		Profil model = new Profil(
				res.getInt("IDPROFIL"),
				creerRegion(res),
				res.getString("NOMPROFIL"), 
				res.getString("PRENOMPROFIL"),
				res.getDate("DATENPROFIL").toLocalDate(),
				res.getString("SEXEPROFIL"),
				res.getString("EMAILPROFIL"),
				res.getString("IDENTIFIANT"),
				res.getString("PASSWORDPROFIL"),
				res.getString("PHOTOPROFIL"),
				res.getString("ADRESSEPROFIL"),
				res.getBoolean("ISCONFIRMED"));
		return model;
	}
	public static Profil creerProfilRecommandation(ResultSet res) throws Exception{

		Profil model = new Profil(
				res.getInt("IDPROFIL"),
				creerRegionRecommandation(res),
				res.getString("NOMPROFIL"), 
				res.getString("PRENOMPROFIL"),
				res.getDate("DATENPROFIL").toLocalDate(),
				res.getString("SEXEPROFIL"),
				res.getString("EMAILPROFIL"),
				res.getString("IDENTIFIANT"),
				res.getString("PASSWORDPROFIL"),
				res.getString("PHOTOPROFIL"),
				res.getString("ADRESSEPROFIL"),
				res.getBoolean("ISCONFIRMED"));
		return model;
	}
	
	public static Lieu creerLieu(ResultSet res) throws Exception{
		Lieu model = new Lieu(
				res.getInt("IDLIEU"),
				creerRegion(res),
				res.getString("NOMLIEU"), 
				res.getString("ADRESSELIEU"),
				res.getString("DESCRIPTIONLIEU"),
				res.getDouble("PRIXENTREELIEU"),
				res.getString("CONTACTLIEU"),
				res.getString("SITEWEBLIEU"),
				res.getString("MAILLIEU"),
				res.getString("LOGOLIEU"),
				creerEtoile(res));
                model.setPosition(res.getFloat("LATITUDE"), res.getFloat("LONGITUDE"));
		return model;
	}
	public static LieuRetire creerLieuRetire(ResultSet res) throws Exception{
		LieuRetire model = new LieuRetire(
				res.getInt("IDLIEU"),
				creerRegion(res),
				res.getString("NOMLIEU"), 
				res.getString("ADRESSELIEU"),
				res.getString("DESCRIPTIONLIEU"),
				res.getDouble("PRIXENTREELIEU"),
				res.getString("CONTACTLIEU"),
				res.getString("SITEWEBLIEU"),
				res.getString("MAILLIEU"),
				res.getString("LOGOLIEU")
				);
		model.setAdministrateur(creerAdministrateur(res));
		model.setDateRetire(res.getDate("DATERETIRE").toLocalDate());
		model.setRemarque(res.getString("REMARQUE"));
		return model;
	}
	
	public static Vector<String> createListeMenu(ResultSet res) throws Exception{
		Vector<String> vect = new Vector<String>();
		while (res.next()) {
			vect.add("PHOTOMENU");
		}
		return null;
	}

	public static Vector<String> createListeCategorie(ResultSet res) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	

	public static Horaire createHoraire(ResultSet res) throws Exception {
		try {
			Horaire h = new Horaire();
			while(res.next()){
				h.addDetailHoraire(createDetailHoraire(res), DayOfWeek.of(res.getInt("JOUR")));
			}
			return h;
		} catch (Exception e) {
			throw e;
		} finally {
			res.close();
		}
		
	}
	public static DetailHoraire createDetailHoraire(ResultSet res)throws Exception {
		return new DetailHoraire(
							res.getTime("OUVERTURE").toLocalTime(),
							res.getTime("FERMETURE").toLocalTime(),
							res.getTime("PAUSEDEBUT").toLocalTime(),
							res.getTime("PAUSEFIN").toLocalTime()
						);
	}
	public static Evenement creerEvenement(ResultSet res) throws Exception{
		Evenement model = new Evenement(
				res.getInt("IDEVENEMENT"),
				creerLieu(res),
				creerOrganisateur(res),
				res.getString("NOMEVENEMENT"), 
				res.getTimestamp("DATEDEBUTEVENEMENT").toLocalDateTime(),
				res.getTimestamp("DATEFINEVENEMENT").toLocalDateTime(), 
				res.getString("DESCRIPTIONEVENEMENT"),
				res.getDouble("PRIXENTREEEVENEMENT"),
				res.getString("CONDITION"),
				res.getString("AUTREINFO"),
				res.getString("AFFICHE"));
		model.setEtoile(creerEtoile(res));
		return model;
	}

	public static Evenement creerEvenement(ResultSet res, Organisateur o) throws Exception{
		Evenement model = new Evenement(
				res.getInt("IDEVENEMENT"),
				creerLieu(res),
				o,
				res.getString("NOMEVENEMENT"), 
				res.getTimestamp("DATEDEBUTEVENEMENT").toLocalDateTime(),
				res.getTimestamp("DATEFINEVENEMENT").toLocalDateTime(), 
				res.getString("DESCRIPTIONEVENEMENT"),
				res.getDouble("PRIXENTREEEVENEMENT"),
				res.getString("CONDITION"),
				res.getString("AUTREINFO"),
				res.getString("AFFICHE"));
		model.setEtoile(creerEtoile(res));
		return model;
	}
	
	public static Administrateur creerAdministrateurDetail(ResultSet res) throws SQLException{
		Administrateur model = new Administrateur(
				res.getInt("IDADMINISTRATEUR"), 
				res.getString("IDENTIFIANT"), 
				res.getString("PASSWORD"));
		return model;
	}
	public static Administrateur creerAdministrateur(ResultSet res) throws SQLException{
		Administrateur model = new Administrateur(
				res.getInt("IDADMINISTRATEUR"), 
				res.getString("IDENTIFIANT"));
		return model;
	}
	
	public static Organisateur creerOrganisateur(ResultSet res) throws Exception{
		Organisateur model = new Organisateur(
				res.getInt("IDORGANISATEUR"), 
				res.getString("NOMORGANISATEUR"), 
				res.getString("DESCRIPTIONORGANISATEUR"),
				res.getString("LOGOORGANISATEUR"),
				res.getString("CONTACTORGANISATEUR"),
				res.getString("MAILORGANISATEUR"),
				res.getString("ADRESSEORGANISATEUR"),
				creerRegion(res),
				res.getString("SITEWEBORGANISATEUR"),
				creerEtoile(res));
		return model;
	}
	
	public static Commentaire creerCommentaire(ResultSet res) throws Exception{
		Commentaire model = new Commentaire(
				res.getInt("IDCOMMENTAIRE"), 
				res.getString("COMMENTAIRE"),
				res.getTimestamp("DATEHEURECOMMENTAIRE").toLocalDateTime(),
				creerProfil(res));
		return model;
	}
	
	public static Etoile creerEtoile(ResultSet res) throws Exception{
		Etoile model = new Etoile(
				res.getFloat("NBVOTE"), 
				res.getInt("NOMBREETOILE"));
		return model;
	}
	
//	public static Signalement creerSignalementEvenement(ResultSet res) throws Exception{
//		Signalement model = new Signalement(
//				res.getInt("IDSIGNALEMENTEVENEMENT"), 
//				CommentaireDAO.getCommentaireEvenementById(res.getInt("IDCOMMENTAIRE")),
//				ProfilDAO.getProfilById(res.getInt("IDPROFIL")),
//				res.getString("CAUSE"));
//		return model;
//	}
	
//	public static Signalement creerSignalementLieu(ResultSet res) throws Exception{
//		Signalement model = new Signalement(
//				res.getInt("IDSIGNALEMENTLIEU"), 
//				CommentaireDAO.getCommentaireLieuById(res.getInt("IDCOMMENTAIRELIEU")),
//				ProfilDAO.getProfilById(res.getInt("IDPROFIL")),
//				res.getString("CAUSE"));
//		return model;
//	}
//	
//	public static Signalement creerSignalementCR(ResultSet res) throws Exception{
//		Signalement model = new Signalement(
//				res.getInt("IDSIGNALEMENTCR"), 
//				CommentaireDAO.getCommentaireLieuById(res.getInt("IDCOMMENTRECO")),
//				ProfilDAO.getProfilById(res.getInt("IDPROFIL")),
//				res.getString("CAUSE"));
//		return model;
//	}
	
	public static Recommandation creerRecommandation(ResultSet res) throws Exception{

		Recommandation model = new Recommandation(
				res.getInt("IDRECOMMANDATION"), 
				creerLieu(res),
				creerProfilRecommandation(res),
				res.getString("DESCRIPTIONRECO"),
				res.getString("IMAGERECO"));
		model.setEtoile(creerEtoile(res));
		return model;
	}
	public static Recommandation creerRecommandation(ResultSet res, Profil p) throws Exception{
		Recommandation model = new Recommandation(
				res.getInt("IDRECOMMANDATION"), 
				creerLieu(res),
				p,
				res.getString("DECRIPTIONRECO"),
				res.getString("IMAGERECO"));
		return model;
	}

}
