package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Etoile;
import model.Evenement;
import model.Lieu;
import model.Note;
import model.Organisateur;
import model.Recommandation;

public class EtoileDAO {

	public EtoileDAO() {
	}
	//======================================= ETOILE EVENEMENT ==============================================
	public static Vector<Etoile> getEtoile(Evenement evenement) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		Vector<Etoile> model = new Vector<Etoile>();
		String insertTableSQL = "SELECT * FROM ETOILEEVENEMENT WHERE IDEVENEMENT=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, evenement.getId());
			ResultSet res = statement.executeQuery();
			while(res.next()){
				model.add(Creation.creerEtoile(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertEtoile(Note model,Evenement type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO ETOILEEVENEMENT (IDEVENEMENT,IDPROFIL,NOMBREETOILEEVEN) VALUES (?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setInt(3, model.getNombreEtoile());
			statement.execute();
			con.commit();
		} catch(SQLException sqlException){
			if(sqlException.getSQLState().compareTo("23505") == 0){
				try{
					con.rollback();
					req = "UPDATE ETOILEEVENEMENT SET NOMBREETOILEEVEN = ? WHERE IDEVENEMENT = ? AND IDPROFIL = ?";
					statement = con.prepareStatement(req);
					statement.setInt(1, model.getNombreEtoile());
					statement.setInt(2, type.getId());
					statement.setInt(3, model.getProfil().getId());
					statement.execute();
					con.commit();
				}catch(Exception e){
					con.rollback();
					e.printStackTrace();
					throw e;
				}
			}else throw sqlException;
		} catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			con.close();
		}
	}
	
	//======================================= ETOILE LIEU ==============================================
	public static Vector<Etoile> getEtoile(Lieu lieu) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		Vector<Etoile> model = new Vector<Etoile>();
		String insertTableSQL = "SELECT * FROM ETOILELIEU WHERE IDLIEU=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, lieu.getId());
			ResultSet res = statement.executeQuery();
			while(res.next()){
				model.add(Creation.creerEtoile(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertEtoile(Note model,Lieu type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO ETOILELIEU (IDLIEU,IDPROFIL,NOMBREETOILELIEU) VALUES (?,?,?)";
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setInt(3, model.getNombreEtoile());
			statement.execute();
			con.commit();
		} catch(SQLException sqlException){
			if(sqlException.getSQLState().compareTo("23505") == 0){
				try{
					con.rollback();
					req = "UPDATE ETOILELIEU SET NOMBREETOILELIEU = ? WHERE IDLIEU = ? AND IDPROFIL = ?";
					statement = con.prepareStatement(req);
					statement.setInt(1, model.getNombreEtoile());
					statement.setInt(2, type.getId());
					statement.setInt(3, model.getProfil().getId());
					statement.execute();
					con.commit();
				}catch(Exception e){
					con.rollback();
					e.printStackTrace();
					throw e;
				}
			}else throw sqlException;
		} catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			con.close();
		}
	}
	
	//======================================= ETOILE RECOMMANDATION ==============================================
	public static Vector<Etoile> getEtoile(Recommandation r) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		Vector<Etoile> model = new Vector<Etoile>();
		String insertTableSQL = "SELECT * FROM ETOILERECO WHERE IDRECOMMANDATION=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, r.getId());
			ResultSet res = statement.executeQuery();
			while(res.next()){
				model.add(Creation.creerEtoile(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertEtoile(Note model,Recommandation type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO ETOILERECO (IDRECOMMANDATION,IDPROFIL,NOMBREETOILERECO) VALUES (?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setInt(3, model.getNombreEtoile());
			statement.execute();
			con.commit();
		}catch(SQLException sqlException){
			if(sqlException.getSQLState().compareTo("23505") == 0){
				try{
					con.rollback();
					req = "UPDATE ETOILERECO SET NOMBREETOILERECO = ? WHERE IDRECOMMANDATION = ? AND IDPROFIL = ?";
					statement = con.prepareStatement(req);
					statement.setInt(1, model.getNombreEtoile());
					statement.setInt(2, type.getId());
					statement.setInt(3, model.getProfil().getId());
					statement.execute();
					con.commit();
				} catch(Exception e){
					con.rollback();
					e.printStackTrace();
					throw e;
				}
			} else throw sqlException;
		} catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			con.close();
		}
	}	
	//======================================= ETOILE ORGANISATEUR ==============================================
	public static Vector<Etoile> getEtoile(Organisateur o) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		Vector<Etoile> model = new Vector<Etoile>();
		String insertTableSQL = "SELECT * FROM ETOILEORGANISATEUR WHERE IDORGANISATEUR=?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, o.getId());
			ResultSet res = statement.executeQuery();
			while(res.next()){
				model.add(Creation.creerEtoile(res));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static void insertEtoile(Note model,Organisateur type) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	con.setAutoCommit(false);
	    	String req = "INSERT INTO ETOILEORGANISATEUR (IDORGANISATEUR,IDPROFIL,NOMBREETOILEORG) VALUES (?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setInt(1, type.getId());
			statement.setInt(2, model.getProfil().getId());
			statement.setInt(3, model.getNombreEtoile());
			statement.execute();
			con.commit();
		}catch(SQLException sqlException){
			if(sqlException.getSQLState().compareTo("23505") == 0){
				try{
					con.rollback();
					req = "UPDATE ETOILEORGANISATEUR SET NOMBREETOILEORG = ? WHERE IDORGANISATEUR = ? AND IDPROFIL = ?";
					statement = con.prepareStatement(req);
					statement.setInt(1, model.getNombreEtoile());
					statement.setInt(2, type.getId());
					statement.setInt(3, model.getProfil().getId());
					statement.execute();
					con.commit();
				} catch(Exception e){
					con.rollback();
					e.printStackTrace();
					throw e;
				}
			} else throw sqlException;
		} catch(Exception e){
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			con.close();
		}
	}
}
