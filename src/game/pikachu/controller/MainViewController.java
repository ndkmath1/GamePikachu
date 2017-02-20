package game.pikachu.controller;

import game.pikachu.model.Algorithm;
import game.pikachu.model.IAlgorithm;
import game.pikachu.model.IInformation;
import game.pikachu.model.GenerateMap;
import game.pikachu.model.Information;
import game.pikachu.view.ILevelGameView;
import game.pikachu.view.IMainView;
import game.pikachu.view.MainPanelView;
import game.pikachu.view.MainView;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import java.util.List;

/**
 * The MainViewController class controls MainView window
 *
 * @author Khanh
 */
public class MainViewController {

	private MainPanelView mainPanelView;
	private IMainView mainView;
	private GenerateMap map;
	private MainPanelViewController mainPanelViewController;
	private IAlgorithm algorithm;
	private IInformation information;
	private int[][] array;
	private Timer t;
	private int time;
	private int level;
	private ILevelGameView levelGameView;
	private PlaySoundController playSoundController;

	/**
	 * The default constructor
	 *
	 * @param level
	 *            level of game
	 * @param playSoundController
	 *            an object of PlaySoundController class
	 * @param levelGameView
	 *            level game view
	 */
	public MainViewController(int level, PlaySoundController playSoundController, ILevelGameView levelGameView) {
		this.playSoundController = playSoundController;
		this.level = level;
		this.levelGameView = levelGameView;
		switch (level) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			information = new Information(8, 12, 1, 8, 56, new Point(58 * 2, 58), 120, 0, 5);
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			information = new Information(10, 16, 1, 8, 56, new Point(0, 0), 60, 2, 5);
			break;
		default:
			break;
		}

		time = information.getSumTime();

		map = new GenerateMap(information);

		array = map.getArray();

		algorithm = new Algorithm(array, information);

		while (algorithm.suggest() == null) {
			algorithm.swap();
		}

		mainPanelView = new MainPanelView(array, information.getRows(), information.getCols(),
				information.getImageSize(), information.getPadding(), information.getPosition());

		mainPanelViewController = new MainPanelViewController(mainPanelView, algorithm, array, information, level,
				playSoundController);
		MainView mv = new MainView(mainPanelView, information.getNumSuggest());
		mainView = mv;
		mainPanelViewController.setMainView(mainView);
		mainPanelViewController.setMainViewController(this);

		mainView.btnSuggestActionListener((ActionEvent e) -> {
			List<Point> list = algorithm.suggest();
			if (list != null) {
				mainPanelView.setDrawSuggest(true);
				mainPanelView.setListPointSuggest(list);
				mainPanelView.update();
			}
		});

		// mainView.btnSwapActionListener((ActionEvent e) -> {
		// // set stack redo is empty
		// algorithm.getStackRedo().removeAllElements();
		// // swap at here
		// mainPanelView.setDrawSuggest(false);
		// algorithm.addStackUndo(new StackPoint(array, information.getRows(),
		// information.getCols()));
		// algorithm.swap();
		// mainPanelView.update();
		// });
		mainView.btnUndoActionListener((ActionEvent e) -> {
			// algorithm.addStackRedo(new StackPoint(array));
			algorithm.undo();
			mainView.setTextLabelScore("Score: " + getScore());
			mainPanelView.update();
		});

		mainView.btnRedoActionListener((ActionEvent e) -> {
			algorithm.redo();
			mainView.setTextLabelScore("Score: " + getScore());
			mainPanelView.update();
		});

		mainView.btnSoundItemListener((ItemEvent e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				playSoundController.turnOffSound();
				playSoundController.setIsPlay(false);
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				playSoundController.setIsPlay(true);
				playSoundController.playBackground();
			}
		});

		mainView.btnNewGameActionListener((ActionListener) -> {
			mainView.closeForm();
			levelGameView.update();
			levelGameView.hideWindow(false);
		});

		mainView.btnQuitActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showOptionDialog(mv, "Do you want exit?", "Exit", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if (input == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else if (input == JOptionPane.CANCEL_OPTION) {

				}

			}
		});

		mainView.setTextLabelScore("Score: 0");
		mainView.setTextLabelTime("Time: " + getMinute(time) + ":" + getSecond(time));
		t = new Timer(1000, (ActionEvent e) -> {
			if (time > 0) {
				time--;
				mainView.setTextLabelTime("Time: " + getMinute(time) + ":" + getSecond(time));
				if (getScore() == information.getCols() * information.getRows() * 5) {
					int input = JOptionPane.showOptionDialog(mv,
							"You Win!\nPlease enter OK to continue, Cancel to quit!", "Win",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (level < 10 && level == levelGameView.getMaxLevelGame()) {
						levelGameView.setMaxLevelGame(level + 1);
						writeData(level + 1);
					}
					if (input == JOptionPane.OK_OPTION) {
						// mainView.hideWindow(true);
						mainView.closeForm();
						levelGameView.update();
						levelGameView.hideWindow(false);
					} else if (input == JOptionPane.CANCEL_OPTION) {
						System.exit(0);
					} else {
						System.exit(0);
					}
					t.stop();
				}
			} else {
				int input = JOptionPane.showOptionDialog(mv, "Game Over!\nPress OK to play againt, Cancel to quit!",
						"Game Over", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if (input == JOptionPane.OK_OPTION) {
					// fr.dispose();
					// mainView.hideWindow(true);
					mainView.closeForm();
					levelGameView.hideWindow(false);
				} else if (input == JOptionPane.CANCEL_OPTION) {
					System.exit(0);
				} else {
					System.exit(0);
				}
				t.stop();
			}
		});
		t.start();

	}

	/**
	 * Get seconds from time
	 *
	 * @param time
	 *            sum time
	 * @return seconds from time
	 */
	private String getSecond(int time) {
		int ss = time % 60;
		if (ss >= 10) {
			return String.valueOf(ss);
		} else {
			return "0" + ss;
		}
	}

	/**
	 * Get minute from time
	 *
	 * @param time
	 *            sum time
	 * @return minute from time
	 */
	private String getMinute(int time) {
		int mm = time / 60;
		if (mm >= 10) {
			return String.valueOf(mm);
		} else {
			return "0" + mm;
		}
	}

	/**
	 * Get score of a level game
	 *
	 * @return score score of level
	 */
	public int getScore() {
		int score = 0;
		int rows = information.getRows();
		int cols = information.getCols();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (array[i][j] == 0) {
					score += 5;
				}
			}
		}
		return score;
	}

	/**
	 * Get time of a level game
	 *
	 * @return time total time of level
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Set time for a level game
	 *
	 * @param time
	 *            total time of a level
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Write number level to file
	 * 
	 * @param level
	 *            number level of game
	 */
	public void writeData(int level) {
		String fileName = "src/game/pikachu/level/level.txt";
		Path path = Paths.get(fileName);
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			for (int i = 0; i < level; i++) {
				writer.println("1");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
