package game.pikachu.view;

import java.awt.event.ActionListener;

/**
 * The IStartGameView interface assign method to StartGameView window
 * 
 * @author Khanh
 *
 */
public interface IStartGameView {

	/**
	 * Add ActionListener to button Play Game
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnPlayGameActionListener(ActionListener listener);

	/**
	 * Add ActionListener to button Help
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnHelpActionListener(ActionListener listener);

	/**
	 * Add ActionListener to button Quit
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnQuitActionListener(ActionListener listener);

	/**
	 * Set window hidden
	 * 
	 * @param b
	 *            state of window, hidden or not hidden
	 */
	public void hideWindow(boolean b);
}
