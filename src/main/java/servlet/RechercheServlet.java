package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Evenement;
import model.Lieu;
import model.Profil;
import traitement.Traitement;
import traitement.TraitementEvenement;
import traitement.TraitementLieu;
import traitement.TraitementOrganisateur;
import traitement.TraitementProfil;
import traitement.TraitementRecommandation;

public class RechercheServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();
		try{
			String recherche = req.getParameter("recherche");
			String type = req.getParameter("type");
			String typeRecherche = req.getParameter("typeRecherche");
			switch (typeRecherche) {
			case "rechercheOffset":
				
                        switch(type){
                        case "evenement" :
                                Vector<Evenement> vect = TraitementEvenement.recherche(recherche, 0);
                                JSONArray liste = new JSONArray();
                                for(int i=0; i<vect.size();i++){
                                        liste.put(new JSONObject(vect.get(i)));
                                }
                                out.println(liste);
                                break;
//				case "organisateur":
//					TraitementOrganisateur.commenter(commentaire, idModel, dateHeure, p);
//					break;
                        case "lieu":
                                try {
                                        Vector<Lieu> ltlieu = TraitementLieu.recherche(recherche, 0);
                                                JSONArray listeLieu = new JSONArray();
                                                for(int i=0; i<ltlieu.size();i++){
                                                        listeLieu.put(new JSONObject(ltlieu.get(i)));
                                                }
                                                out.println(listeLieu);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                        out.print(e.getMessage());
                                }
                                break;
//				case "recommandation":
//					TraitementRecommandation.commenter(commentaire, idModel, dateHeure, p);
//					break;
						}
				break;
				
			case "rechercheAll":
                            switch(type){	
                            case "evenement" :
                                    Vector<Evenement> vect = TraitementEvenement.recherche(recherche);
                                    JSONArray liste = new JSONArray();
                                    for(int i=0; i<vect.size();i++){
                                            liste.put(new JSONObject(vect.get(i)));
                                    }
                                    out.println(liste);
                                    break;
//				case "organisateur":
//					TraitementOrganisateur.commenter(commentaire, idModel, dateHeure, p);
//					break;
                            case "lieu":
                                    try {
                                            Vector<Lieu> ltlieu = TraitementLieu.recherche(recherche);
                                                    JSONArray listeLieu = new JSONArray();
                                                    for(int i=0; i<ltlieu.size();i++){
                                                            listeLieu.put(new JSONObject(ltlieu.get(i)));
                                                    }
                                                            out.println(listeLieu);
                                    } catch (Exception e) {
                                            e.printStackTrace();
                                            out.print(e.getMessage());
                                    }
                                    break;
//				case "recommandation":
//					TraitementRecommandation.commenter(commentaire, idModel, dateHeure, p);
//					break;
                        }
				break;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print(e.getMessage());
		} finally {
			out.close();
		}

	}

}
