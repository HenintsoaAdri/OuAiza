package model;

import java.time.DayOfWeek;
import java.util.Vector;

public class Horaire {
	
	DetailHoraire lundi;
	DetailHoraire mardi;
	DetailHoraire mercredi;
	DetailHoraire jeudi;
	DetailHoraire vendredi;
	DetailHoraire samedi;
	DetailHoraire dimanche;
	public Horaire() {}
	
	public Horaire(DetailHoraire lundi, DetailHoraire mardi, DetailHoraire mercredi, DetailHoraire jeudi,
			DetailHoraire vendredi, DetailHoraire samedi, DetailHoraire dimanche) {
		super();
		setLundi(lundi);
		setMardi(mardi);
		setMercredi(mercredi);
		setJeudi(jeudi);
		setVendredi(vendredi);
		setSamedi(samedi);
		setDimanche(dimanche);
	}

	public DetailHoraire getLundi() {
		return lundi;
	}

	public void setLundi(DetailHoraire lundi) {
		lundi.setJour(DayOfWeek.MONDAY);
		this.lundi = lundi;
	}

	public DetailHoraire getMardi() {
		return mardi;
	}

	public void setMardi(DetailHoraire mardi) {
		mardi.setJour(DayOfWeek.TUESDAY);
		this.mardi = mardi;
	}

	public DetailHoraire getMercredi() {
		return mercredi;
	}

	public void setMercredi(DetailHoraire mercredi) {
		mercredi.setJour(DayOfWeek.WEDNESDAY);
		this.mercredi = mercredi;
	}

	public DetailHoraire getJeudi() {
		return jeudi;
	}

	public void setJeudi(DetailHoraire jeudi) {
		jeudi.setJour(DayOfWeek.THURSDAY);
		this.jeudi = jeudi;
	}

	public DetailHoraire getVendredi() {
		return vendredi;
	}

	public void setVendredi(DetailHoraire vendredi) {
		vendredi.setJour(DayOfWeek.FRIDAY);
		this.vendredi = vendredi;
	}

	public DetailHoraire getSamedi() {
		return samedi;
	}

	public void setSamedi(DetailHoraire samedi) {
		samedi.setJour(DayOfWeek.SATURDAY);
		this.samedi = samedi;
	}

	public DetailHoraire getDimanche() {
		return dimanche;
	}

	public void setDimanche(DetailHoraire dimanche) {
		dimanche.setJour(DayOfWeek.SUNDAY);
		this.dimanche = dimanche;
	}
	public Vector<DetailHoraire> getAllHoraire(){
		Vector<DetailHoraire> detail = new Vector<DetailHoraire> ();
		detail.add(getLundi());
		detail.add(getMardi());
		detail.add(getMercredi());
		detail.add(getJeudi());
		detail.add(getVendredi());
		detail.add(getSamedi());
		detail.add(getDimanche());
		return detail;
	}
	public void addDetailHoraire(DetailHoraire d, DayOfWeek jour){
		switch (jour) {
		case MONDAY : setLundi(d);		
			break;
		case TUESDAY : setMardi(d);
			break;
		case WEDNESDAY : setMercredi(d);
			break;
		case THURSDAY : setJeudi(d);
			break;
		case FRIDAY : setVendredi(d);
			break;
		case SATURDAY : setSamedi(d);
			break;
		case SUNDAY : setDimanche(d);
			break;
		default:
			break;
		}
	}
}
