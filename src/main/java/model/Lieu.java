package model;

import java.text.NumberFormat;
import java.util.Vector;

import utilitaire.StringUtil;

public class Lieu {
	int id;
	Region region;
	String nom;
	String adresse;
	String description;
	double prixEntree;
	String contact;
	String siteWeb;
	String mail;
        float[] position;
	Horaire horaire;
	Etoile etoile;
	Vector<Commentaire> commentaire = new Vector<Commentaire>();
	Vector<Recommandation> recommandation = new Vector<Recommandation>();
	String logo = "default.jpg";
	Vector<String> galerie = new Vector<String>();
	Vector<String> menu = new Vector<String>();
	Vector<Evenement> top3 = new Vector<Evenement>();

	public Lieu() {}
	public Lieu(int id, Region region, String nom, String adresse, String description, double prixEntree, String contact, String siteWeb, String mail, String logo) throws Exception {
		super();
		this.setId(id);
		this.setRegion(region);
		this.setNom(nom);
		this.setAdresse(adresse);
		this.setDescription(description);
		this.setPrixEntree(prixEntree);
		this.setContact(contact);
		this.setSiteWeb(siteWeb);
		this.setMail(mail);
		this.setLogo(logo);
	}
	public Lieu(int id, Region region, String nom, String adresse, String description, double prixEntree, String contact, String siteWeb, String mail, String logo, Etoile etoile) throws Exception {
		super();
        this.position = new float[]{0,0};
		this.setId(id);
		this.setRegion(region);
		this.setNom(nom);
		this.setAdresse(adresse);
		this.setDescription(description);
		this.setPrixEntree(prixEntree);
		this.setContact(contact);
		this.setSiteWeb(siteWeb);
		this.setMail(mail);
		this.setLogo(logo);
		this.setEtoile(etoile);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws Exception {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

        public float[] getPosition() {
            return position;
        }

        public void setPosition(float[] position) {
            this.position = position;
        }
        public void setPosition(float latitude, float longitude){
            setPosition(new float[]{latitude,longitude});
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
		if(getPrixEntree() == 0) return "Entr\u00e9e libre";
		return "Entr\u00e9e : "+NumberFormat.getInstance().format(getPrixEntree())+" Ariary";
	}
	public void setPrixEntree(double prixEntree) throws Exception {
		if(prixEntree<0)throw new Exception("Un prix ne doit etre n\u00e9gatif");
		this.prixEntree = prixEntree;
	}
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) throws Exception {
		if(!StringUtil.isTelephone(contact)){
			throw new Exception("Ce num\u00e9ro de t\u00e9l\u00e9phone est invalide");
		}
		this.contact = contact;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) throws Exception{
		if(!StringUtil.isEmail(mail)){
			throw new Exception("Format d'email incorrect. Veuillez ins\u00e9rer une adresse email de la forme exemple@mail.exemple");
		}
		this.mail = mail;
	}
	
	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
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

	public Vector<Recommandation> getRecommandation() {
		return recommandation;
	}

	public void setRecommandation(Vector<Recommandation> recommandation) {
		this.recommandation = recommandation;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Vector<String> getGalerie() {
		if(galerie.isEmpty()) autoFillGalerie();
		return galerie;
	}
	void autoFillGalerie(){
		for (int i = 0; i < 5; i++) {
			galerie.addElement("default.jpg");
		}
	}

	public void setGalerie(Vector<String> galerie) {
		this.galerie = galerie;
	}

	public Vector<String> getMenu() {
		return menu;
	}

	public void setMenu(Vector<String> menu) {
		this.menu = menu;
	}

	public Vector<Evenement> getTop3() {
		return top3;
	}

	public void setTop3(Vector<Evenement> top3) {
		this.top3 = top3;
	}
	
}
