/**
 * Une arme permet au personnage d'infliger des dêgats aux autres personnages
 * elle fait un certain nombre de dégats et posséde un nom.
 */
public class Weapon {

	private String name;
	private int damage;

	/**
	 * Une arme par defaut. Cette épée de bois fait 10 de dégats.
	 */
	public Weapon() {
		this.name = "épée de bois";
		this.damage = 10;
	}

	/**
	 * Une arme dont on peut choisir les parametres.
	 * 
	 * @param startName
	 *            Le nom de l'arme
	 * @param startDamage
	 *            les dommages que va infliger l'arme crée.
	 */
	public Weapon(String startName, int startDamage) {
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
	 * @return les dégâts que va infliger l'arme.
	 */
	public int getDamage() {
		return this.damage;
	}
	
	public String toString(){
		String weapon = "";
		weapon += this.name + " (" + this.damage + ")";
		return weapon;
	}
}
