package modele;

import java.util.ArrayList;

public class filiere {
private Integer id ;	
private String nom;
private ArrayList<module> modules;
private String responsable;
private String departement;


public filiere(Integer id, String nom, String responsable,String departement) {

	this.id = id;
	this.nom = nom;
	this.responsable = responsable;
	this.departement=departement;
}

public Integer getId() {
	return id;
}


public String getmodules() {
	String s="";
	for(module i:modules) {
		s=s+" "+i.getNom();
}
	
return s;
}

public String getNom() {
	return nom;
}

public String getDepartement() {
	return departement;
}

public String getResponsable() {
	return responsable;
}

public void changeResponsable(String nresponsable) {
	this.responsable=nresponsable;
}
}


