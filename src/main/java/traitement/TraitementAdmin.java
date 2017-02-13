package traitement;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.*;
import model.*;

public class TraitementAdmin {

	public static void connexion(String identifiant, String password, HttpSession session, HttpServletResponse response) throws Exception{
		Administrateur a = AdministrateurDAO.connexionAdmin(identifiant, password);
		session.setAttribute("Admin", a);
		response.sendRedirect("index.jsp");
	}
}
