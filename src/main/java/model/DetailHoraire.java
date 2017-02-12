package model;

import java.time.*;

public class DetailHoraire {
	
	DayOfWeek jour;
	LocalTime ouverture;
	LocalTime fermeture;
	LocalTime pauseDebut;
	LocalTime pauseFin;
	
	public DetailHoraire() {}
	public DetailHoraire(LocalTime ouverture, LocalTime fermeture) {
		super();
		this.ouverture = ouverture;
		this.fermeture = fermeture;
	}
	
	public DetailHoraire(LocalTime ouverture, LocalTime fermeture, LocalTime pauseDebut,
			LocalTime pauseFin) {
		super();
		this.ouverture = ouverture;
		this.fermeture = fermeture;
		this.pauseDebut = pauseDebut;
		this.pauseFin = pauseFin;
	}
	public LocalTime getOuverture() {
		return ouverture;
	}
	public void setOuverture(LocalTime ouverture) {
		this.ouverture = ouverture;
	}
	public LocalTime getFermeture() {
		return fermeture;
	}
	public void setFermeture(LocalTime fermeture) {
		this.fermeture = fermeture;
	}
	public DayOfWeek getJour() {
		return jour;
	}
	public void setJour(DayOfWeek jour) {
		this.jour = jour;
	}
	public LocalTime getPauseDebut() {
		return pauseDebut;
	}
	public void autoSetPause(){
		setPauseDebut(LocalTime.NOON);
		setPauseFin(LocalTime.of(14, 0));
	}
	public void setPauseDebut(LocalTime pauseDebut) {
		this.pauseDebut = pauseDebut;
	}
	public LocalTime getPauseFin() {
		return pauseFin;
	}
	public void setPauseFin(LocalTime pauseFin) {
		this.pauseFin = pauseFin;
	}
	
}
