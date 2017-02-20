/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.controller;

import game.pikachu.model.IAlgorithm;
import game.pikachu.model.IInformation;
import game.pikachu.view.ILevelGameView;
import game.pikachu.view.IMainPanelView;
import game.pikachu.view.IMainView;
import game.pikachu.view.IStartGameView;
import game.pikachu.view.LevelGameView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * The LevelGameViewController class controls LevelGameView window
 *
 * @author Khanh
 */
public class LevelGameViewController {

	private ILevelGameView levelGameView;
	private IStartGameView startGameView;

	private IMainView mainView;
	private IMainPanelView mainPanelView;

	private IAlgorithm algorithm;
	private IInformation information;

	/**
	 * Construct newly LevelGameView object with parameter
	 *
	 * @param startGameView
	 *            start game window
	 * @param playSoundController
	 *            an object of PlaySoundController class
	 */
	public LevelGameViewController(IStartGameView startGameView, PlaySoundController playSoundController) {

		levelGameView = new LevelGameView();
		this.startGameView = startGameView;

		levelGameView.btnBackActionListener((ActionEvent e) -> {
			levelGameView.hideWindow(true);
			startGameView.hideWindow(false);
		});

		levelGameView.btnPlayActionListener((ActionEvent e) -> {
			int level = levelGameView.getLevelGame();
			if (level == 0) {
				JOptionPane.showMessageDialog(null, "Please select level!", "Select Level",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				levelGameView.hideWindow(true);
				new MainViewController(level, playSoundController, levelGameView);
			}
		});
	}

}
