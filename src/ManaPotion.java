
/**
 * @author Romain
 *
 * Une potion de mana qui rend du mana
 */
public class ManaPotion extends Item{

	/**
	 * L'efficatitŽ par defaut de la potion
	 */
	public int DEFAULT_EFFICIENCY = 30;
	
	private int efficiency;
	
	/**
	 * Une potion de mana simple avec une efficacité par defaut.
	 */
	public ManaPotion() {
		this.efficiency = DEFAULT_EFFICIENCY;
	}

	/**
	 * Une potion de mana simple.
	 * 
	 * @param newEfficiency
	 *            l'efficacité de la potion.
	 */
	public ManaPotion(int newEfficiency) {
		this.efficiency = newEfficiency;
	}
	
	@Override
	public void use(Character character) {
		character.alterMana(this.efficiency);
	}

	@Override
	public String toString() {
		return "ManaPotion (" + this.efficiency + ")";
	}


}
