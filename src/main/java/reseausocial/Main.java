package reseausocial;


public class Main {
	
	public static void main(String[] args) {
		Users userA = new Users();
		userA.setNom("Smith");
		userA.setPrenom("Sam");
		userA.setPseudo("Samsam");
		userA.setVille("Annecy");
		System.out.println(userA.getPrenom());
		
		Users userB = new Users();
		userB.setNom("Maurte");
		userB.setPrenom("Adele");
		userB.setPseudo("Helloitsme");
		userB.setVille("Londres");
		System.out.println(userB.getPrenom());
		
		Moderateur modA = new Moderateur();
		modA.setNom("");
		modA.setPrenom("");
		modA.setPseudo("");
		modA.setVille("");
		modA.setMod(2);
		
		Menu menu = new Menu();
		menu.menu(modA);
		
	
		
		
		
 	
		}
}
