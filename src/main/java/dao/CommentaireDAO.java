package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

import model.*;

public class CommentaireDAO {
	
	//======================================= COMMENTAIRE EVENEMENT ==============================================
//	public static Commentaire getCommentaireEvenementById(int id) throws Exception {
//		Connection conn = UtilDB.getConnPostgre();
//		Commentaire model = new Commentaire();
//		String insertTableSQL = "SELECT * FROM COMMENTAIREEVENEMENT WHERE IDCOMMENTAIRE=?";
//		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
//		try{
//			statement.setInt(1, id);
//			ResultSet res = statement.executeQuery();
//			while(res.next()){
//				model=Creation.creerCommentaireEvenement(res);
//			}
//			conn.commit();
//			return model;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			conn.close();
//		}
//	}
	
	public static void getCommentaire(Evenement evenement) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTCOMMENTAIREEVENEMENT WHERE IDEVENEMENT=? ORDER BY DATEHEURECOMMENTAIRE DESC";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, evenement.getId());
			evenement.setCommentaire(DBToCommentaire(statement.executeQuery()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public  static void insertCommentaire(Commentaire model,Evenement type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO COMMENTAIREEVENEMENT (IDEVENEMENT,IDPROFIL,COMMENTAIREEVENEMENT,DATEHEURECOMMENTAIRE)"
	    			+ " VALUES (?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getCommentaire());
			statement.setTimestamp(4, Timestamp.valueOf(model.getDateHeure()));
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
	
	//======================================= COMMENTAIRE LIEU ==============================================
//	public static Commentaire getCommentaireLieuById(int id) throws Exception {
//		Connection conn = UtilDB.getConnPostgre();
//		Commentaire model = new Commentaire();
//		String insertTableSQL = "SELECT * FROM COMMENTAIRELIEU WHERE IDCOMMENTAIRELIEU=?";
//		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
//		try{
//			statement.setInt(1, id);
//			ResultSet res = statement.executeQuery();
//			while(res.next()){
//				model=Creation.creerCommentaireEvenement(res);
//			}
//			conn.commit();
//			return model;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			conn.close();
//		}
//	}
	
	public static void getCommentaire(Lieu lieu) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTCOMMENTAIRELIEU WHERE IDLIEU=? ORDER BY DATEHEURECOMMENTAIRE DESC";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, lieu.getId());
			lieu.setCommentaire(DBToCommentaire(statement.executeQuery()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertCommentaire(Commentaire model,Lieu type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO COMMENTAIRELIEU (IDLIEU,IDPROFIL,COMMENTAIRELIEU,DATEHEURECOMMENTAIRE)"
	    			+ " VALUES (?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getCommentaire());
			statement.setTimestamp(4, Timestamp.valueOf(model.getDateHeure()));
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
	
	//======================================= COMMENTAIRE RECOMMANDATION ==============================================
//	public static Commentaire getCommentaireRecoById(int id) throws Exception {
//		Connection conn = UtilDB.getConnPostgre();
//		Commentaire model = new Commentaire();
//		String insertTableSQL = "SELECT * FROM COMMENTAIRERECO WHERE IDCOMMENTRECO=?";
//		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
//		try{
//			statement.setInt(1, id);
//			ResultSet res = statement.executeQuery();
//			while(res.next()){
//				model=Creation.creerCommentaireEvenement(res);
//			}
//			conn.commit();
//			return model;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			conn.close();
//		}
//	}
	
	public static void getCommentaire(Recommandation reco) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTCOMMENTAIRERECOMMANDATION WHERE IDRECOMMANDATION=? ORDER BY DATEHEURECOMMENTAIRE DESC";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, reco.getId());
			reco.setCommentaire(DBToCommentaire(statement.executeQuery()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertCommentaire(Commentaire model,Recommandation type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO COMMENTAIRERECO (IDRECOMMANDATION,IDPROFIL,COMMENTAIRERECO,DATEHEURECOMMENTAIRE)"
	    			+ " VALUES (?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getCommentaire());
			statement.setTimestamp(3,Timestamp.valueOf(model.getDateHeure()));
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

	public static void getCommentaire(Organisateur o) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTCOMMENTAIREORGANISATEUR WHERE IDORGANISATEUR=? ORDER BY DATEHEURECOMMENTAIRE DESC";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, o.getId());
			o.setCommentaire(DBToCommentaire(statement.executeQuery()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertCommentaire(Commentaire model,Organisateur type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO COMMENTAIREORGANISATEUR (IDORGANISATEUR,IDPROFIL,COMMENTAIREORGANISATEUR,DATEHEURECOMMENTAIRE)"
	    			+ " VALUES (?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getCommentaire());
			statement.setTimestamp(4, Timestamp.valueOf(model.getDateHeure()));
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
	
	public static Vector<Commentaire> DBToCommentaire(ResultSet res) throws Exception{
		try {
			Vector<Commentaire> model = new Vector<Commentaire>();
			while(res.next()){
				model.add(Creation.creerCommentaire(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			res.close();
		}
		
	}
}
