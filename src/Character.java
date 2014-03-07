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

	private int life;
	private int mana;
	private int level;
	private String name;
	private Weapon weapon;
	private Armor armor;
	private Inventory inventory;
	private Coordinate coordinate;

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
		this.inventory = new Inventory();
		this.name = startName;
		Character.COUNT++;

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
		int damages = this.weapon.getDamage() * -1;
		damages -= character.armor.getDefense();
		if (damages > 0)
			damages = 0;
		character.alterLife(damages);
	}

	/**
	 * Inflige des d�g�ts au personnage en prennant en compte les degats inflig�
	 * et l'armure.
	 * 
	 * Ou ajoute de la vie au personnage.
	 * 
	 * @param variationLife
	 *            la vie qu'on souhaite ajouter ( avec plus ) ou retirer ( avec
	 *            moins ).
	 */
	public void alterLife(int variationLife) {
		this.life += variationLife;
		if (this.life < 0)
			this.life = 0;
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
	 * Ajoute un item � l'inventaire
	 * 
	 * @param newItem
	 *            l'item � ajouter a l'inventaire.
	 * @throws ExceptionFullInventory
	 *             L'objet n'a pas pu �tre ajouter, l'inventaire est plein.
	 */
	public void addInventoryItem(Item newItem) throws ExceptionFullInventory {
		this.inventory.addItem(newItem);
	}

	/**
	 * Utiliser une potion de vie.
	 * 
	 * @throws ExceptionNoItem
	 *             L'item n'a pas pu �tre trouv� dans l'inventaire.
	 */
	public void useHeathPotion() throws ExceptionNoItem {
		this.inventory.useHealthPotion(this);
	}

	/**
	 * Utiliser une potion de mana.
	 * 
	 * @throws ExceptionNoItem
	 *             L'item n'a pas pu �tre trouv� dans l'inventaire.
	 */
	public void useManaPotion() throws ExceptionNoItem {
		this.inventory.useManaPotion(this);
	}

	/**
	 * Le joueur se deplace sur la carte.
	 * 
	 * @param newPlayerCoordinate
	 *            les nouveaux coordonn�e du joueur
	 * @throws ExceptionCantMoving
	 *             Le joueur ne peut pas se deplacer au coordonn� rentr� en
	 *             param�tre.
	 */
	public void move(Coordinate newPlayerCoordinate) throws ExceptionCantMoving {
		this.coordinate = newPlayerCoordinate;
	}
	
	/**
	 * @return Les coordonn�es du personnage
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @return Une chaine de caract�re contenant l'inventaire.
	 */
	public String displayInvertory() {
		return this.inventory.toString();
	}

	@Override
	public String toString() {
		String character = "";
		character += "\t" + this.name + " (nv " + this.level + ")" + "\nvie : "
				+ this.life + " mana : " + this.mana + "\nArme : "
				+ this.weapon + " armure : " + this.armor + "\n";
		return character;
	}

}