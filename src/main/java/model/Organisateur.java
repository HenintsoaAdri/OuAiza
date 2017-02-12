package model;

import java.util.Vector;

public class Organisateur {
	int id;
	String nom;
	String description;
	String logo = "default.jpg";
	String contact;
	String mail;
	String adresse;
	Region region;
	String siteWeb;
	Etoile etoile;
	Vector<Commentaire> commentaire;
	Vector<Evenement> top3;
	  
	public Organisateur() {}

	public Organisateur(int id, String nomOrganisateur, String descriptionOrganisateur, String logo, String contact, String mail, String adresse, Region region, String siteWeb, Etoile etoile) {
		this.setId(id);
		this.setNom(nomOrganisateur);
		this.setDescription(descriptionOrganisateur);
		this.setLogo(logo);
		this.setContact(contact);
		this.setMail(mail);
		this.setAdresse(adresse);
		this.setRegion(region);
		this.setSiteWeb(siteWeb);
		this.setEtoile(etoile);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descriptionOrganisateur) {
		this.description = descriptionOrganisateur;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	
	public Etoile getEtoile() {
		return etoile;
	}

	public void setEtoile(Etoile etoile) {
		this.etoile = etoile;
	}

	public Vector<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Vector<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	public Vector<Evenement> getTop3() {
		return top3;
	}

	public void setTop3(Vector<Evenement> top3) {
		this.top3 = top3;
	}
	
}
