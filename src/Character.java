/**
 * @author Romain Définie un personnage ( Joueur ou IA ) avec de la vie, du
 *         mana, un niveau et une arme.
 */
public class Character {

	/**
	 * Nombre d'objets personnages créés.
	 */
	public static int COUNT = 0;
	/**
	 * Vie par defaut ( au départ ou aprés un soin complet ).
	 */
	public static final int DEFAULT_LIFE = 100;
	/**
	 * Mana par defaut ( au départ ou aprés un soin complet ).
	 */
	public static final int DEFAULT_MANA = 100;
	/**
	 * Niveau par defaut.
	 */
	public static final int DEFAULT_LEVEL = 1;
	/**
	 * Taille de l'inventaire par defaut.
	 */

	private int life;
	private int mana;
	private int level;
	private String name;
	private Weapon weapon;
	private Armor armor;
	private Inventory inventory;

	/**
	 * Crée un personnage avec un niveau par defaut, une vie par defaut, un
	 * mana, une armure et une arme par defaut et met à jour le compteur de
	 * personnage.
	 * 
	 * @param startName
	 *            Le nom du personnage.
	 */
	public Character(String startName) {
		this.level = DEFAULT_LEVEL;
		this.life = DEFAULT_LIFE;
		this.mana = DEFAULT_MANA;
		this.weapon = new Weapon();
		this.armor = new Armor();
		this.inventory = new Inventory();
		this.name = startName;
		Character.COUNT++;

	}

	/**
	 * Equipe le personnage d'une arme.
	 * 
	 * @param newWeapon
	 *            Arme à équiper.
	 */
	public void changeWeapon(Weapon newWeapon) {
		this.weapon = newWeapon;
	}

	/**
	 * Equipe le personnage d'une armure.
	 * 
	 * @param newArmor
	 *            Armure à equiper.
	 */
	public void changeArmor(Armor newArmor) {
		this.armor = newArmor;
	}

	/**
	 * On attaque et on touche un personnage ( rien n'interdit de se frapper
	 * soi-même)
	 * 
	 * @param character
	 *            le personnage que l'on attaque.
	 */
	public void doDamage(Character character) {
		int damages = this.weapon.getDamage() * -1;
		character.alterLife(damages);
	}

	/**
	 * Inflige des dég‰ts au personnage en prennant en compte les degats infligé
	 * et l'armure.
	 * 
	 * Ou ajoute de la vie au personnage.
	 * 
	 * @param variationLife
	 *            la vie qu'on souhaite ajouter ( avec plus ) ou retirer ( avec
	 *            moins ).
	 */
	public void alterLife(int variationLife) {
		if (variationLife < 0) {
			if ((variationLife + this.armor.getDefense()) < 0)
				this.life += variationLife + this.armor.getDefense();
			if (this.life < 0)
				this.life = 0;
		} else
			this.life += variationLife;
	}

	/**
	 * Modifie le mana du personnage.
	 * 
	 * @param variationMana
	 *            qu'on souhaite ajouter ( avec plus ) ou retirer ( avec moins
	 *            ).
	 */
	public void alterMana(int variationMana) {
		this.mana += variationMana;
	}

	/**
	 * @return Vrai si le personnage est vivant.
	 */
	public boolean isAlive() {
		return (this.life > 0);
	}

	/**
	 * Ajoute un item à l'inventaire
	 * 
	 * @param newItem
	 *            l'item à ajouter a l'inventaire.
	 */
	public void addInventoryItem(Item newItem) {
		try {
			this.inventory.addItem(newItem);
		} catch (ExceptionFullInventory e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utiliser une potion de vie.
	 */
	public void useHeathPotion() {
		try {
			this.inventory.useHealthPotion(this);
		} catch (ExceptionNoItem e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utiliser une potion de mana.
	 */
	public void useManaPotion() {
		try {
			this.inventory.useManaPotion(this);
		} catch (ExceptionNoItem e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String character = "";
		character += "\t" + this.name + " (nv " + this.level + ")" + "\nvie : "
				+ this.life + " mana : " + this.mana + "\nArme : "
				+ this.weapon + " armure : " + this.armor + "\n"
				+ this.inventory.toString();
		return character;
	}

}