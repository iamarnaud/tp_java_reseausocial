package reseausocial;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateProfil extends Users {


	public CreateProfil() {
		nom = "Inconnu";
		prenom = "Inconnu";
		dateNaissance = null;
	}

	// Creation d'un nouveau user
	public void createProfil(ArrayList<Users> listUsers) throws DateException {
		
		// Instanciation nouvel utilisateur.
		Users u = new Users();
		
		System.out.println("Créez votre profil");
		Scanner sc = new Scanner(System.in);
		System.out.println("nom");
		nom = sc.nextLine();
		u.setNom(nom); // On set le nom

		System.out.println("prenom");
		prenom = sc.nextLine();
		u.setPrenom(prenom);
		try {
			System.out.println("dateNaissance");
			dateNaissance = sc.nextLine();
			if (!dateNaissance.matches("^\\s*(3[01]|[12][0-9]|0?[1-9])\\/(1[012]|0?[1-9])\\/((?:19|20)\\d{2})\\s*$")) {
				throw new DateException();
			}
			u.setDateNaissance(dateNaissance);
		} catch (DateException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		//ajouter l'utilisateur à l'array
		listUsers.add(u); 
	}
	
	
	// Accesseurs
	
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
		this.nom = nom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

} // public class CreateProfil