package reseausocial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDAO extends DAO<Users> {

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement stm = null;

	@Override
	public boolean create(Users user) { // user = objet que l'on appelle autremement que objet (ici user)
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Users obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void profilUser(Users user) {
		try {

			/*
			 * // creation d'un statement st = cn.createStatement(); String sql =
			 * "SELECT * FROM users WHERE nom = '" + nom + "' AND prenom = '" + prenom +
			 * "' ";
			 */

			// creation d'un prepared statement
			String sql = "SELECT * FROM users WHERE nom=? AND prenom=?";
			stm = BddConnection.getInstance().prepareStatement(sql);
			stm.setString(1, user.getNom()); // 1 c'est le 1er ?
			stm.setString(2, user.getPrenom());
			ResultSet rs = stm.executeQuery();

			// execution requête
			// rs = st.executeQuery(sql);

			rs.next();
			System.out.println("Voir le profil de " + rs.getString("nom") + " " + rs.getString("prenom"));
			System.out.println("Date de naissance: " + rs.getString("date_naissance"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showAllUsers() {

		// creation d'un statement
		try {
			st = BddConnection.getInstance().createStatement();
			String sql = "SELECT * FROM users";

			// execution requête
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + " " + rs.getString("nom") + " " + rs.getString("prenom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showFriends() {

		// execution requête
		try {
			st = BddConnection.getInstance().createStatement();
			String sql = "SELECT ami.nom, ami.prenom FROM users AS current JOIN friends as F ON current.user_id = F.user_id JOIN users as ami ON ami.user_id = F.friend_id WHERE current.user_id = 5";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("nom") + " " + rs.getString("prenom"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

} // fin UsersDAO