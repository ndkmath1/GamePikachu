package game.pikachu.controller;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The PlaySoundController class controls play sound
 *
 * @author Khanh
 */
public class PlaySoundController {

	private static final String SOUND_FOLDER = "game/pikachu/sound/";
	private static final String SOUND_BACKGROUND = SOUND_FOLDER + "A_Better_Day.wav";
	private static final String SOUND_PRESSED = SOUND_FOLDER + "press.wav";
	private static final String SOUND_HIDE = SOUND_FOLDER + "eat_1.wav";
	private Clip soundBackground;
	private Clip soundPressed;
	private Clip soundHide;
	private boolean isPlay;

	/**
	 * The default constructor
	 */
	public PlaySoundController() {
		isPlay = true;
	}

	/**
	 * Play sound
	 *
	 * @param path
	 *            path of file sound
	 * @param volume
	 *            volume of sound
	 * @param n
	 *            loop play
	 * @return a Clip object
	 */
	public Clip playSound(String path, float volume, int n) {
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource(path);

			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume);
			// clip.start();
			clip.loop(n);
			return clip;
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Play sound background
	 */
	public void playBackground() {
		if (isPlay) {
			soundBackground = playSound(SOUND_BACKGROUND, -15f, Clip.LOOP_CONTINUOUSLY);
		}
	}

	/**
	 * Play sound pressed
	 */
	public void playPressed() {
		if (isPlay) {
			soundPressed = playSound(SOUND_PRESSED, -10f, 0);
		}
	}

	/**
	 * Play sound hide
	 */
	public void playHide() {
		if (isPlay) {
			soundHide = playSound(SOUND_HIDE, 0f, 0);
		}
	}

	/**
	 * Turn off sound
	 */
	public void turnOffSound() {
		turnOffSound(soundBackground);
		turnOffSound(soundPressed);
		turnOffSound(soundHide);
	}

	/**
	 * Turn off sound
	 *
	 * @param clip
	 *            a Clip object
	 */
	public void turnOffSound(Clip clip) {
		if (clip != null) {
			clip.stop();
		}
	}

	/**
	 * Get state play
	 *
	 * @return true if play, false if otherwise
	 */
	public boolean getIsPlay() {
		return isPlay;
	}

	/**
	 * Set state play
	 *
	 * @param b
	 *            state play (true or false)
	 */
	public void setIsPlay(boolean b) {
		this.isPlay = b;
	}
}
