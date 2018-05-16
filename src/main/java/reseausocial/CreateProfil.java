package reseausocial;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProfil extends Users {

	public CreateProfil() {
		nom = "Inconnu";
		prenom = "Inconnu";
		dateNaissance = null;
	}

	// Creation d'un nouveau user
	public void createProfil(ArrayList<Users> listUsers) throws DateException {

		// Instanciation nouvel utilisateur.
		// Users u = new Users();

		System.out.println("Créez votre profil");
		Scanner sc = new Scanner(System.in);
		System.out.println("nom");
		nom = sc.nextLine();
		// u.setNom(nom); // On set le nom

		System.out.println("prenom");
		prenom = sc.nextLine();
		// u.setPrenom(prenom);
		try {
			System.out.println("dateNaissance");
			dateNaissance = sc.nextLine();
			if (!dateNaissance.matches("^\\s*(3[01]|[12][0-9]|0?[1-9])\\/(1[012]|0?[1-9])\\/((?:19|20)\\d{2})\\s*$")) {
				throw new DateException();
			}

			// u.setDateNaissance(dateNaissance);
		} catch (DateException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		// Enregistrement à la BDD
		sauverEnBase(nom, prenom, dateNaissance);

		// ajouter l'utilisateur à l'array
		// listUsers.add(u);
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

	public void sauverEnBase(String nom, String prenom, String dateNaissance) {

		// information d'accès à la BDD
		String url = "jdbc:mysql://localhost/modulejava";
		String user = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL OK !");

			// récupération de la connexion
			cn = DriverManager.getConnection(url, user, passwd);
			System.out.println("connexion effective !");

			// creation d'un statement
			st = cn.createStatement();
			String sql = "INSERT INTO users (`nom`, `prenom`, `date_naissance`) VALUES ('" + nom + "', '" + prenom
					+ "', '" + dateNaissance + "')"; // INSERT INTO table (champs) VALUES (variables méthode sauverBase)

			// execution requete
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("2");
		} finally {
			try { // liberer ressources de la mémoire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("3");
			}
		}
	} // sauverEnBase

} // public class CreateProfil