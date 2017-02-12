package traitement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Vector;

import javax.mail.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import dao.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.*;
import utilitaire.StringUtil;

public class TraitementProfil {

	public static void inscription(String region, String nom, String prenom, String dateNaissance, String sexe, String email, String password,String confirmpassword, String adresse)throws Exception{
		try {
			Profil p = new Profil();
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setDateNaissance(dateNaissance);
			p.setSexe(sexe);
			p.setEmail(email);
			p.setPassword(password, confirmpassword);
			p.setAdresse(adresse);
			Region r = new Region();
			r.setId(Integer.parseInt(region));
			p.setRegion(r);
			ProfilDAO.insertProfil(p);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new Exception("Veuillez remplir enti\u00e8rement le formulaire pour pouvoir vous inscrire !");
		} catch (NumberFormatException e){
			e.printStackTrace();
			throw new Exception("Veuillez s\u00e9lectionner une r\u00e9gion");
		}	
	}
	public static void connexion(String email, String password, HttpSession session, HttpServletResponse response) throws Exception{
		Profil p = ProfilDAO.connexion(email, password);
		if(!p.isConfirmed()) throw new Exception("Compte non activ\u00e9; ! Veuillez v\u00e9rifier votre bo\u00eete de messagerie");
		session.setAttribute("Profil", p);
		response.sendRedirect("index.jsp");
	}
	public static Profil checkToken(String token)throws Exception{
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Traitement.getSignature()))
							        .withIssuer(Traitement.getURL())
							        .build(); 
			verifier.verify(token);
		    JWT jwt = JWT.decode(token);
		    return getProfil(jwt.getClaim("identifiant").asString());
		} catch (JWTDecodeException e){
		    throw e;
		}  catch (JWTVerificationException e){
		    throw e;
		}
	}
	public static void modifier(Profil p, String nom, String prenom, String identifiant, String adresse, String email, String sexe, String dateNaissance, String region) throws Exception {
		if(p != null){
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setDateNaissance(dateNaissance);
			p.setSexe(sexe);
			p.setEmail(email);
			p.setIdentifiant(identifiant);
			p.setAdresse(adresse);
			try {
				Region r = new Region();
				r.setId(Integer.parseInt(region));
				p.setRegion(r);
			} catch (Exception e) {}
			ProfilDAO.modify(p);
		}
	}
	public static void modifierPhoto(Profil p, String lien) throws Exception {
		if(p != null){
			ProfilDAO.modifyPhoto(p, lien);
			p.setPhoto(lien);
		}
	}
	public static void confirm(String encrypt) throws Exception{
		ProfilDAO.confirm(StringUtil.decrypt(encrypt.replaceFirst("account=", "")));
	}
	public static void sendMailConfirm(String email) throws Exception{
            String lien = Traitement.getURL() + "Profil/Confirm.jsp?account=";
            Properties props = System.getProperties();
	    props.put(Traitement.getSmtpUrl(), Traitement.getMailUrl());
	    Session sess = Session.getInstance(props, null);
	    try {
	       MimeMessage msg = new MimeMessage(sess);
	       msg.setFrom(new InternetAddress("nepasrepondre@ouaiza.com"));
	       msg.setRecipient(Message.RecipientType.TO,
	                          new InternetAddress(email));
	       msg.setSubject("O� aiza - Veuillez confirmer votre compte");
	       msg.setSentDate(Date.valueOf(LocalDate.now()));
	       msg.setText("Nous vous remerions pour votre inscription \u00e0 notre r\u00e9seau O\u00f9 Aiza !\n"
	       		+ "Veuillez cliquer sur le lien suivant pour confirmer la cr\u00e9ation de votre compte: \n"
	       		+ lien + StringUtil.encrypt(email));
	       Transport.send(msg);
	    } 
	    catch (MessagingException mex) {
	    	mex.printStackTrace();
	    	System.out.println("send failed, exception: " + mex); 
	    }
	}
	public static void getRecommandation(Profil p) throws Exception {
		RecommandationDAO.getRecommandationByProfil(p);
	}
	public static Profil getProfil(String identifiant) throws Exception {
		return ProfilDAO.getProfilByIdentifiant(identifiant);
	}
	public static Vector<Profil> getListProfil(int offset) throws Exception {
		return ProfilDAO.getProfil(offset);
	}
}