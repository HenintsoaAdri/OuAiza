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

import model.Organisateur;
import traitement.TraitementOrganisateur;

public class OrganisateurServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		if(req.getParameter("offset")!=null){
				try {
					Vector<Organisateur> vect = TraitementOrganisateur.getListeOrganisateur(Integer.parseInt(req.getParameter("offset")));
						JSONArray liste = new JSONArray();
						for(int i=0; i<vect.size();i++){
							liste.put(new JSONObject(vect.get(i)));
						}
						out.println(liste);
				} catch (Exception e) {
					e.printStackTrace();
					out.print(e.getMessage());
				}
		}else if(req.getParameter("get")!=null){
			try{
				Organisateur organisateur = TraitementOrganisateur.getOrganisateur(req.getParameter("get"));
				out.println(new JSONObject(organisateur));
			} catch(Exception e){
				e.printStackTrace();
				out.println(e.getMessage());
			}
		}
	}

}
