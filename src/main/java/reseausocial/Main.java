package reseausocial;

public class Main {

	public static void main(String[] args) throws MenuException {
		
		Users userA = new Users();
		userA.setNom("Smith");
		userA.setPrenom("Sam");
		userA.setPseudo("Samsam");
		userA.setVille("Annecy");
		userA.setDateNaissance("12.12.2012");
		System.out.println(userA.getPrenom());

		Users userB = new Users();
		userB.setNom("Maurte");
		userB.setPrenom("Adele");
		userB.setPseudo("Helloitsme");
		userB.setVille("Londres");
		userB.setDateNaissance("12.12.2012");
		System.out.println(userB.getPrenom());

		Moderateur modA = new Moderateur();
		modA.setNom("");
		modA.setPrenom("");
		modA.setPseudo("");
		modA.setVille("");
		modA.setDateNaissance("");
		modA.setMod(1); // changer le modo : 1 ou 2

		Menu menu = new Menu();
		menu.menu(modA);
		
		

	}
}
