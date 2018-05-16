package reseausocial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);
	
	CreateProfil newProfil = new CreateProfil();
	
	public void menu(Moderateur modA, ArrayList<Users> listUsers, ArrayList<Users> friendsList) throws MenuException, DateException {
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
						ShowProfil(modA);
						break;
					case 2:
						FriendsList(friendsList);
						break;
					case 3:
						AddFriend();
						break;
					case 4: 
						DeleteFriend();
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
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					//e.printStackTrace();
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
					ShowProfil(modA);
					break;
				case 2:
					FriendsList(friendsList);
					break;
				case 3:
					AddFriend();
					break;
				case 4: 
					DeleteFriend();
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
					 modA.DeleteMessage();
					 break;
				/*
				 case 11: 
				 TESTER();
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
	
	public void FriendsList(ArrayList<Users> friendsList) {
		System.out.println(friendsList); // friend list dans Main
		
	}
	
	public void lireEnBase() {
		
		//information d'accès à la BDD
		String url = "jdbc:mysql://localhost/modulejava";
		String user = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// récupération de la connexion
			cn = DriverManager.getConnection(url, user, passwd);

			// creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM users";

			// execution requête
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("nom") + " " + rs.getString("prenom")) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try { // liberer ressources de la mémoire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // lireEnBase
	
	private void AddFriend() {
		// TODO Auto-generated method stub
		
	}
	

	private void DeleteFriend() {
		// TODO Auto-generated method stub
		
	}
	

	/**
	 * menu0 = fonction du menu principal modo0
	 * @return le menu de l'utilisateur basic
	 */
	private void menu0() {
		System.out.println("BIENVENUE SUR SEECRETSPOT\n");
		System.out.println("Faites votre choix :\n");

		System.out.println("-1- Afficher votre profil");
		System.out.println("-2- Afficher liste d'amis");
		System.out.println("-3- Ajouter un ami");
		System.out.println("-4- Supprimer un ami");
		System.out.println("-5- Afficher");
		System.out.println("-6- Ecrire un message");
		System.out.println("-7- Afficher un message");
		System.out.println("-8- Se deconnecter");
		System.out.println("-9- Créer un profil");
	}

	/**
	 * menu1 = fonction d'ajout de fonctionnalité au menu principal pour modo1
	 * 
	 * @return le menu du modo1
	 */

	private void menu1() {
		System.out.println("-10- Supprimer un message");
	}

	/**
	 * menu2 = fonction d'ajout de fonctionnalité au menu principal pour modo2
	 * 
	 * @return le menu du modo2
	 */

	private void menu2() {
		System.out.println("-11- TESTER");
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
 * System.out.println("-6- Créer un profil");
 * 
 * int menu = sc.nextInt(); sc.nextLine();
 * 
 * switch (menu) { case 1: ShowProfil(userA); break; case 2:
 * Users.modifierInfo(); break; case 3: Post.writeMessage(); break; case 4:
 * Post.showMessage(); break; case 5: logout(); break; } afficherMenu =
 * retMenu(); } //boucle while1 } //public void menu
 */