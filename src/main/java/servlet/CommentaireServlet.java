package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profil;
import traitement.*;

public class CommentaireServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();
		try{
			String dateHeure = req.getParameter("dateHeure");
			String idModel = req.getParameter("idModel");
			String commentaire = req.getParameter("commentaire");
			String type = req.getParameter("type");
			Profil p = (Profil)req.getSession().getAttribute("Profil");
			try {
				p = TraitementProfil.checkToken(Traitement.extractToken(req));
			} catch (Exception e) {e.printStackTrace();}
			if(p != null){
				switch(type){
					case "evenement" :
						TraitementEvenement.commenter(commentaire, idModel, dateHeure, p);
						break;
					case "organisateur":
						TraitementOrganisateur.commenter(commentaire, idModel, dateHeure, p);
						break;
					case "lieu":
						TraitementLieu.commenter(commentaire, idModel, dateHeure, p);
						break;
					case "recommandation":
						TraitementRecommandation.commenter(commentaire, idModel, dateHeure, p);
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print(e.getMessage());
		} finally {
			out.close();
		}

	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Headers", "Authorization");
	}
}
