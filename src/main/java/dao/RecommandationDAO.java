package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import model.Profil;
import model.Recommandation;

public class RecommandationDAO {

	public static Vector<Recommandation> getRecommandation(int offset) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTRECOMMANDATION LIMIT 10 OFFSET ?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try {
			statement.setInt(1, offset);
			return DBToRecommandation(statement.executeQuery());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
	
	public static Recommandation getRecommandationById(int id) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTRECOMMANDATION WHERE IDRECOMMANDATION=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				Recommandation recommandation=Creation.creerRecommandation(res);
				CommentaireDAO.getCommentaire(recommandation);
				return recommandation;
			}
			throw new Exception("Aucune recommandation trouv\u00e9e");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static Vector<Recommandation> getRecommandationByLieu(int id) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTRECOMMANDATION WHERE IDLIEU=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, id);
			return DBToRecommandation(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void getRecommandationByProfil(Profil p) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTRECOMMANDATION WHERE IDPROFIL=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, p.getId());
			p.setRecommandation(DBToRecommandation(statement.executeQuery()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	public static Vector<Recommandation> getRecommandationByProfil(int idProfil) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTRECOMMANDATION WHERE IDPROFIL=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, idProfil);
			return DBToRecommandation(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertRecommandation(Recommandation model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO RECOMMANDATION (IDLIEU,IDPROFIL,DESCRIPTIONRECO,IMAGERECO) "
	    			+ "VALUES (?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, model.getLieu().getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getDescription());
			statement.setString(4, model.getImage());
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
	
	public static Vector<Recommandation> DBToRecommandation(ResultSet res) throws Exception{
		try{
			Vector<Recommandation> model = new Vector<Recommandation>();
			while(res.next()){
				model.add(Creation.creerRecommandation(res));
			}
			return model;
		}catch(Exception e){
			throw e;
		}finally {
			res.close();
		}
		
	}
}
