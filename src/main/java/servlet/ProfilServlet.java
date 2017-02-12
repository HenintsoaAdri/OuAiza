package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.Profil;
import traitement.TraitementProfil;

public class ProfilServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		if(req.getParameter("identifiant")!=null){
				try {
					Profil p = TraitementProfil.getProfil(req.getParameter("identifiant"));
					JSONObject profil = new JSONObject(p);
						out.println(profil);
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
