package game.pikachu.controller;

import game.pikachu.view.IMainPanelView;

/**
 * The LineController class controls draw line (when two points can eat) for
 * MainPanelView
 *
 * @author Khanh
 */
public class LineController implements Runnable {

	private IMainPanelView mainPanelView;
	private long delay = 100L;

	/**
	 * Construct newly LineController object with parameter
	 *
	 * @param mainPanelView
	 *            main panel
	 */
	public LineController(IMainPanelView mainPanelView) {
		this.mainPanelView = mainPanelView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		mainPanelView.setDrawLine(true);
		mainPanelView.update();
		sleep(delay);
		mainPanelView.setDrawLine(false);
		mainPanelView.update();
	}

	/**
	 * Sleep thread in delay milliseconds
	 *
	 * @param delay
	 *            time delay (seconds)
	 */
	private void sleep(long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
