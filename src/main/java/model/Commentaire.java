package model;

import java.time.LocalDateTime;

import utilitaire.StringUtil;

public class Commentaire {
	int id;
	String commentaire;
	Profil profil;
	LocalDateTime dateHeure;

	public Commentaire() {}

	public Commentaire(int id, String commentaire, LocalDateTime dateHeure, Profil profil) throws Exception {
		super();
		this.setId(id);
		this.setCommentaire(commentaire);
		this.setDateHeure(dateHeure);
		this.setProfil(profil);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) throws Exception {
		if(commentaire.isEmpty())throw new Exception("Commentaire vide");
		this.commentaire = commentaire;
	}
	
	public LocalDateTime getDateHeure() {
		return dateHeure;
	}
	public String getDateHeureString() {
		return StringUtil.formatDateTime(dateHeure);
	}
	
	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

}
