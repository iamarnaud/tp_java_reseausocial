package reseausocial;

import java.lang.reflect.Array;
import java.util.Scanner;
// import java.util.Date;

public class Users implements Relation {

	protected String nom;
	protected String prenom;
	protected String message;
	protected String dateNaissance;
	protected Array friendsList;

	// Constructeur par défaut
	
	public Users() {
		nom = "Inconnu";
		prenom = "Inconnu";
		message = "Inconnu";
		dateNaissance = "Inconnu";
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
	
	public Array getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(Array friendsList) {
		this.friendsList = friendsList;
	}

	// autres methodes 
	
	//pour retourner les information de notre listUsers
	public String toString() {
		return nom + " " + prenom;
	}
	
	public boolean isModerator() {
		return false; // modo niveau 0
	}
	
	public void modifierInfo() {
		
	}
	
	public void seConnecter() {
		
	}
	
	public void seDeconnecter() {
		
	}

	@Override
	public void ajouterPersonne() {
		
	}


	

}