/**
 * Un essai de création d'un jeu du genre RPG,
 * dans le but de voir comment marche Java
 * la doc, le code, GitHub, tous ça toussa...
 */

/**
 * @author Romain
 * Définie un personnage ( Joueur ou IA ) avec de la vie du mana et un niveau.
 */
public class Personnage {

	/**
	 * Vie par defaut ( au départ ou aprés un soin complet )
	 */
	public static final int DEFAULT_LIFE = 100;
	/**
	 * Mana par defaut ( au départ ou aprés un soin complet )
	 */
	public static final int DEFAULT_MANA = 100;
	/**
	 * Niveau par defaut
	 */
	public static final int DEFAULT_LEVEL = 1;
	
	private int life;
	private int mana;
	private int level;
	
	public Personnage() {
		this.level = DEFAULT_LEVEL;
		this.life = DEFAULT_LIFE;
		this.mana = DEFAULT_MANA;
	}
	
}
