package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

import dao.ProfilDAO;
import model.Profil;
import traitement.Traitement;
public class LoginTokenServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		try {
			Profil p = ProfilDAO.connexion(email, password);
			if(!p.isConfirmed()) throw new Exception("Compte non activ\u00e9 ! Veuillez v\u00e9rifier votre bo\u00eete de messagerie");
			
			Builder builder = JWT.create();
			
			builder.withIssuedAt(Date.valueOf(LocalDate.now()));
			builder.withClaim("identifiant", p.getIdentifiant());
			builder.withClaim("nom", p.getNom());
			builder.withClaim("prenom", p.getPrenom());
			builder.withClaim("dateNaissance", Date.valueOf(p.getDateNaissance()));
			builder.withClaim("sexe", p.getSexe());
			builder.withClaim("photo", p.getPhoto());
			builder.withClaim("email", p.getEmail());
			
			builder.withExpiresAt(Timestamp.valueOf(LocalDateTime.now().plusHours(1)));
			builder.withIssuer(Traitement.getURL());
			
			String token = builder.sign(Algorithm.HMAC256(Traitement.getSignature()));
			
			JSONObject profil = new JSONObject("{ \"token\" :"+token+"}");
			out.print(profil);
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
	
}
