package reseausocial;

import java.util.Scanner;

// import java.util.Date;

public class Users {

	protected static String nom;
	protected static String prenom;
	protected static String ville;
	protected static String pseudo;
	protected static String message;
	protected static String dateNaissance;

	// Constructeur par défaut
	
	public Users() {
		nom = "Inconnu";
		prenom = "Inconnu";
		ville = "Inconnu";
		pseudo = "Inconnu";
		message = "Inconnu";
		dateNaissance = "Inconnu"  ;

	}

	// Accesseurs

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	// autres methodes 
	
	public static void modifierInfo() {

	}


	public static boolean isModerator() {
		return false; // modo niveau 0
	}
	
	
	public static void seDeconnecter() {
		
	}

}