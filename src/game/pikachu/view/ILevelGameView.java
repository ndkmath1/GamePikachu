/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.view;

import java.awt.event.ActionListener;

/**
 * The ILevelGameView interface assign method to LevelGameView window
 * 
 * @author Khanh
 */
public interface ILevelGameView {

	/**
	 * Add ActionListener to button Back
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnBackActionListener(ActionListener listener);

	/**
	 * Add ActionListener to button Play
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnPlayActionListener(ActionListener listener);

	/**
	 * Hide window
	 * 
	 * @param b
	 *            state of window, hidden or not hidden
	 */
	public void hideWindow(boolean b);

	/**
	 * Get level of game
	 * 
	 * @return level of game
	 */
	public int getLevelGame();

	/**
	 * Update icon for level game
	 */
	public void update();

	/**
	 * Get number level game open
	 * 
	 * @return number level game open
	 */
	public int getMaxLevelGame();

	/**
	 * Set number level game open
	 * 
	 * @param maxLevelGame
	 *            number level game open
	 */
	public void setMaxLevelGame(int maxLevelGame);
}
