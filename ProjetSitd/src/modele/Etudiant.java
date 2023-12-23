package modele;

public class Etudiant {
private Integer codeApogé;
private String nom;
private String prénom;
private String email;
private String filiere;
public Etudiant(Integer codeApogé,String nom, String prénom, String email, String filiere) {
	this.codeApogé=codeApogé;
	this.nom = nom;
	this.prénom = prénom;
	this.email = email;
	this.filiere = filiere;
}
public String getEmail() {
	return email;
}
public String getFiliere() {
	return this.filiere;
}

public Integer getCodeApogé() {
	return codeApogé;
}
public String getNom() {
	return nom;
}
public String getPrénom() {
	return prénom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public void setPrénom(String prénom) {
	this.prénom = prénom;
}

public void setFiliere(String filiere) {
	this.filiere = filiere;

}


}
