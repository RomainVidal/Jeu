/**
 * Une armure protége des coups porté sur soi. Elle est defini par une defense
 * et un nom une armure par defaut est aussi disponible.
 */
public class Armor {

	/**
	 * Le nom de l'armure par defaut.
	 */
	public String DEFAULT_NAME = "Armure de cuir";
	/**
	 * La defense procurŽ par l'armure par defaut.
	 */
	public int DEFAULT_DEFENSE = 1;

	private String name;
	private int defense;

	/**
	 * L'armure par defaut, c'est une armure de cuir avec 1 de defense.
	 */
	public Armor() {
		this.name = "Armure de cuire";
		this.defense = 1;
	}

	/**
	 * Une armure un peu plus élaboré ou l'on choisi un nom et une defense.
	 * 
	 * @param startName
	 *            Le nom de la nouvelle armure.
	 * @param startDefense
	 *            La defense que procure la nouvelle armure.
	 * @throws ExceptionNegativeDefense
	 *             La defense de l'armure est negative, ce qui est impossible.
	 */
	public Armor(String startName, int startDefense)
			throws ExceptionNegativeDefense {
		if (startDefense < 0)
			throw new ExceptionNegativeDefense();
		this.defense = startDefense;
		this.name = startName;
	}

	/**
	 * @return le nom de l'armure.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return la defense procuré par l'armure.
	 */
	public int getDefense() {
		return this.defense;
	}

	@Override
	public String toString() {
		String armor = "";
		armor += this.name + " (" + this.defense + ")";
		return armor;
	}
}
