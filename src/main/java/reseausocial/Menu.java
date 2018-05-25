package reseausocial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	CreateProfil newProfil = new CreateProfil();

	private int friend;

	int currentUser = 5; // par défaut le current user a l'id 5, selon son num en BDD
	// Quand on se connecte à l'app le current user sera celui là)
	// Il faudra définir le current comme la personne qui se connecte.

	// information d'accès à la BDD

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement stm = null;

	/**
	 * menu0 = fonction du menu principal modo0
	 * 
	 * @return le menu de l'utilisateur basic
	 */
	private void menu0() {

		System.out.println("BIENVENUE SUR SEECRETSPOT\n");
		System.out.println("Faites votre choix :\n");

		System.out.println("-1- Afficher votre profil");
		System.out.println("-2- Afficher liste d'amis");
		System.out.println("-3- Ajouter un ami");
		System.out.println("-4- Supprimer un ami");
		System.out.println("-5- Afficher les utilisateurs");
		System.out.println("-6- Ecrire un message");
		System.out.println("-7- Afficher un message");
		System.out.println("-8- Se deconnecter");
		System.out.println("-9- Créer un profil");
		System.out.println("-10- Chercher un profil");
	}

	/**
	 * menu1 = fonction d'ajout de fonctionnalité au menu principal pour modo1
	 * 
	 * @return le menu du modo1
	 */

	private void menu1() {
		System.out.println("-11- Supprimer un message");
	}

	/**
	 * menu2 = fonction d'ajout de fonctionnalité au menu principal pour modo2
	 * 
	 * @return le menu du modo2
	 */

	private void menu2() {
		System.out.println("-12- TESTER");
	}

	public void menu(Moderateur modA, ArrayList<Users> listUsers, ArrayList<Users> friendsList)
			throws MenuException, DateException, SQLException {
		boolean afficherMenu = true;

		while (afficherMenu) {

			if (modA.isModerator() == false) {

				menu0();
			}

			else if (modA.isModerator() == true && modA.getMod() == 1) {

				menu0();
				menu1();

				int menu = sc.nextInt();
				sc.nextLine();

				try {
					switch (menu) {
					case 1:
						showProfil(modA);
						break;
					case 2:
						friendsList();
						break;
					case 3:
						addFriend();
						break;
					case 4:
						deleteFriend();
					case 5:
						lireEnBase();
						break;
					case 6:
						writeMessage(modA);
						break;
					case 7:
						showMessage(modA);
						break;
					case 8:
						logout();
						break;
					case 9:
						newProfil.createProfil(listUsers);
						break;
					case 10:
						searchProfil();
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

				if (menu > 11) {
					throw new MenuException();
				}
				afficherMenu = retMenu();
			} // if

			else if (modA.isModerator() == true && modA.getMod() == 2) {

				menu0();
				menu1();
				menu2();

				int menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {
				case 1:
					showProfil(modA);
					break;
				case 2:
					friendsList();
					break;
				case 3:
					addFriend();
					break;
				case 4:
					deleteFriend();
				case 5:
					lireEnBase();
					break;
				case 6:
					writeMessage(modA);
					break;
				case 7:
					showMessage(modA);
					break;
				case 8:
					logout();
					break;
				case 9:
					newProfil.createProfil(listUsers);
					break;
				case 10:
					searchProfil();
					break;
				case 11:
					modA.DeleteMessage();
					break;
				/*
				 * case 12: TESTER(); break;
				 */
				}

				afficherMenu = retMenu();
			} // elseif
		} // boucle while1
	} // public void menu

	/**
	 * Demande a l'utilisateur si il faut returner au menu ou quiter
	 * 
	 * @return : true si on retourne au menu sinon false
	 */
	private boolean retMenu() {
		System.out.println("Retourner au menu ? ");
		return demanderOuiNon();
	}

	private boolean demanderOuiNon() {
		// Scanner sc = new Scanner(System.in);
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

	private void showProfil(Moderateur modA) {
		System.out.println("Profil de : " + modA.getNom() + ' ' + modA.getPrenom());
	}

	private void logout() {
		System.out.println("Babye ! A bientôt sur SeecretSpot");
		BddConnection.closeCo();
	}

	public void writeMessage(Moderateur modA) {
		System.out.println("merci d'écrire un nouveau message :");
		modA.setMessage(sc.nextLine());
		System.out.println(modA.getMessage());
	}

	public void showMessage(Moderateur modA) {
		System.out.println(modA.getMessage());
	}

	/*
	 * public void friendsList(ArrayList<Users> friendsList) {
	 * System.out.println(friendsList); // friend list dans Main }
	 */

	private void friendsList() {

		List<Users> friendList;

		UsersDAO fDao = new UsersDAO();
		friendList = fDao.showFriends();
		for (Users friend : friendList) {
			System.out.println(friend.getNom() + " " + friend.getPrenom());
		}
	}

	public void lireEnBase() throws SQLException {

		List<Users> userList;

		UsersDAO uDao = new UsersDAO();
		userList = uDao.getAllUsers();

		for (Users user : userList) {
			System.out.println(user.getId() + " " + user.getNom() + " " + user.getPrenom());
		}

	} // lireEnBase

	private void searchProfil() throws SQLException {
		UsersDAO uDAO = new UsersDAO();
		Users user = new Users();
		System.out.println("Chercher un utilisateur");
		System.out.println("user_id");
		int aze = user.setId(sc.nextInt());
		sc.nextLine();
		
		user = uDAO.find(aze);
		{
			System.out.println("Le profil de " + user.getNom()+ " " + user.getPrenom());
			System.out.println("Date de naissance: " + user.getDateNaissance());
		}
	
	} // searchProfil

	private void addFriend() throws SQLException {
		lireEnBase();
		UsersDAO uDAO = new UsersDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le numéro correspondant à votre ami: ");
		this.friend = sc.nextInt();
		sc.nextLine();
		//uDAO.addAFriend();

	} // addFriend

	private void deleteFriend() {

	}

} // public class Menu