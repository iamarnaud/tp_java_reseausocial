package reseausocial;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Users {
	
	private String nom; 
	private String prenom; 
	private String ville; 
	private String pseudo;
	
	// Constructeur par défaut 
	public Users() {
		nom = "Inconnu";
		prenom = "Inconnu";
		ville = "Inconnu";
		pseudo = "Inconnu";
	}
	
	 // Accesseurs
	/**
	 * 
	 * @param nom
	 */


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
	
	public static void modifierInfo() {

	}
	
	public static void createProfil() {

	}
	
	public static boolean isModerator() {
		return false;
	}	
		
}