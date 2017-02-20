/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.model;

/**
 * The StackPoint class store state of map game
 *
 * @author Khanh
 */
public class StackPoint {

	private int[][] array;
	private int rows;
	private int cols;

	/**
	 * Construct newly StackPoint with parameter
	 * 
	 * @param array
	 *            an array
	 * @param rows
	 *            number rows of map game
	 * @param cols
	 *            number columns of map game
	 */
	public StackPoint(int[][] array, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.setArray(array);
	}

	/**
	 * Get array (map game)
	 * 
	 * @return an array
	 */
	public int[][] getArray() {
		return array;
	}

	/**
	 * Set array (map game)
	 * 
	 * @param array
	 *            an array
	 */
	public void setArray(int[][] array) {
		this.array = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.array[i][j] = array[i][j];
			}
		}
	}
}
