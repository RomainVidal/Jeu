/**
 * Une potion de vie qui permet de rajouter de la vie au personnage qui
 * l'utilise. Elle est défini par une efficacité.
 * 
 */
public class HealthPotion extends Item{

	/**
	 */
	public int DEFAULT_EFFICIENCY = 30;
	
	private int efficiency;

	/**
	 * Une potion de vie simple avec une efficacité par defaut.
	 */
	public HealthPotion() {
		this.efficiency = DEFAULT_EFFICIENCY;
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

	@Override
	public void use(Character character) {
		character.alterLife(this.efficiency);
	}

	@Override
	public String toString() {
		return "HealthPotion (" + this.efficiency + ")";
	}

}