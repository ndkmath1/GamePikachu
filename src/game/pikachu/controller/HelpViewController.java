/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.controller;

import game.pikachu.view.HelpView;
import game.pikachu.view.IHelpView;
import game.pikachu.view.IStartGameView;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The HelpViewController class controls HelpView window
 *
 * @author Khanh
 */
public class HelpViewController {

	private IHelpView helpView;
	private IStartGameView startGameView;

	/**
	 * Construct newly HelpViewController object with parameter
	 *
	 * @param startGameView
	 *            start game window
	 */
	public HelpViewController(IStartGameView startGameView) {

		helpView = new HelpView();
		this.startGameView = startGameView;

		helpView.btnBackActionListener((ActionEvent e) -> {
			helpView.hideWindow(true);
			startGameView.hideWindow(false);
		});

		helpView.windowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				helpView.hideWindow(true);
				startGameView.hideWindow(false);
			}
		});
	}
}
