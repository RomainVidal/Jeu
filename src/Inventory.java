import java.util.Arrays;

/**
 * @author Romain
 * 
 * Un inventaire, il peut contenir un certain nombre d'item.
 */
public class Inventory {

	/**
	 * La taille maximal de l'inventaire.
	 */
	private static final int DEFAULT_INVENTORY_SIZE = 10;

	private Item[] bag;

	/**
	 * Un inventaire de taille par defaut qui ne contient rien.
	 */
	public Inventory(){
		
		this.bag = new Item[DEFAULT_INVENTORY_SIZE];
		
		for (int i = 0; i < DEFAULT_INVENTORY_SIZE; i++) {
			this.bag[i] = null;
		}
	}

	/**
	 * Ajoute un item à l'inventaire
	 * 
	 * @param newItem
	 *            l'item à ajouter a l'inventaire.
	 * @throws ExceptionFullInventory L'inventaire est plein, impossible d'ajouter un item.
	 */
	public void addItem(Item newItem) throws ExceptionFullInventory {
		int i = 0;
		while (i < DEFAULT_INVENTORY_SIZE && this.bag[i] != null)
			i++;
		if(i == DEFAULT_INVENTORY_SIZE) throw new ExceptionFullInventory();
		if (this.bag[i] == null)
			this.bag[i] = newItem;
	}

	/**
	 * Le personnage utilise une potion de vie.
	 * 
	 * @param character Le personnage qui reçoit la potion.
	 * @throws ExceptionNoItem L'item n'a pas pu être trouvé.
	 */
	public void useHealthPotion(Character character) throws ExceptionNoItem {
		int i = 0;
		while (i < DEFAULT_INVENTORY_SIZE && !(this.bag[i] instanceof HealthPotion) )
			i++;
		if(i == DEFAULT_INVENTORY_SIZE) throw new ExceptionNoItem();
		this.bag[i].use(character);
		this.bag[i] = null;
	}

	/**
	 * Le personnage utilise une potion de mana.
	 * 
	 * @param character Le personnage qui reçoit la potion.
	 * @throws ExceptionNoItem L'item n'a pas pu être trouvé.
	 */
	public void useManaPotion(Character character) throws ExceptionNoItem {
		int i = 0;
		while (i < DEFAULT_INVENTORY_SIZE && !(this.bag[i] instanceof ManaPotion) )
			{i++;}
		if(i == DEFAULT_INVENTORY_SIZE) throw new ExceptionNoItem();
		this.bag[i].use(character);
		this.bag[i] = null;
		
	}

	@Override
	public String toString() {
		return "Inventaire [" + Arrays.toString(this.bag) + "]";
	}

}