package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class Etoile {
	int nombreEtoile = 0;
	float nombreVote = 0;

	public Etoile() {}

	public Etoile(float nombreVote, int nombreEtoile) {
		super();
		this.setNombreVote(nombreVote);
		this.setNombreEtoile(nombreEtoile);
	}

	public int getNombreEtoile() {
		return nombreEtoile;
	}

	public void setNombreEtoile(int nombreEtoile) {
		this.nombreEtoile = nombreEtoile;
	}
	
	public float getNombreVote() {
		return nombreVote;
	}

	public void setNombreVote(float nombreVote) {
		this.nombreVote = nombreVote;
	}
	public float getMoyenne(){
		if(getNombreVote()>0) return getNombreEtoile()/getNombreVote();
		return 0;
	}
	public String getRate(){
		String rate = "";
		int i = 1;
		float moyenne = getMoyenne();
		while(i<=5){
			if(i-1<moyenne&&i>moyenne)rate+="star_half ";
			else if(i<=moyenne)rate+="star ";
			else rate+="star_border ";
			i++;
		}
		return rate;
	}
	public String getMoyenneString(){
		String etoile = " \u00e9toile";
		if(getMoyenne()>1)etoile+="s";
		return new DecimalFormat("0.0", DecimalFormatSymbols.getInstance()).format(getMoyenne())+etoile+" sur 5";
	}
	public String getVoteString(){
		String vote = " vote";
		if(getNombreVote()>1)vote+="s";
		return "sur "+NumberFormat.getInstance().format(getNombreVote())+vote;
	}
}
