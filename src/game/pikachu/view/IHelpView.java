/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.view;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

/**
 * The IHelpView interface assign method to HelpView class
 * 
 * @author Khanh
 */
public interface IHelpView {

	/**
	 * Add ActionListener for button Back
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnBackActionListener(ActionListener listener);

	/**
	 * Hide window
	 * 
	 * @param b
	 *            state of window, hidden or not hidden
	 */
	public void hideWindow(boolean b);

	/**
	 * Add window listener for HelpView window
	 * 
	 * @param listener
	 *            a WindowAdapter
	 */
	public void windowListener(WindowAdapter listener);

}
