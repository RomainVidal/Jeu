/**
 * Une arme permet au personnage d'infliger des d�gats aux autres personnages
 * elle fait un certain nombre de d�gats et poss�de un nom.
 */
public class Weapon {

	/**
	 * Nom par defaut d'une arme.
	 */
	public String DEFAULT_NAME = "Ep�e de bois";

	/**
	 * D�g�ts d'une arme par defaut.
	 */
	public int DEFAULT_DAMAGE = 50;

	private String name;
	private int damage;

	/**
	 * Une arme par defaut.
	 */
	public Weapon() {
		this.name = DEFAULT_NAME;
		this.damage = DEFAULT_DAMAGE;
	}

	/**
	 * Une arme dont on peut choisir les parametres.
	 * 
	 * @param startName
	 *            Le nom de l'arme
	 * @param startDamage
	 *            les dommages que va infliger l'arme cr�e.
	 * @throws ExceptionNegativeDamage
	 *             Les dommage inflig� par l'arme son n�gatif. Ce qui est
	 *             impossible.
	 */
	public Weapon(String startName, int startDamage)
			throws ExceptionNegativeDamage {
		if (this.damage < 0)
			throw new ExceptionNegativeDamage();
		this.name = startName;
		this.damage = startDamage;
	}

	/**
	 * @return le nom de l'arme.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return les d�g�ts que va infliger l'arme.
	 */
	public int getDamage() {
		return this.damage;
	}

	@Override
	public String toString() {
		String weapon = "";
		weapon += this.name + " (" + this.damage + ")";
		return weapon;
	}
}