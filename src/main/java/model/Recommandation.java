package model;

import java.util.Vector;

public class Recommandation {
	int id;
	Lieu lieu;
	Profil profil;
	String description;
	String image;
	Vector<Signalement> signalement;
	Etoile etoile;
	Vector<Commentaire> Commentaire;

	public Recommandation() {}

	public Recommandation(int id, Lieu lieu, Profil profil, String description, String image) {
		super();
		this.setId(id);
		this.setLieu(lieu);
		this.setProfil(profil);
		this.setDescription(description);
		this.setImage(image);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		if(image != null)return image;
		return "default.jpg";
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Vector<Signalement> getSignalement() {
		return signalement;
	}

	public void setSignalement(Vector<Signalement> signalement) {
		this.signalement = signalement;
	}

	public Etoile getEtoile() {
		return etoile;
	}

	public void setEtoile(Etoile etoile) {
		this.etoile = etoile;
	}

	public Vector<Commentaire> getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(Vector<Commentaire> commentaire) {
		Commentaire = commentaire;
	}

}
