package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Vector;

import model.DetailHoraire;
import model.Lieu;
import model.LieuRetire;
import model.Region;

public class LieuDAO {

	public static void insertLieu(Lieu model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	String req = "INSERT INTO HORAIRE(OUVERTURE, PAUSEDEBUT, PAUSEFIN, FERMETURE, JOUR)"
	    			+ " VALUES(?,?,?,?,?)";
	    	PreparedStatement horaire = con.prepareStatement(req);
	    			req = "INSERT INTO LIEU (IDREGION, NOMLIEU, ADRESSELIEU, LATITUDE, LONGITUDE, DESCRIPTIONLIEU, PRIXENTREELIEU, CONTACTLIEU, SITEWEBLIEU, MAILLIEU, LOGOLIEU) "
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	    	PreparedStatement statement = con.prepareStatement(req);
	    			req = "INSERT INTO HORAIRE_LIEU(IDHORAIRE,IDLIEU) VALUES(CURRVAL('horaire_idhoraire_seq'),CURRVAL('lieu_idlieu_seq'))";
	    	Statement stmt = con.createStatement();
		try{
			statement.setInt(1, model.getRegion().getId());
			statement.setString(2, model.getNom());
			statement.setString(3, model.getAdresse());
                        statement.setFloat(4, model.getPosition()[0]);
                        statement.setFloat(5, model.getPosition()[1]);
			statement.setString(6, model.getDescription());
			statement.setDouble(7, model.getPrixEntree());
			statement.setString(8, model.getContact());
			statement.setString(9, model.getSiteWeb());
			statement.setString(10, model.getMail());
			statement.setString(11, model.getLogo());
			statement.execute();
			for(DetailHoraire d : model.getHoraire().getAllHoraire()){
				d.autoSetPause();
				horaire.setTime(1,Time.valueOf(d.getOuverture()));
				horaire.setTime(2, Time.valueOf(d.getPauseDebut()));
				horaire.setTime(3, Time.valueOf(d.getPauseFin()));
				horaire.setTime(4, Time.valueOf(d.getFermeture()));
				horaire.setInt(5, d.getJour().getValue());
				horaire.execute();
				stmt.execute(req);
			}		
			con.commit();
		}
		catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			stmt.close();
			horaire.close();
			statement.close();
			con.close();
		}
	}
	public static void retirer(LieuRetire lieu) throws Exception{
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "INSERT INTO LIEURETIRE(IDLIEU, IDADMINISTRATEUR, DATERETIRE, REMARQUE)"
				+ " VALUES (?,?,CURRENT_DATE,?)";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try {
			statement.setInt(1, lieu.getId());
			statement.setInt(2, lieu.getAdministrateur().getId());
			statement.setString(3, lieu.getRemarque());
			conn.commit();
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(statement!=null){
				statement.close();
			}
			conn.close();
		}
	}
	public static void restaurer(LieuRetire lieu) throws Exception{
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "DELETE LIEURETIRE WHERE IDLIEU = ?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try {
			statement.setInt(1, lieu.getId());
			conn.commit();
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(statement!=null){
				statement.close();
			}
			conn.close();
		}
	}
	public static Vector<Lieu> getLieu(int offset) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTLIEU LIMIT 10 OFFSET ?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL); 
		try {
			statement.setInt(1, offset);
			return dbToLieu(statement.executeQuery());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(statement!=null){
				statement.close();
			}
			conn.close();
		}
	}
	
	public static Lieu getLieuById(int id) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTLIEU WHERE IDLIEU=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				Lieu lieu=Creation.creerLieu(res);
				getDetailLieu(lieu);
				getHoraireLieu(lieu);
				EvenementDAO.getTopEvenement(lieu);
				CommentaireDAO.getCommentaire(lieu);
				return lieu;
			}
			throw new Exception("\u00c9v\u00e9nement introuvable");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}

	public static Vector<LieuRetire> getLieuRetire() throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTLIEURETIRE";
		Statement statement = conn.createStatement();
		try{
			return dbToLieuRetire(statement.executeQuery(insertTableSQL));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
	
	public static void getDetailLieu(Lieu lieu) throws Exception{
		Connection conn = UtilDB.getConnPostgre();
		String query = "SELECT * FROM GALERIELIEU WHERE IDLIEU = ?";
		PreparedStatement statement = conn.prepareStatement(query);
			query = "SELECT * FROM MENU WHERE IDLIEU = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet res = null;
		try{
			statement.setInt(1, lieu.getId());
			res = statement.executeQuery();
			Vector<String> vect = new Vector<String>();
			while(res.next()){
				vect.add(res.getString("IMAGE"));
			}
			lieu.setGalerie(vect);
			res.close();
			stmt.setInt(1, lieu.getId());
			res = stmt.executeQuery();
			vect = new Vector<String>();
			while (res.next()) {
				vect.add(res.getString("PHOTOMENU"));
			}
			lieu.setMenu(vect);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			res.close();
			statement.close();
			conn.close();
		}
	}
	public static Vector<Lieu> rechercheLieu(String nom, int region, int prixMin, int prixMax, Boolean ouvert, int offset) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		LocalDateTime now = LocalDateTime.now();
		String query = "SELECT * FROM LISTLIEU L WHERE";
		if(ouvert)query += " EXISTS ("
				+ "SELECT * FROM LISTHORAIRE WHERE JOUR = ? "
				+ "AND OUVERTURE<= ? AND PAUSEDEBUT>= ? "
				+ "OR PAUSEFIN<= ? AND FERMETURE >= ?"
				+ ") AND";
		 query += " UPPER(L.NOMLIEU) LIKE ? ";
		 if(region > 0)query += "AND L.IDREGION = ? ";
		 query += "AND L.PRIXENTREELIEU BETWEEN ? AND ? "
				+ "LIMIT 10 OFFSET ?";
		 PreparedStatement statement = conn.prepareStatement(query); 
			try {
				int i = 1;
				if(ouvert){
					statement.setInt(i++, now.getDayOfWeek().getValue());
					statement.setTime(i++, Time.valueOf(now.toLocalTime()));
					statement.setTime(i++, Time.valueOf(now.toLocalTime()));
					statement.setTime(i++, Time.valueOf(now.toLocalTime()));
					statement.setTime(i++, Time.valueOf(now.toLocalTime()));
				}
				statement.setString(i++, "%"+nom.toUpperCase()+"%");
				if(region > 0)statement.setInt(i++, region);
				statement.setInt(i++, prixMin);
				statement.setInt(i++, prixMax);
				statement.setInt(i++, offset);
				return dbToLieu(statement.executeQuery());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				if(statement!=null){
					statement.close();
				}
				conn.close();
			}
	}public static Vector<Lieu> recherche(String nom) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String query = "SELECT * FROM LISTLIEU L WHERE UPPER(L.NOMLIEU) LIKE ? ";
		 PreparedStatement statement = conn.prepareStatement(query); 
			try {
				statement.setString(1, "%"+nom.toUpperCase()+"%");
				return dbToLieu(statement.executeQuery());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				if(statement!=null){
					statement.close();
				}
				conn.close();
			}
	}
	
	public static void insertRegion(Region region) throws Exception {
		Connection con = UtilDB.getConnPostgre();
    	con.setAutoCommit(false);
    	String req = "INSERT INTO REGION(REGION, IMAGEREGION) VALUES (?,?)";
	
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setString(1, region.getRegion());
			statement.setString(2, region.getImageRegion());
			statement.execute();
			con.commit();
		}
		catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			con.close();
		}
	}
	public static Vector<Region> getRegion()throws Exception{
		Connection conn = UtilDB.getConnPostgre();
		Vector<Region> model = new Vector<Region>();
		String query = "SELECT * FROM REGION";
		Statement statement = conn.createStatement();
		try{
			ResultSet res = statement.executeQuery(query);
			while(res.next()){
				model.addElement(Creation.creerRegion(res));;
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	public static Region getRegion(int idRegion)throws Exception{
		Connection conn = UtilDB.getConnPostgre();
		String query = "SELECT * FROM REGION WHERE IDREGION = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		try{
			statement.setInt(1,idRegion);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				return Creation.creerRegion(res);
			}
			throw new Exception("R\u00e9gion introuvable");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
	
	public static void getHoraireLieu(Lieu lieu) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTHORAIRE WHERE IDLIEU=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, lieu.getId());
			lieu.setHoraire(Creation.createHoraire(statement.executeQuery()));;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
	
	public static Vector<Lieu> dbToLieu(ResultSet res) throws Exception{
		try {
			Vector<Lieu> model = new Vector<Lieu>();
			while(res.next()){
				model.add(Creation.creerLieu(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			res.close();
		}
	}
	public static Vector<LieuRetire> dbToLieuRetire(ResultSet res) throws Exception{
		try {
			Vector<LieuRetire> model = new Vector<LieuRetire>();
			while(res.next()){
				model.add(Creation.creerLieuRetire(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			res.close();
		}
	}
}
