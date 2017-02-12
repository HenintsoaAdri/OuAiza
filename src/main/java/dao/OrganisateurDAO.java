package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import model.Organisateur;

public class OrganisateurDAO {

	public OrganisateurDAO() {}
	public static Organisateur getOrganisateurById(int id) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTORGANISATEUR WHERE IDORGANISATEUR = ?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try{
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				Organisateur organisateur=Creation.creerOrganisateur(res);
				CommentaireDAO.getCommentaire(organisateur);
				EvenementDAO.getTopEvenement(organisateur);
				return organisateur;
			}
			throw new Exception("Aucun Organisateur trouv\u00e9");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			conn.close();
		}
	}
	
	public static Vector<Organisateur> getOrganisateur(int offset) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String insertTableSQL = "SELECT * FROM LISTORGANISATEUR LIMIT 10 OFFSET ?";
		PreparedStatement statement = conn.prepareStatement(insertTableSQL);
		try {
			statement.setInt(1, offset);
			return DBToOrganisateur(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}
        
        public static Vector<Organisateur> recherche(String nomOrganisateur, int offset) throws Exception{
            Connection conn = UtilDB.getConnPostgre();
            String insertTableSQL = "SELECT * FROM LISTORGANISATEUR WHERE UPPER(NOMORGANISATEUR) LIKE ? LIMIT 10 OFFSET ?";
            PreparedStatement statement = conn.prepareStatement(insertTableSQL);
            try {
                    statement.setString(1, "%"+nomOrganisateur.toUpperCase()+"%");
                    statement.setInt(2, offset);
                    return DBToOrganisateur(statement.executeQuery());
            } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
            }finally {
                statement.close();
                conn.close();
            }
        }
	
	public static void insertOrganisateur(Organisateur model) throws Exception{
            Connection con = UtilDB.getConnPostgre();
            con.setAutoCommit(false);
            String req = "INSERT INTO ORGANISATEUR (NOMORGANISATEUR,DESCRIPTIONORGANISATEUR,LOGOORGANISATEUR,CONTACTORGANISATEUR,MAILORGANISATEUR,ADRESSEORGANISATEUR,IDREGION,SITEWEBORGANISATEUR)"
                            + " VALUES (?,?)";

            PreparedStatement statement = con.prepareStatement(req);
            try{
                    statement.setString(1, model.getNom());
                    statement.setString(2, model.getDescription());
                    statement.setString(3, model.getLogo());
                    statement.setString(4, model.getContact());
                    statement.setString(5, model.getMail());
                    statement.setString(6, model.getAdresse());
                    statement.setInt(7, model.getRegion().getId());
                    statement.setString(8, model.getSiteWeb());
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
	
	public static Vector<Organisateur> DBToOrganisateur(ResultSet res) throws Exception{
		try {
			Vector<Organisateur> model = new Vector<Organisateur>();
			while(res.next()){
				model.add(Creation.creerOrganisateur(res));
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
