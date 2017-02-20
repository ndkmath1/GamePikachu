package game.pikachu.controller;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import game.pikachu.model.Coordinate;
import game.pikachu.model.IAlgorithm;
import game.pikachu.model.ICoordinate;
import game.pikachu.model.IInformation;
import game.pikachu.model.StackPoint;
import game.pikachu.view.IMainView;
import game.pikachu.view.MainPanelView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

/**
 * The MainPanelViewController class controls MainPanelView
 *
 * @author Khanh
 */
public class MainPanelViewController {

	private ICoordinate coordinate;
	private IMainView mainView;
	private MainViewController mainViewController;
	// private IAlgorithm algo;

	/**
	 * Construct newly MainPanelViewController object with parameter
	 *
	 * @param mainPanelView
	 *            main panel
	 * @param algo
	 *            algorithm
	 * @param array
	 *            map of game
	 * @param information
	 *            information of game
	 * @param level
	 *            level of game
	 * @param playSoundController
	 *            a PlaySoundController object
	 */
	public MainPanelViewController(MainPanelView mainPanelView, IAlgorithm algo, int[][] array,
			IInformation information, int level, PlaySoundController playSoundController) {
		coordinate = new Coordinate(array, information);

		mainPanelView.addMouseListenerToMainPanel(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanelView.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanelView.setDrawSuggest(false);
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				int check = coordinate.setCoordinate(x, y);
				if (check == 1) {
					playSoundController.playPressed();
					mainPanelView.setDrawSquare(true);
					mainPanelView.setLocationSquare(new Point(coordinate.getP1().x, coordinate.getP1().y));
					mainPanelView.update();
				} else if (check == 2) {
					playSoundController.playPressed();
					if (algo.check(coordinate.getP1().x, coordinate.getP1().y, coordinate.getP2().x,
							coordinate.getP2().y)) {
						playSoundController.playHide();

						algo.addStackUndo(new StackPoint(array, information.getRows(), information.getCols()));
						array[coordinate.getP1().x][coordinate.getP1().y] = 0;
						array[coordinate.getP2().x][coordinate.getP2().y] = 0;
						algo.setArray(array);
						mainPanelView.setArray(array);
						coordinate.setArray(array);
						mainPanelView.setListPoint(algo.getListPoint());
						mainPanelView.update();
						new Thread(new LineController(mainPanelView)).start();
						switch (level) {
						case 1:
						case 6:
							break;
						case 2:
						case 7:
							algo.moveLeft(coordinate.getP1(), coordinate.getP2());
							break;
						case 3:
						case 8:
							algo.moveRight(coordinate.getP1(), coordinate.getP2());
							break;
						case 4:
						case 9:
							algo.moveTop(coordinate.getP1(), coordinate.getP2());
							break;
						case 5:
						case 10:
							algo.moveBottom(coordinate.getP1(), coordinate.getP2());
							break;
						default:
							break;
						}
						algo.getStackRedo().removeAllElements();
						coordinate.reset();
						mainView.setTextLabelScore("Score: " + mainViewController.getScore());
						mainViewController.setTime(mainViewController.getTime() + information.getAddTime());

						if (!algo.checkEmpty()) {
							while (algo.suggest() == null) {
								algo.swap();
								mainPanelView.update();
							}
						}

					} else {
						coordinate.reset();
					}
					mainPanelView.setDrawSquare(false);
				} else {
					mainPanelView.setDrawSquare(false);
				}
			}
		});

		mainPanelView.addMouseMotionListenerToMainPanel(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				Point p = coordinate.checkCoordinate(e.getX(), e.getY());
				mainPanelView.setLocationMouseMoved(p);
				mainPanelView.update();
			}
		});
	}

	/**
	 * Set main view for MainPanelViewController
	 *
	 * @param mainView
	 *            main view window
	 */
	public void setMainView(IMainView mainView) {
		this.mainView = mainView;
	}

	/**
	 * Set MainViewController for MainPanelViewController
	 *
	 * @param mainViewController
	 *            an object of MainViewController class
	 */
	public void setMainViewController(MainViewController mainViewController) {
		this.mainViewController = mainViewController;
	}

}
