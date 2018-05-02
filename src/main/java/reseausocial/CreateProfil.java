package reseausocial;

import java.util.Scanner;

public class CreateProfil {

	private static String nom;
	private static String prenom;
	private static String pseudo;
	private static String ville;
	private static String dateNaissance;

	public CreateProfil() {
		nom = "Inconnu";
		prenom = "Inconnu";
		pseudo = "Inconnu";
		ville = "Inconnu";
		dateNaissance = null;
	}

	public static void createProfil() throws DateException {
		System.out.println("Créez votre profil");
		Scanner sc = new Scanner(System.in);
		System.out.println("nom");
		nom = sc.nextLine();

		System.out.println("prenom");
		prenom = sc.nextLine();

		System.out.println("pseudo");
		pseudo = sc.nextLine();

		System.out.println("ville");
		ville = sc.nextLine();

		try {
			System.out.println("dateNaissance");
			dateNaissance = sc.nextLine();
			if (!dateNaissance.matches("^\\s*(3[01]|[12][0-9]|0?[1-9])\\/(1[012]|0?[1-9])\\/((?:19|20)\\d{2})\\s*$")) {
				throw new DateException();
			}
		} catch (DateException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		CreateProfil.nom = nom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

} // public class CreateProfil