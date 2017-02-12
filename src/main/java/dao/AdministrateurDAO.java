package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import model.Administrateur;

public class AdministrateurDAO {

	public AdministrateurDAO() {}
	public Vector<Administrateur> getAdmministrateur() throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		Vector<Administrateur> model = new Vector<Administrateur>();
		Statement statement;
		String insertTableSQL = "SELECT * FROM ADMINISTRATEUR";
		try {
			statement = conn.createStatement();
			ResultSet res = statement.executeQuery(insertTableSQL);
			while(res.next()){
				model.add(Creation.creerAdministrateur(res));
			}
			return model;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public void insertPatient(Administrateur model) throws Exception{
	    	Connection con = UtilDB.getConnPostgre();
	    	String req = "INSERT INTO ADMINISTRATEUR (IDENTIFIANT,PASSWORD) VALUES (?,?)";
		
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setString(1, model.getIdentifiant());
			statement.setString(2, model.getPassword());
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
	public static Administrateur connexionAdmin(String identifiant, String password) throws Exception{
		Connection con = UtilDB.getConnPostgre();
		String req = "SELECT * FROM ADMINISTRATEUR WHERE IDENTIFIANT = ? AND PASSWORD = ?";
		PreparedStatement statement = con.prepareStatement(req);
		try{
			statement.setString(1, identifiant);
			statement.setString(2, password);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				return Creation.creerAdministrateur(res);
			}
			throw new Exception("Administrateur inconnu");
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			con.close();
		}
	}
}
