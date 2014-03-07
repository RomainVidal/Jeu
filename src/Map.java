/**
 * @author Romain La carte du monde, sur laquelle le joueur se déplace. Elle est
 *         composé de case qui on un certain type de terrain
 */
public class Map {

	/**
	 * Longeur de la carte par defaut.
	 */
	public static final int DEFAULT_Y_MAP_SIZE = 10;
	/**
	 * Largeur de la carte par defaut.
	 */
	public static final int DEFAULT_X_MAP_SIZE = 10;

	private Ground[][] map;

	/**
	 * Toute les cases de la carte sont de type plaine.
	 */
	public Map() {
		map = new Ground[DEFAULT_X_MAP_SIZE][DEFAULT_Y_MAP_SIZE];
		for (int i = 0; i < DEFAULT_X_MAP_SIZE; i++)
			for (int j = 0; j < DEFAULT_Y_MAP_SIZE; j++)
				map[i][j] = Ground.plain;
	}

	/**
	 * Renvoi le terrain contenu dans une case
	 * 
	 * @param x
	 *            La coordonnée X sur la carte de la case que l'on souhaite voir
	 * @param y
	 *            La coordonnée Y sur la carte de la case que l'on souhaite voir
	 * @return Le terrain à la coordonnée rentré en paramétre.
	 * @throws ExceptionCoordinateNotExist
	 *             Les coordonnées entrés en paramétre n'existe pas
	 */
	public Ground getGround(int x, int y) throws ExceptionCoordinateNotExist {
		if (x > DEFAULT_X_MAP_SIZE || x <= 0 || y > DEFAULT_Y_MAP_SIZE || y <= 0)
			throw new ExceptionCoordinateNotExist();
		return map[x][y];
	}

	@Override
	public String toString() {
		String asciiMap = "";

		for (int i = 0; i < DEFAULT_X_MAP_SIZE; i++) {
			asciiMap += "\n";
			for (int j = 0; j < DEFAULT_Y_MAP_SIZE; j++)
				if (map[i][j] == Ground.plain)
					asciiMap += "p";
		}

		return asciiMap;
	}
}
