/**
 * Une arme permet au personnage d'infliger des d�gats aux autres personnages
 * elle fait un certain nombre de d�gats et poss�de un nom.
 */
public class Weapon {

	private String name;
	private int damage;

	/**
	 * Une arme par defaut. Cette �p�e de bois fait 10 de d�gats.
	 */
	public Weapon() {
		this.name = "�p�e de bois";
		this.damage = 10;
	}

	/**
	 * Une arme dont on peut choisir les parametres.
	 * 
	 * @param startName
	 *            Le nom de l'arme
	 * @param startDamage
	 *            les dommages que va infliger l'arme cr�e.
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
	 * @return les d�g�ts que va infliger l'arme.
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
