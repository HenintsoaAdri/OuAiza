package model;

public class Note {
	Profil profil;
	int nombreEtoile;
	
	public Note(Profil profil, int nombreEtoile) {
		super();
		setProfil(profil);
		setNombreEtoile(nombreEtoile);
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public int getNombreEtoile() {
		return nombreEtoile;
	}
	public void setNombreEtoile(int nombreEtoile) {
		this.nombreEtoile = nombreEtoile;
	}
	
}
