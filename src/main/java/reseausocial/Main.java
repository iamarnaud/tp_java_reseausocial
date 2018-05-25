package reseausocial;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws MenuException, DateException, SQLException {
	
		// Nouvelle liste
		ArrayList<Users> listUsers = new ArrayList();

		Users userA = new Users();
		userA.setNom("Smith");
		userA.setPrenom("Sam");
		userA.setDateNaissance("12.12.2012");
		//System.out.println(userA.getPrenom());

		Users userB = new Users();
		userB.setNom("Maurte");
		userB.setPrenom("Adele");
		userB.setDateNaissance("12.12.2012");		
		//System.out.println(userB.getPrenom());

		Moderateur modA = new Moderateur();
		modA.setNom("");
		modA.setPrenom("");
		modA.setDateNaissance("");
		modA.setMod(1); // changer le modo : 1 ou 2

		// on place les users dans la liste
		
		listUsers.add(userA);
		listUsers.add(userB);
		//System.out.println(listUsers.get(1));

		ArrayList<Users> friendsList = new ArrayList();
		friendsList.add(userA);
		friendsList.add(userB);
		
		//listUsers.remove(userA);
		
		Menu menu = new Menu();
		menu.menu(modA, listUsers, friendsList);

	}
}
