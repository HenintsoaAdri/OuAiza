package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Vector;

import model.*;

public class EvenementDAO {
	
	public static Evenement getEvenementById(int id) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTEVENEMENT WHERE IDEVENEMENT=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				Evenement evenement=Creation.creerEvenement(res);
				CommentaireDAO.getCommentaire(evenement);
				return evenement;
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

	public static Vector<Evenement> getEvenement(int offset) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTEVENEMENT LIMIT 10 OFFSET ?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try {
			statement.setInt(1, offset);
			return DBToEvenement(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
	public static void getTopEvenement(Lieu l) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTEVENEMENT WHERE IDLIEU = ? ORDER BY DATEDEBUTEVENEMENT LIMIT 3";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try {
			statement.setInt(1, l.getId());
			l.setTop3(DBToEvenement(statement.executeQuery()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
	public static void getTopEvenement(Organisateur o) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTEVENEMENT WHERE IDORGANISATEUR = ? ORDER BY DATEDEBUTEVENEMENT LIMIT 3";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try {
			statement.setInt(1, o.getId());
			o.setTop3(DBToEvenement(statement.executeQuery(),o));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}	
	public static void insertEvenement(Evenement model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO EVENEMENT (IDLIEU,IDORGANISATEUR,NOMEVENEMENT,DATEDEBUTEVENEMENT,DATEFINEVENEMENT,DESCRIPTIONEVNT,PRIXENTREEEVNT,CONDITION,AUTREINFO,AFFICHE) "
	    			+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, model.getLieu().getId());
			statement.setInt(2, model.getOrganisateur().getId());
			statement.setString(3, model.getNom());
			statement.setTimestamp(4, Timestamp.valueOf(model.getDateDebutEvenement()));
			statement.setTimestamp(5, Timestamp.valueOf(model.getDateFinEvenement()));
			statement.setString(6, model.getDescription());
			statement.setDouble(7, model.getPrixEntree());
			statement.setString(8, model.getCondition());
			statement.setString(9, model.getAutreInfo());
			statement.setString(10, model.getAffiche());
			statement.execute();
			con.commit();
		}
		catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			con.close();
		}
	}
	public static Vector<Evenement> DBToEvenement(ResultSet res) throws Exception{
		try {
			Vector<Evenement> model = new Vector<Evenement>();
			while(res.next()){
				model.add(Creation.creerEvenement(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			res.close();
		}
		
	}
	public static Vector<Evenement> DBToEvenement(ResultSet res, Organisateur o) throws Exception{
		try {
			Vector<Evenement> model = new Vector<Evenement>();
			while(res.next()){
				model.add(Creation.creerEvenement(res,o));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			res.close();
		}
		
	}
	public static Vector<Evenement> rechercheEvenement(String nom, String lieu, String organisateur, int prixMin, int prixMax, LocalDate dateMin, LocalDate dateMax, int offset) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String query = "SELECT * FROM LISTEVENEMENT WHERE  UPPER(NOMEVENEMENT) "
				+ "LIKE ? AND  UPPER(NOMLIEU) LIKE ? AND  UPPER(NOMORGANISATEUR) LIKE ? "
				+ "AND PRIXENTREEEVENEMENT BETWEEN ? AND ? AND DATEDEBUTEVENEMENT BETWEEN ? AND ? "
				+ "LIMIT 10 OFFSET ?";
		 PreparedStatement statement = conn.prepareStatement(query); 
			try {
				int i = 1;
				statement.setString(i++, "%"+nom.toUpperCase()+"%");
				statement.setString(i++, "%"+lieu.toUpperCase()+"%");
				statement.setString(i++, "%"+organisateur.toUpperCase()+"%");
				statement.setInt(i++, prixMin);
				statement.setInt(i++, prixMax);
				statement.setDate(i++, Date.valueOf(dateMin));
				statement.setDate(i++, Date.valueOf(dateMax));
				statement.setInt(i++, offset);
				return DBToEvenement(statement.executeQuery());
				
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

}
