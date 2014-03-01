import java.util.Scanner;

/**
 * Un essai de création d'un jeu du genre RPG, dans le but de voir comment
 * marche Java la doc, le code, GitHub, tout ça toussa...
 */

public class Game {

	private static Scanner sc;

	@SuppressWarnings("javadoc")
	public static void main(final String[] args) {
		Character romain = new Character("Romain");
		Character lucas = new Character("Lucas");
		HealthPotion potion = new HealthPotion();
		romain.addItem(potion);
		while (romain.isAlive() && lucas.isAlive()) {
			System.out.println("Joueur 1");
			Game.jouer(romain, lucas);
			System.out.println("Joueur 2");
			Game.jouer(lucas, romain);
			System.out.println(romain);
			System.out.println(lucas);
		}
	}

	/**
	 * Un tour de jeu, avec un joueur et une cible. Le joueur peut attaquer,
	 * changer son equipement ou boire des potions.
	 * 
	 * @param player
	 *            le personnage ne train de jouer.
	 * @param target
	 *            la cible du personnage.
	 */
	public static void jouer(Character player, Character target) {
		sc = new Scanner(System.in);
		int choice;
		String name = "";
		int power = 10;
		System.out.println("Joueur1 :\n");
		System.out
				.println("1: Attaquer\n2: Changer d'armure\n3: Changer d'arme");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			player.doDamage(target);
			break;
		case 2:
			System.out.println("Nom de l'armure :");
			name = sc.next();
			System.out.println("Défense :");
			power = sc.nextInt();
			player.changeArmor(new Armor(name, power));
			break;
		case 3:
			System.out.println("Nom de l'arme :");
			name = sc.next();
			System.out.println("Dégâts :");
			power = sc.nextInt();
			player.changeWeapon(new Weapon(name, power));
			break;
		default:
			break;
		}
	}

}