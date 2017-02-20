package game.pikachu.model;

import java.awt.Point;

/**
 * The ICoordinate interface assign method to Coordinate class
 * 
 * @author Khanh
 *
 */
public interface ICoordinate {

	/**
	 * Set coordinate when game player clicked
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @return 1 if assign coordinate success for the first point, 2 if assign
	 *         coordinate success for the second point, 0 if otherwise
	 */
	public int setCoordinate(int x, int y);

	/**
	 * Check the coordinates in the map
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @return location if the coordinates is in the map, null if otherwise
	 */
	public Point checkCoordinate(int x, int y);

	/**
	 * Get the first point
	 * 
	 * @return a Point object
	 */
	public Point getP1();

	/**
	 * Set the first point
	 * 
	 * @param p1
	 *            a Point object
	 */
	public void setP1(Point p1);

	/**
	 * Get the second point
	 * 
	 * @return a Point object
	 */
	public Point getP2();

	/**
	 * Set the second point
	 * 
	 * @param p2
	 *            a Point object
	 */
	public void setP2(Point p2);

	/**
	 * Reset the first point and the second point to (-1, -1)
	 */
	public void reset();

	/**
	 * Set array (map game)
	 * 
	 * @param array
	 *            an array
	 */
	public void setArray(int[][] array);
}
