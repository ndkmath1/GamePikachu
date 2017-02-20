/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.model;

/**
 * The IGenerateMap interface assign method to GenerateMap class
 * 
 * @author Khanh
 */
public interface IGenerateMap {

	/**
	 * Get array (map game)
	 * 
	 * @return an array
	 */
	public int[][] getArray();

	/**
	 * Set array (map game)
	 * 
	 * @param array
	 *            an array
	 */
	public void setArray(int[][] array);
        
}
