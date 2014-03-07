/**
 * Un essai de création d'un jeu du genre RPG, dans le but de voir comment
 * marche Java la doc, le code, GitHub, tout ça toussa...
 */

public class Game {

	@SuppressWarnings("javadoc")
	public static void main(final String[] args) {
		Character romain = new Character("Romain");
		Character lucas = new Character("Lucas");

		HealthPotion potion = new HealthPotion();
		try {
			romain.addInventoryItem(potion);
		} catch (ExceptionFullInventory e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (romain.isAlive() && lucas.isAlive()) {
			System.out.println("Joueur 1");
			PlayATurn.play(romain, lucas);
			System.out.println("Joueur 2");
			PlayATurn.play(lucas, romain);
			System.out.println(romain);
			System.out.println(lucas);
		}
		if (romain.isAlive())
			System.out.println("Fin du jeu ! Romain à gagné !");
		else if (lucas.isAlive())
			System.out.println("Fin du jeu ! Lucas à gagné !");
		else
			System.out.println("Fin du jeu ! Egalité !");
	}

}