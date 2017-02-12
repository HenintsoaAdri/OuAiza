package model;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Vector;

public class Evenement {
	int id;
	Lieu lieu;
	Organisateur organisateur;
	String nom;
	LocalDateTime dateDebutEvenement;
	LocalDateTime dateFinEvenement;
	String description;
	double prixEntree;
	String condition;
	String autreInfo;
	String affiche = "default.jpg";
	Etoile etoile;
	Vector<Commentaire> Commentaire;

	public Evenement() {}

	public Evenement(int id, Lieu lieu, Organisateur organisateur, String nom, LocalDateTime dateEvenement, LocalDateTime dateFinEvenement, String description, double prixEntree,
			String condition, String autreInfo, String affiche) throws Exception {
		super();
		this.setId(id);
		this.setLieu(lieu);
		this.setOrganisateur(organisateur);
		this.setNom(nom);
		this.setDateDebutEvenement(dateEvenement);
		this.setDateFinEvenement(dateFinEvenement);
		this.setDescription(description);
		this.setPrixEntree(prixEntree);
		this.setCondition(condition);
		this.setAutreInfo(autreInfo);
		this.setAffiche(affiche);
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

	public Organisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getDateDebutEvenement() {
		return dateDebutEvenement;
	}
	public String getDebutString(){
		return  getDebutDateString()
				+" \u00e0 "
				+getDebutTimeString();
	}
	public String getDebutDateString(){
		return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(getDateDebutEvenement().toLocalDate());
	}
	public String getDebutTimeString(){
		return DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(getDateDebutEvenement().toLocalTime());
	}
	public void setDateDebutEvenement(LocalDateTime dateEvenement) {
		this.dateDebutEvenement = dateEvenement;
	}
	
	public LocalDateTime getDateFinEvenement() {
		return dateFinEvenement;
	}
	public String getFinString(){
		return  getFinDateString()
				+" � "
				+ getFinTimeString();
	}
	public String getFinDateString(){
		return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(getDateFinEvenement().toLocalDate());
	}
	public String getFinTimeString(){
		return DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(getDateFinEvenement().toLocalTime());
	}
	public void setDateFinEvenement(LocalDateTime dateFinEvenement) throws Exception {
		if(dateFinEvenement.isBefore(getDateDebutEvenement()))throw new Exception("La date de fin de l'�v�nement ne peut etre ant�rieur � son d�but");
		this.dateFinEvenement = dateFinEvenement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixEntree() {
		return prixEntree;
	}
	public String getPrixEntreeString(){
		if(getPrixEntree() == 0) return "Entr&eacutee libre";
		return "Entr&eacute;e : "+NumberFormat.getInstance().format(getPrixEntree())+" Ariary";
	}
	public void setPrixEntree(double prixEntree) throws Exception {
		if(prixEntree<0)throw new Exception("Un prix ne doit etre n&eacute;gatif");
		this.prixEntree = prixEntree;
	}

	public String getCondition() {
		return condition;
	}
	public String getConditionString(){
		if(getCondition().isEmpty())return "Aucune condition requise";
		return getCondition();
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getAutreInfo() {
		return autreInfo;
	}

	public void setAutreInfo(String autreInfo) {
		this.autreInfo = autreInfo;
	}

	public String getAffiche() {
		return affiche;
	}

	public void setAffiche(String affiche) {
		this.affiche = affiche;
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
