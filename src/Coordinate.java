/**
 * @author Romain
 * Les coordonn�es sur la carte
 */
public class Coordinate {
	private int x = 0;
	private int y = 0;

	/**
	 * @return La coordonn�e X
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param newX La nouvelle coordonn�e X
	 */
	public void setX(int newX) {
		this.x = newX;
	}

	/**
	 * @return La coordonn�e Y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param newY La nouvelle coordonn�e Y
	 */
	public void setY(int newY) {
		this.y = newY;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
