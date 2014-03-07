/**
 * @author Romain
 * Les coordonnées sur la carte
 */
public class Coordinate {
	private int x = 0;
	private int y = 0;

	/**
	 * @return La coordonnée X
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param newX La nouvelle coordonnée X
	 */
	public void setX(int newX) {
		this.x = newX;
	}

	/**
	 * @return La coordonnée Y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param newY La nouvelle coordonnée Y
	 */
	public void setY(int newY) {
		this.y = newY;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
