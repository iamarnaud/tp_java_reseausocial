package reseausocial;

import java.lang.reflect.Array;
import java.util.Scanner;
// import java.util.Date;

public class Users  {

	protected int id;
	protected String nom;
	protected String prenom;
	protected String message;
	protected String dateNaissance;
	protected Array friendsList;

	// Constructeur par d�faut
	
	public Users() {
		nom = "Inconnu";
		prenom = "Inconnu";
		message = "Inconnu";
		dateNaissance = "Inconnu";
	}
	
	public Users(String nom, String prenom, String dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	// Accesseurs

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}
	
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
	
	/**public void modifierInfo() {
		
	}
	
	public void seConnecter() {
		
	}
	
	public void seDeconnecter() {
		
	}

	@Override
	public void ajouterPersonne() {
		
	}*/


	

}