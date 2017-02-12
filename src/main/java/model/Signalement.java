package model;

public class Signalement {
	int id;
	Commentaire commentaire;
	Profil profil;
	String Cause;

	public Signalement() {}

	public Signalement(int id, Commentaire commentaire, Profil profil, String cause) {
		super();
		this.setId(id);
		this.setCommentaire(commentaire);
		this.setProfil(profil);
		this.setCause(cause);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public String getCause() {
		return Cause;
	}

	public void setCause(String cause) {
		Cause = cause;
	}

}
