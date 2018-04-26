package reseausocial;

import java.util.Scanner;

public class Menu {
		
	Scanner sc = new Scanner(System.in);
	
	public void menu(Users userA) { 
		boolean afficherMenu = true;

	while(afficherMenu) {
		System.out.println("BIENVENUE SUR SEECRETSPOT\n");
		System.out.println("Faites votre choix :\n");

		System.out.println("-1- Afficher votre profil");
		System.out.println("-2- Modifier les informations");
		System.out.println("-3- Ecrire un message");
		System.out.println("-4- Modifier un message");
		System.out.println("-5- Se deconnecter");

		int menu = sc.nextInt();
		sc.nextLine();
	
	switch (menu) {
		case 1:
			ShowProfil(userA);
			break;
		case 2:
			Users.modifierInfo();
			break;
		case 3:
			Message.writeMessage();
			break;
		case 4:
			Message.changeMessage();
			break;
		case 5:
			Message.changeMessage();
			break;
		}
		afficherMenu = retMenu();
	} //boucle while1
	} //public void menu
	
	// Demande a l'utilisateur si il faut returner au menu ou quiter
	// @return : true si on retourne au menu sinon false

	private static boolean retMenu() {
		System.out.println("Retourner au menu ? ");
	    return demanderOuiNon();
	}

	private static boolean demanderOuiNon() {
		Scanner sc = new Scanner(System.in);
		char r;
		do {
			System.out.println("Répondre par O / N");
			r = sc.nextLine().charAt(0);
		} while (r != 'O' && r != 'N');
		if (r == 'O') {
			return true;
		} else {
			return false;
		}

	}
	
	public static void ShowProfil(Users userA) {
		System.out.println("Profil de : " + userA.getNom() + ' ' + userA.getPrenom());

	}

} // public class Menu