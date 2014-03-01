/**
 * @author Romain D�finie un personnage ( Joueur ou IA ) avec de la vie, du
 *         mana, un niveau et une arme.
 */
public class Character {

	/**
	 * Nombre d'objets personnages cr��s.
	 */
	public static int COUNT = 0;
	/**
	 * Vie par defaut ( au d�part ou apr�s un soin complet ).
	 */
	public static final int DEFAULT_LIFE = 100;
	/**
	 * Mana par defaut ( au d�part ou apr�s un soin complet ).
	 */
	public static final int DEFAULT_MANA = 100;
	/**
	 * Niveau par defaut.
	 */
	public static final int DEFAULT_LEVEL = 1;
	/**
	 * Taille de l'inventaire par defaut.
	 */
	private static final int DEFAULT_INVENTORY_SIZE = 0;

	private int life;
	private int mana;
	private int level;
	private String name;
	private Weapon weapon;
	private Armor armor;

	private Item[] inventory;

	/**
	 * Cr�e un personnage avec un niveau par defaut, une vie par defaut, un
	 * mana, une armure et une arme par defaut et met � jour le compteur de
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
		this.name = startName;
		Character.COUNT++;

		for (int i = 0; i < DEFAULT_INVENTORY_SIZE; i++) {
			this.inventory[i] = null;
		}
	}

	/**
	 * Equipe le personnage d'une arme.
	 * 
	 * @param newWeapon
	 *            Arme � �quiper.
	 */
	public void changeWeapon(Weapon newWeapon) {
		this.weapon = newWeapon;
	}

	/**
	 * Equipe le personnage d'une armure.
	 * 
	 * @param newArmor
	 *            Armure � equiper.
	 */
	public void changeArmor(Armor newArmor) {
		this.armor = newArmor;
	}

	/**
	 * On attaque et on touche un personnage ( rien n'interdit de se frapper
	 * soi-m�me)
	 * 
	 * @param character
	 *            le personnage que l'on attaque.
	 */
	public void doDamage(Character character) {
		character.getDamage(this.weapon.getDamage());
	}

	/**
	 * Inflige des d�g�ts au personnage en prennant en compte les degats inflig�
	 * et l'armure.
	 * 
	 * @param damage
	 *            le nombre de d�g�t subit.
	 */
	public void getDamage(int damage) {
		if ((damage - this.armor.getDefense()) > 0)
			this.life -= damage - this.armor.getDefense();
		if (this.life < 0)
			this.life = 0;
	}

	/**
	 * Ajouter un item � l'inventaire
	 * 
	 * @param newItem
	 *            l'item � ajouter a l'inventaire.
	 */
	public void addItem(Item newItem) {
		int i = 0;
		while (i < DEFAULT_INVENTORY_SIZE && this.inventory[i] == null)
			i++;
		// TODO Ne marche pas :/ NullPointerExeption
		if (this.inventory[i] == null)
			this.inventory[i] = newItem;
	}

	/**
	 * @return Vrai si le personnage est vivant.
	 */
	public boolean isAlive() {
		return (this.life > 0);
	}

	public String toString() {
		String character = "";
		character += "\t" + this.name + " (nv " + this.level + ")" + "\nvie : "
				+ this.life + " mana : " + this.mana + "\nArme : "
				+ this.weapon + " armure : " + this.armor;
		return character;
	}

}