package modele;

import java.util.ArrayList;

public class Ensaignant {
private Integer id ;	
private String Nom;
private String prenom;
private String email;
private Integer grade;

private ArrayList<module> moduleEnsaigner;






public Ensaignant(Integer id,String prenom, String nom,  String email, Integer grade) {
	super();
	this.id = id;
	this.Nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.grade = grade;
}

public Integer getId() {
	return this.id;
}

public String getNom() {
	return this.Nom;
}

public String getPrenom() {
	return this.prenom;
}

public String getEmail() {
	return this.email;
}

public ArrayList<module> getModuleEnsaigner() {
	return this.moduleEnsaigner;
}

public Integer getGrade() {
	return this.grade;
}
public String getNomComplet(){
	return this.getNom()+" "+this.getPrenom();
}

}
