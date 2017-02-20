package game.pikachu.model;

import java.awt.Point;
import java.util.List;
import java.util.Stack;

/**
 * The IAlgorithm interface assign method to Algorithm class
 * 
 * @author Khanh
 *
 */
public interface IAlgorithm {

	/**
	 * Get array (map game)
	 * 
	 * @return an array (map game)
	 */
	public int[][] getArray();

	/**
	 * Set array (map game) for algorithm
	 * 
	 * @param array
	 *            an array (map game)
	 */
	public void setArray(int[][] array);

	/**
	 * Get list point from to draw line
	 * 
	 * @return a list point
	 */
	public List<Point> getListPoint();

	/**
	 * Check if two point is eat
	 * 
	 * @param i1
	 *            the row of the first point
	 * @param j1
	 *            the column of the first point
	 * @param i2
	 *            the row of the seconds point
	 * @param j2
	 *            the col of the seconds point
	 * @return true if
	 */
	public boolean check(int i1, int j1, int i2, int j2);

	/**
	 * Suggest a moved
	 * 
	 * @return a list point to draw suggest
	 */
	public List<Point> suggest();

	/**
	 * Swap map game when can not find a moved
	 */
	public void swap();

	/**
	 * Undo to the previous state
	 */
	public void undo();

	/**
	 * Redo to the following state
	 */
	public void redo();

	/**
	 * Add a StackPoint object to stack undo
	 * 
	 * @param p
	 *            a StackPoint object
	 */
	public void addStackUndo(StackPoint p);

	/**
	 * Add a StackPoint object to stack redo
	 * 
	 * @param p
	 *            a StackPoint object
	 */
	public void addStackRedo(StackPoint p);

	/**
	 * Get stack undo
	 * 
	 * @return stack undo
	 */
	public Stack<StackPoint> getStackUndo();

	/**
	 * Get stack redo
	 * 
	 * @return stack redo
	 */
	public Stack<StackPoint> getStackRedo();

	/**
	 * Move map game to the left
	 * 
	 * @param p1
	 *            the first point
	 * @param p2
	 *            the second point
	 */
	public void moveLeft(Point p1, Point p2);

	/**
	 * Move map game to the right
	 * 
	 * @param p1
	 *            the first point
	 * @param p2
	 *            the second point
	 */
	public void moveRight(Point p1, Point p2);

	/**
	 * Move map game to the top
	 * 
	 * @param p1
	 *            the first point
	 * @param p2
	 *            the second point
	 */
	public void moveTop(Point p1, Point p2);

	/**
	 * Move map game to the bottom
	 * 
	 * @param p1
	 *            the first point
	 * @param p2
	 *            the second point
	 */
	public void moveBottom(Point p1, Point p2);

	/**
	 * Check if map is empty
	 * 
	 * @return true if map is empty, false if otherwise
	 */
	public boolean checkEmpty();
}
