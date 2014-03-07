import java.util.Scanner;

/**
 * @author Romain Un tour du jeu pour un personnage.
 */
public class PlayATurn {
	private static Scanner scanner;

	/**
	 * Joue un tour, avec un joueur et une cible. Le joueur peut attaquer,
	 * changer son equipement ou boire des potions.
	 * 
	 * @param player
	 *            le personnage ne train de jouer.
	 * @param target
	 *            la cible du personnage.
	 */
	public static void play(Character player, Character target) {
		scanner = new Scanner(System.in);
		int choice;
		System.out.println("-----Menu-----\n" + "1: Attaquer\n"
				+ "2: Changer d'armure\n" + "3: Changer d'arme\n"
				+ "4 : Inventaire\n" + "--------------");
		choice = scanner.nextInt();

		switch (choice) {
		case 1:
			player.doDamage(target);
			break;
		case 2:
			changeArmor(player, target);
			break;
		case 3:
			changeWeapon(player, target);
			break;
		case 4:
			goToInventory(player);
			break;
		default:
			break;
		}
	}

	private static void goToInventory(Character player) {
		System.out.println(player.displayInvertory());

		scanner = new Scanner(System.in);
		System.out.println("-----Menu-----\n1: Utiliser une potion de vie"
				+ "\n2: Utiliser une potion de mana"
				+ "\nAutre: Ne rien faire.\n" + "--------------");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			try {
				player.useHeathPotion();
			} catch (ExceptionNoItem e) {
				System.out.println("Vous n'avez plus de potion de vie.");
			}
			break;
		case 2:
			try {
				player.useManaPotion();
			} catch (ExceptionNoItem e) {
				System.out.println("Vous n'avez plus de potion de mana.");
			}
			break;
		default:
			break;
		}

	}

	private static void changeWeapon(Character player, Character target) {
		scanner = new Scanner(System.in);
		System.out.println("Nom de l'arme :");
		String name = scanner.next();
		System.out.println("Dégâts :");
		int power = scanner.nextInt();
		try {
			player.changeWeapon(new Weapon(name, power));
		} catch (ExceptionNegativeDamage e) {
			System.out.println("Les caractéristique de l'arme sont invalides.");
		}

	}

	private static void changeArmor(Character player, Character target) {
		scanner = new Scanner(System.in);
		System.out.println("Nom de l'armure :");
		String name = scanner.next();
		System.out.println("Défense :");
		int power = scanner.nextInt();
		try {
			player.changeArmor(new Armor(name, power));
		} catch (ExceptionNegativeDefense e) {
			System.out
					.println("Les caractéristique de l'armure sont invalide.");
		}

	}
}
