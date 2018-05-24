package reseausocial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddConnection {

	// connection à la BDD
	private String url = "jdbc:mysql://localhost/modulejava";
	private String user = "root";
	private String passwd = "";

	// objet connection
	private static Connection connect;

	// Constructeur privé
	private BddConnection() {
		try {
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, user, passwd);
			System.out.println("bdd connectée");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	// Methode qui va nous retourner notre instance et la créer si elle n'existe pas
	public static Connection getInstance() {
		if (connect == null) {
			new BddConnection();

		} else {
			System.out.println("déjà connectée");
		}

		return connect;
	}

	public static void closeCo() {
		try {
			connect.close(); // methode de deconnection
			System.out.println("Bdd déconnectée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

} // class Connection
