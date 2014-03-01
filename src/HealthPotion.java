/**
 * Une potion de vie qui permet de rajouter de la vie au personnage qui
 * l'utilise. Elle est défini par une efficacité.
 * 
 */
public class HealthPotion extends Item{

	private int efficiency;

	/**
	 * Une potion de vie simple avec une efficacité par defaut.
	 */
	public HealthPotion() {
		this.efficiency = 30;
	}

	/**
	 * Une potion de vie simple.
	 * 
	 * @param newEfficiency
	 *            l'efficacité de la potion.
	 */
	public HealthPotion(int newEfficiency) {
		this.efficiency = newEfficiency;
	}

	/**
	 * @return l'efficacité de la potion.
	 */
	public int getEfficiency() {
		return this.efficiency;
	}

}
