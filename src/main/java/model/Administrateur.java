package model;

public class Administrateur {
	int id;
	String identifiant;
	String password;

	public Administrateur() {}

	public Administrateur(int id, String identifiant, String password) {
		super();
		this.setId(id);
		this.setIdentifiant(identifiant);
		this.setPassword(password);
	}
	
	public Administrateur(int id, String identifiant) {
		super();
		this.setId(id);
		this.setIdentifiant(identifiant);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
