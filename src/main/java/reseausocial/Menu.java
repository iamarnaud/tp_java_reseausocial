package reseausocial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	CreateProfil newProfil = new CreateProfil();

	private int friend;

	int currentUser = 5; // par d�faut le current user a l'id 5, selon son num en BDD
	// Quand on se connecte � l'app le current user sera celui l�)
	// Il faudra d�finir le current comme la personne qui se connecte.

	// information d'acc�s � la BDD
	String url = "jdbc:mysql://localhost/modulejava";
	String user = "root";
	String passwd = "";

	Connection cn = null;
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
		System.out.println("-9- Cr�er un profil");
		System.out.println("-10- Chercher un profil");
	}

	/**
	 * menu1 = fonction d'ajout de fonctionnalit� au menu principal pour modo1
	 * 
	 * @return le menu du modo1
	 */

	private void menu1() {
		System.out.println("-11- Supprimer un message");
	}

	/**
	 * menu2 = fonction d'ajout de fonctionnalit� au menu principal pour modo2
	 * 
	 * @return le menu du modo2
	 */

	private void menu2() {
		System.out.println("-12- TESTER");
	}

	public void menu(Moderateur modA, ArrayList<Users> listUsers, ArrayList<Users> friendsList)
			throws MenuException, DateException {
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
			System.out.println("R�pondre par O / N");
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
		System.out.println("Babye ! A bient�t sur SeecretSpot");
	}

	public void writeMessage(Moderateur modA) {
		System.out.println("merci d'�crire un nouveau message :");
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
		try {
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, user, passwd);

			// creation d'un statement pour ajouter un ami
			st = cn.createStatement();
			String sql = "SELECT ami.nom, ami.prenom FROM users AS current JOIN friends as F ON current.user_id = F.user_id JOIN users as ami ON ami.user_id = F.friend_id WHERE current.user_id = 5";

			// execution requ�te
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("nom") + " " + rs.getString("prenom"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try { // liberer ressources de la m�moire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void lireEnBase() {

		try {
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, user, passwd);

			// creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM users";

			// execution requ�te
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + " " + rs.getString("nom") + " " + rs.getString("prenom"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try { // liberer ressources de la m�moire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // lireEnBase

	
	private void searchProfil() {

		String nom;
		String prenom;

		System.out.println("Chercher un utilisateur");
		// Scanner sc = new Scanner(System.in);
		System.out.println("nom");
		nom = sc.nextLine();
		System.out.println("prenom");
		prenom = sc.nextLine();

		try {
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, user, passwd);

			/*
			// creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM users WHERE nom = '" + nom + "' AND prenom = '" + prenom + "' ";
			*/
			
			// creation d'un prepared statement
			String sql = "SELECT * FROM users WHERE nom=? AND prenom=?";
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, nom); // 1 c'est le 1er ?
			preparedStatement.setString(2, prenom);
			ResultSet rs = preparedStatement.executeQuery();
		
			// execution requ�te
			//rs = st.executeQuery(sql);
			
			rs.next();
			System.out.println("Voir le profil de " + rs.getString("nom") + " " + rs.getString("prenom"));
			System.out.println("Date de naissance: " + rs.getString("date_naissance"));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try { // liberer ressources de la m�moire
				cn.close();
				//st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
	private void addFriend() {
		lireEnBase();

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le num�ro correspondant � votre ami: ");
		this.friend = sc.nextInt();
		sc.nextLine();

		try {
			/**
			 * Chargement du driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * r�cup�ration de la connexion
			 */
			cn = DriverManager.getConnection(url, user, passwd);
			/**
			 * Cr�ation d'un statement
			 */
			st = cn.createStatement();
			String sql = "INSERT INTO `friends` (`user_id`,`friend_id`) VALUES (" + currentUser + ",'" + this.friend
					+ "')";
			/**
			 * exercution requete
			 */
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				/**
				 * lib�rer ressource memoire, fermeture connection
				 */
				cn.close();
				st.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void deleteFriend() {
		// TODO Auto-generated method stub
	}

} // public class Menu