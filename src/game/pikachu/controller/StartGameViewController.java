package game.pikachu.controller;

import game.pikachu.view.IStartGameView;
import game.pikachu.view.StartGameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The StartGameViewController class controls StartGameView window
 *
 * @author Khanh
 */
public class StartGameViewController {

	private IStartGameView startGameView;
	private PlaySoundController playSoundController;

	/**
	 * The default constructor
	 */
	public StartGameViewController() {

		startGameView = new StartGameView();
		playSoundController = new PlaySoundController();
		playSoundController.playBackground();

		startGameView.btnPlayGameActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startGameView.hideWindow(true);
				new LevelGameViewController(startGameView, playSoundController);
			}
		});

		startGameView.btnHelpActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startGameView.hideWindow(true);
				new HelpViewController(startGameView);
			}
		});

		startGameView.btnQuitActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
