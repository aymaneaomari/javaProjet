package modele;

public class module {

	
	
private String nom;
private String ensaignant;
private String filiere;
private Integer id;

	

public module(Integer id,String nom, String ensaignant, String filiere) {
	this.nom = nom;
	this.ensaignant = ensaignant;
	this.filiere = filiere;
	this.id = id;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getEnsaignant() {
	return ensaignant;
}



public void setEnsaignant(String ensaignant) {
	this.ensaignant = ensaignant;
}



public String getFiliere() {
	return filiere;
}



public void setFiliere(String filiere) {
	this.filiere = filiere;
}



public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}







}

