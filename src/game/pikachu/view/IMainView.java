package game.pikachu.view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * The IMainView interface assign method to MainView window
 * 
 * @author Khanh
 *
 */
public interface IMainView {

	/**
	 * Add ActionListener to button Suggest
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnSuggestActionListener(ActionListener listener);

	/**
	 * Add ActionListenr to button Undo
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnUndoActionListener(ActionListener listener);

	/**
	 * Add ActionListener to button Redo
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnRedoActionListener(ActionListener listener);

	/**
	 * Add ItemListener to button Sound
	 * 
	 * @param listener
	 *            an ItemListener
	 */
	public void btnSoundItemListener(ItemListener listener);
        
        /**
         * Add ActionListener to button New Game
         * @param listener an Action Listener
         */
        public void btnNewGameActionListener(ActionListener listener);

	/**
	 * Add ActionListener to button Quit
	 * 
	 * @param listener
	 *            an ActionListener
	 */
	public void btnQuitActionListener(ActionListener listener);

	/**
	 * Set text for label score
	 * 
	 * @param str
	 *            score
	 */
	public void setTextLabelScore(String str);

	/**
	 * Set text for label time
	 * 
	 * @param str
	 *            time
	 */
	public void setTextLabelTime(String str);

	/**
	 * Set window hidden
	 * 
	 * @param b
	 *            state of window, hidden or not hidden
	 */
	public void hideWindow(boolean b);

	/**
	 * Close window
	 */
	public void closeForm();

}
