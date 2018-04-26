package reseausocial;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Users {
	
	private static String nom, prenom, ville, pseudo;
	
	// Constructeur par défaut 
	public Users() {
		nom = "";
		prenom = "";
		ville = "";
		pseudo = "";
	}
	
	 // Accesseurs
	/**
	 * 
	 * @param nom
	 */

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public static String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getVille() {
		return ville;	
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public static void modifierInfo() {

	}
	
	public static void createProfil() {

	}
		
}