package reseausocial;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public void menu(Moderateur modA) throws MenuException {
		boolean afficherMenu = true;

		while (afficherMenu) {

			if (Moderateur.isModerator() == false) {

				System.out.println("BIENVENUE SUR SEECRETSPOT\n");
				System.out.println("Faites votre choix :\n");

				System.out.println("-1- Afficher votre profil");
				System.out.println("-2- Modifier les informations");
				System.out.println("-3- Ecrire un message");
				System.out.println("-4- Afficher un message");
				System.out.println("-5- Se deconnecter");

				int menu = sc.nextInt();
				sc.nextLine();

				/*
				 * switch (menu) { case 1: ShowProfil(userA); break; case 2:
				 * Users.modifierInfo(); break; case 3: writeMessage(userA); break; case 4:
				 * showMessage(userA); break; case 5: logout(); break; } afficherMenu =
				 * retMenu();
				 */
			} // if

			else if (Moderateur.isModerator() == true && Moderateur.getMod() == 1) {
				System.out.println("BIENVENUE SUR SEECRETSPOT\n");
				System.out.println("Faites votre choix :\n");

				System.out.println("-1- Afficher votre profil");
				System.out.println("-2- Modifier les informations");
				System.out.println("-3- Ecrire un message");
				System.out.println("-4- Afficher un message");
				System.out.println("-5- Se deconnecter");
				System.out.println("-6- Tester");

				int menu = sc.nextInt();
				sc.nextLine();

				try {
					switch (menu) {
					case 1:
						ShowProfil(modA);
						break;
					case 2:
						Users.modifierInfo();
						break;
					case 3:
						writeMessage(modA);
						break;
					case 4:
						showMessage(modA);
						break;
					case 5:
						logout();
						break;
					case 6:
						System.out.println("test");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (menu > 6) {
					throw new MenuException();
				}
				afficherMenu = retMenu();
			} // if

			else if (Moderateur.isModerator() == true && Moderateur.getMod() == 2) {
				System.out.println("BIENVENUE SUR SEECRETSPOT\n");
				System.out.println("Faites votre choix :\n");

				System.out.println("-1- Afficher votre profil");
				System.out.println("-2- Modifier les informations");
				System.out.println("-3- Ecrire un message");
				System.out.println("-4- Afficher un message");
				System.out.println("-5- Se deconnecter");
				System.out.println("-6- Tester");
				System.out.println("-7- TESTER");

				int menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {
				case 1:
					ShowProfil(modA);
					break;
				case 2:
					Users.modifierInfo();
					break;
				case 3:
					writeMessage(modA);
					break;
				case 4:
					showMessage(modA);
					break;
				case 5:
					logout();
					break;
				case 7:
					System.out.println("test2");

				}
				afficherMenu = retMenu();
			} // elseif
		} // boucle while1
	} // public void menu

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

	private void ShowProfil(Moderateur modA) {
		System.out.println("Profil de : " + modA.getNom() + ' ' + modA.getPrenom());

	}

	private void logout() {
		System.out.println("Babye ! A bientôt sur SeecretSpot");

	}

	public void writeMessage(Moderateur modA) {
		System.out.println("merci d'écrire un nouveau message :");
		modA.setMessage(sc.nextLine());
		System.out.println(modA.getMessage());
	}

	public void showMessage(Moderateur modA) {
		System.out.println(modA.getMessage());
	}

} // public class Menu

/*
 * public class Menu {
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * public void menu(Users userA) { boolean afficherMenu = true;
 * 
 * while(afficherMenu) { System.out.println("BIENVENUE SUR SEECRETSPOT\n");
 * System.out.println("Faites votre choix :\n");
 * 
 * System.out.println("-1- Afficher votre profil");
 * System.out.println("-2- Modifier les informations");
 * System.out.println("-3- Ecrire un message");
 * System.out.println("-4- Afficher un message");
 * System.out.println("-5- Se deconnecter");
 * 
 * int menu = sc.nextInt(); sc.nextLine();
 * 
 * switch (menu) { case 1: ShowProfil(userA); break; case 2:
 * Users.modifierInfo(); break; case 3: Post.writeMessage(); break; case 4:
 * Post.showMessage(); break; case 5: logout(); break; } afficherMenu =
 * retMenu(); } //boucle while1 } //public void menu
 */