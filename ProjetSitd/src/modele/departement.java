package modele;


import java.util.TreeSet;

public class departement {
@SuppressWarnings("unused")
private Integer id ;
private String nom ;
private String chefDepartement;

public departement() {

}
public departement(Integer id, String nom, String chefDepartement) {
	super();
	this.id = id;
	this.nom = nom;
	this.chefDepartement = chefDepartement;
}
public String getChefDepartement() {
	return this.chefDepartement;
}
public Integer getId() {
	return id;
}
public String getNom() {
	return nom;
}
public void setId(Integer id) {
	this.id = id;
}
public void setNom(String nom) {
	this.nom = nom;
}
public void setChefDepartement(String chefDepartement) {
	this.chefDepartement = chefDepartement;
}

}




