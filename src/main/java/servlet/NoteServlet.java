package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profil;
import traitement.*;

public class NoteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Profil p = (Profil)req.getSession().getAttribute("Profil");
		PrintWriter out = resp.getWriter();
		if(p != null){			
			String idModel = req.getParameter("idModel");
			int note = Integer.parseInt(req.getParameter("note"));
			try{
				switch(req.getParameter("type")){
					case "evenement" :
						TraitementEvenement.noter(note, idModel, p);
						break;
					case "organisateur":
						TraitementOrganisateur.noter(note, idModel, p);
						break;
					case "lieu":
						TraitementLieu.noter(note, idModel, p);
						break;
					case "recommandation":
						TraitementRecommandation.noter(note, idModel, p);
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.print(e.getMessage());
			}
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Headers", "Authorization");
	}
}
