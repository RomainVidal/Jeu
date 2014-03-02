/**
 * Un objet pouvant �tre utilis�, comme par exemple une potion.
 */
public abstract class Item {

	/**
	 * Utiliser un item.
	 * 
	 * @param character le personnage qui l'utilise.
	 */
	public abstract void use(Character character);
	
}