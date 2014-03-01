/**
 * Une potion de vie qui permet de rajouter de la vie au personnage qui
 * l'utilise. Elle est d�fini par une efficacit�.
 * 
 */
public class HealthPotion extends Item{

	private int efficiency;

	/**
	 * Une potion de vie simple avec une efficacit� par defaut.
	 */
	public HealthPotion() {
		this.efficiency = 30;
	}

	/**
	 * Une potion de vie simple.
	 * 
	 * @param newEfficiency
	 *            l'efficacit� de la potion.
	 */
	public HealthPotion(int newEfficiency) {
		this.efficiency = newEfficiency;
	}

	/**
	 * @return l'efficacit� de la potion.
	 */
	public int getEfficiency() {
		return this.efficiency;
	}

}
