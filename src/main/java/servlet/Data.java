package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import org.json.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Region;
import traitement.TraitementLieu;
import traitement.TraitementProfil;

public class Data extends HttpServlet {
	
        @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter(); 
		if (req.getParameterValues("get")!=null) {
			try {
				Vector<Region> vectregion = TraitementLieu.getRegion();
				switch(req.getParameter("get")){
				case "region" :
					JSONArray ltregion = new JSONArray();
					for(int i=0; i<vectregion.size();i++){
						ltregion.put(new JSONObject(vectregion.get(i)));
					}
					out.println(ltregion);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
        @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter(); 
		try {
			TraitementProfil.inscription(req.getParameter("nomregion"), 
					req.getParameter("nom"), 
					req.getParameter("prenom"), 
					req.getParameter("datenaissance"), 
					req.getParameter("sexe"), 
					req.getParameter("email"), 
					req.getParameter("password"), 
					req.getParameter("confirmpassword"), 
					req.getParameter("adresse"));
			out.println(req.getParameter("nom"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
