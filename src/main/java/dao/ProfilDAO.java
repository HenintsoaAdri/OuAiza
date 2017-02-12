package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import model.Profil;
import traitement.TraitementProfil;

public class ProfilDAO {
	
	public static Vector<Profil> getProfil(int offset) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String query = "SELECT * FROM LISTPROFIL LIMIT 10 OFFSET ?";
		PreparedStatement statement = conn.prepareStatement(query);
		try {
			statement.setInt(1, offset);
			return DBToProfil(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
	
	public static Profil getProfilById(int id) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTPROFIL WHERE IDPROFIL=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				return Creation.creerProfil(res);
			}
			throw new Exception("Ce profil est introuvable ou a \u00e9t\u00e9 retir\u00e9");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	public static Profil getProfilByIdentifiant(String identifiant) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		ResultSet res = null;
		String insertTableSQL = "SELECT * FROM LISTPROFIL WHERE IDENTIFIANT = ? ";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setString(1, identifiant);
			res = statement.executeQuery();
			if(res.next()){
				return Creation.creerProfil(res);
			}
			throw new Exception("Ce profil est introuvable ou a \u00e9t\u00e9 retir\u00e9");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(res!=null){
				res.close();
			}
			statement.close();
			conn.close();
		}
	}
	
	
	public static void insertProfil(Profil model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO PROFIL (IDREGION,NOMPROFIL,PRENOMPROFIL,DATENPROFIL,SEXEPROFIL,"
	    			+ "EMAILPROFIL,IDENTIFIANT,PASSWORDPROFIL,ADRESSEPROFIL,PHOTOPROFIL,ISCONFIRMED) "
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,FALSE)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, model.getRegion().getId());
			statement.setString(2, model.getNom());
			statement.setString(3, model.getPrenom());
			statement.setDate(4, Date.valueOf(model.getDateNaissance()));
			statement.setString(5, model.getSexe());
			statement.setString(6, model.getEmail());
			statement.setString(7, model.getIdentifiant());
			statement.setString(8, model.getPassword());
			statement.setString(9, model.getAdresse());
			statement.setString(10, model.getPhoto());
			statement.execute();
			TraitementProfil.sendMailConfirm(model.getEmail());
			con.commit();
		}
		catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw new Exception("Profil contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			con.close();
		}
	}
	public static void confirm(String mail) throws Exception{
		Connection con = UtilDB.getConnPostgre();
    	String req = "UPDATE PROFIL SET ISCONFIRMED = TRUE WHERE EMAILPROFIL = ?";
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setString(1, mail);
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
	public static Profil connexion(String email, String password) throws Exception {
		Connection con = UtilDB.getConnPostgre();
		String req = "SELECT * FROM LISTPROFIL WHERE EMAILPROFIL = ? AND PASSWORDPROFIL = ?";
		PreparedStatement statement = con.prepareStatement(req);
		ResultSet res = null;
		try {
			statement.setString(1, email);
			statement.setString(2, password);
			res = statement.executeQuery();
			if(res.next()){
				return Creation.creerProfil(res);
			}
			throw new Exception("Vos identifiants sont incorrects ou nous ne vous connaissons pas encore");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(res != null){
				res.close();
			}
			statement.close();
			con.close();
		}
	}
	static Vector<Profil> DBToProfil(ResultSet res)throws Exception{
		try{
			Vector<Profil> model = new Vector<Profil>();
			while(res.next()){
				model.add(Creation.creerProfil(res));
			}
			return model;
		}catch(Exception e){
			throw e;
		}finally {
			res.close();
		}
		
	}

	public static void modify(Profil p) throws Exception {
		Connection con = UtilDB.getConnPostgre();
    	String req = "UPDATE PROFIL SET NOMPROFIL = ?,"
    			+ "PRENOMPROFIL = ?,"
    			+ "DATENPROFIL = ?,"
    			+ "SEXEPROFIL = ?,"
    			+ "EMAILPROFIL = ?,"
    			+ "ADRESSEPROFIL = ?,"
    			+ "IDREGION = ?,"
    			+ "IDENTIFIANT = ?"
    			+ " WHERE IDPROFIL = ?";
		PreparedStatement statement = con.prepareStatement(req);
//			req = "INSERT INTO PROFILHISTORIQUE "
//            + "SELECT IDPROFIL, NOMPROFIL, PRENOMPROFIL, DATENPROFIL," 
//            + "SEXEPROFIL, EMAILPROFIL, PASSWORDPROFIL, PHOTOPROFIL, ADRESSEPROFIL, IDENTIFIANT"
//            + "FROM PROFIL WHERE IDPROFIL = ?";
//		PreparedStatement historique = con.prepareStatement(req);
		try{
//			historique.setInt(1, p.getId());
//			historique.execute();
			
			statement.setString(1, p.getNom());
			statement.setString(2, p.getPrenom());
			statement.setDate(3, Date.valueOf(p.getDateNaissance()));
			statement.setString(4, p.getSexe());
			statement.setString(5, p.getEmail());
			statement.setString(6, p.getAdresse());
			statement.setInt(7, p.getRegion().getId());
			statement.setString(8, p.getIdentifiant());
			statement.setInt(9, p.getId());
			statement.execute();
			con.commit();
			p.setRegion(LieuDAO.getRegion(p.getRegion().getId()));
		}
		catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			con.close();
		}
	}
	public static void modifyPhoto(Profil p, String lien) throws Exception {
		Connection con = UtilDB.getConnPostgre();
    	String req = "UPDATE PROFIL SET PHOTOPROFIL = ?"
    			+ " WHERE IDPROFIL = ?";
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setString(1, lien);
			statement.setInt(2, p.getId());
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
