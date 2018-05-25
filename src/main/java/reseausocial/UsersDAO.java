package reseausocial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO<Users> {

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement stm = null;

	public UsersDAO(Connection connect) {
		super();
		this.connect = connect;
	}
	
	

	public UsersDAO() {
		super();
		this.connect = BddConnection.getInstance();
	}



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
		Users userProfil = new Users();
		// creation d'un prepared statement
		try {
			ResultSet resultat = this.connect
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY, id).executeQuery("SELECT * FROM users WHERE user_id=" + id);

			if (resultat.first()) {
				userProfil = new Users(resultat.getString("nom"), resultat.getString("prenom"),
						resultat.getString("date_naissance"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userProfil;
	}

	public List<Users> getAllUsers() {

		// creation d'un statement
		try {
			st = BddConnection.getInstance().createStatement();
			String sql = "SELECT * FROM users";
			// execution requête
			rs = st.executeQuery(sql);

			List<Users> userList = new ArrayList<>();
			while (rs.next()) {
				Users user = new Users();
				user.setId(rs.getInt("user_id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));

				userList.add(user);

			}

			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ArrayList<Users>();
		}

	}

	public List<Users> showFriends() {

		// creation d'un statement
		try {
			st = BddConnection.getInstance().createStatement();
			String sql = "SELECT ami.nom, ami.prenom FROM users AS current JOIN friends as F ON current.user_id = F.user_id JOIN users as ami ON ami.user_id = F.friend_id WHERE current.user_id = 5";
			// execution requête
			rs = st.executeQuery(sql);

			List<Users> friendList = new ArrayList<>();
			while (rs.next()) {
				Users friend = new Users();
				friend.setNom(rs.getString("nom"));
				friend.setPrenom(rs.getString("prenom"));

				friendList.add(friend);

			}

			return friendList;
		} catch (SQLException e) {

			e.printStackTrace();
			return new ArrayList<Users>();
		}

	}

//	public void addAFriend() {
//
//		try {
//			st = BddConnection.getInstance().createStatement();
//			String sql = "INSERT INTO `friends` (`user_id`,`friend_id`) VALUES (" + currentUser + ",'" + this.friend
//					+ "')";
//			/**
//			 * exercution requete
//			 */
//			st.executeUpdate(sql);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//
//	}

} // fin UsersDAO