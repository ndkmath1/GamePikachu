package game.pikachu.view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

/**
 * The IMainPanelView interface assign method to MainPanelView class
 *
 * @author Khanh
 */
public interface IMainPanelView {

	/**
	 * Add MouseListener for MainPanelView
	 *
	 * @param listener
	 *            a MouseAdapter
	 */
	public void addMouseListenerToMainPanel(MouseAdapter listener);

	/**
	 * Add MouseMotionListener for MainPanelView
	 *
	 * @param listener
	 *            a MouseMotionListener
	 */
	public void addMouseMotionListenerToMainPanel(MouseMotionAdapter listener);

	/**
	 * Get array of MainPanelView
	 *
	 * @return an array
	 */
	public int[][] getArray();

	/**
	 * Set array for MainPanelView
	 *
	 * @param array
	 *            an array
	 */
	public void setArray(int[][] array);

	/**
	 * Call repaint MainPanelView
	 */
	public void update();

	/**
	 * Set location when mouse moved
	 *
	 * @param p
	 *            position mouse moved
	 */
	public void setLocationMouseMoved(Point p);

	/**
	 * Set location when mouse pressed
	 *
	 * @param p
	 *            position mouse pressed
	 */
	public void setLocationSquare(Point p);

	/**
	 * Set draw line for MainPanelView
	 *
	 * @param b
	 *            state draw line (true or false)
	 */
	public void setDrawLine(boolean b);

	/**
	 * Set draw square for MainPanelView
	 *
	 * @param b
	 *            state draw quare when mouse moved (true or false)
	 */
	public void setDrawSquare(boolean b);

	/**
	 * Set draw suggest for MainPanelView
	 *
	 * @param b
	 *            state draw suggestions (true or false)
	 */
	public void setDrawSuggest(boolean b);

	/**
	 * Set list point to draw line
	 *
	 * @param listPoint
	 *            a list point
	 */
	public void setListPoint(List<Point> listPoint);

	/**
	 * Set list point to draw suggest
	 *
	 * @param listPointSuggest
	 *            a list point
	 */
	public void setListPointSuggest(List<Point> listPointSuggest);

	/**
	 * Set path for folder that hold image
	 *
	 * @param str
	 *            path of folder
	 */
	public void setPath(String str);

	/**
	 * Get path of folder that hold image
	 *
	 * @return path of folder
	 */
	public String getPath();
        
	/**
	 * Draw when mouse moved
	 */
    public void drawMouseMoved();

}
