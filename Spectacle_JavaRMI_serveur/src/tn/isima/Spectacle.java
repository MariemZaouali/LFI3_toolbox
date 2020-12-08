package tn.isima;
import java.io.Serializable;
import java.util.ArrayList;

public class Spectacle implements Serializable {

	public static final long serialVersionUID = 52L;

	int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	int nb_place;
	String intitule;

	
	public int getNb_place() {
		return nb_place;
	}


	public void setNb_place(int nb_place) {
		this.nb_place = nb_place;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}