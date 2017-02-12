package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Signalement;

public class SignalementDAO {

	public SignalementDAO() {}
	//======================================= SIGNALEMENT EVENEMENT ==============================================
//	public Vector<Signalement> getSignalementEvenement(int ideve) throws Exception {
//		Connection conn = UtilDB.getConnPostgre();
//		Vector<Signalement> model = new Vector<Signalement>();
//		String insertTableSQL = "SELECT * FROM SIGNALEMENTEVENEMENT WHERE IDCOMMENTAIRE=?";
//		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
//		try{
//			statement.setInt(1, ideve);
//			ResultSet res = statement.executeQuery();
//			while(res.next()){
//				model.add(Creation.creerSignalementEvenement(res));
//			}
//			return model;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			conn.close();
//		}
//	}
	
	public void insertSignalementEvenement(Signalement model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO SIGNALEMENTEVENEMENT (IDCOMMENTAIRE,IDPROFIL,CAUSE) VALUES (?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, model.getCommentaire().getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getCause());
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
	
	//======================================= SIGNALEMENT LIEU ==============================================
//	public Vector<Signalement> getSignalementLieu(int ideve) throws Exception {
//		Connection conn = UtilDB.getConnPostgre();
//		Vector<Signalement> model = new Vector<Signalement>();
//		String insertTableSQL = "SELECT * FROM SIGNALEMENTLIEU WHERE IDCOMMENTAIRELIEU=?";
//		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
//		try{
//			statement.setInt(1, ideve);
//			ResultSet res = statement.executeQuery();
//			while(res.next()){
//				model.add(Creation.creerSignalementLieu(res));
//			}
//			return model;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			conn.close();
//		}
//	}
	
	public void insertSignalementLieu(Signalement model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO SIGNALEMENTLIEU (IDCOMMENTAIRELIEU,IDPROFIL,CAUSE) VALUES (?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, model.getCommentaire().getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getCause());
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
	
	//======================================= SIGNALEMENT COMMENTAIRE RECO ==============================================
//	public Vector<Signalement> getSignalementCommentaireReco(int ideve) throws Exception {
//		Connection conn = UtilDB.getConnPostgre();
//		Vector<Signalement> model = new Vector<Signalement>();
//		String insertTableSQL = "SELECT * FROM SIGNALEMENTCOMMRECO WHERE IDCOMMENTRECO=?";
//		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
//		try{
//			statement.setInt(1, ideve);
//			ResultSet res = statement.executeQuery();
//			while(res.next()){
//				model.add(Creation.creerSignalementCR(res));
//			}
//			return model;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			conn.close();
//		}
//	}
	
	public void insertSignalementCommentaireReco(Signalement model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO SIGNALEMENTCOMMRECO (IDCOMMENTAIRERECO,IDPROFIL,CAUSE) VALUES (?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, model.getCommentaire().getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setString(3, model.getCause());
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
	
}
