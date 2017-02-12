package model;

import java.time.LocalDate;

public class LieuRetire extends Lieu {
	LocalDate dateRetire;
	Administrateur administrateur;
	String remarque;
	
	public LieuRetire() {
		super();
	}
	public LieuRetire(int id, Region region, String nom, String adresse, String description, double prixEntree,
			String contact, String siteWeb, String mail, String logo) throws Exception {
		super(id, region, nom, adresse, description, prixEntree, contact, siteWeb, mail, logo);
	}
	public LocalDate getDateRetire() {
		return dateRetire;
	}
	public void setDateRetire(LocalDate dateRetire) {
		this.dateRetire = dateRetire;
	}
	public Administrateur getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
}
