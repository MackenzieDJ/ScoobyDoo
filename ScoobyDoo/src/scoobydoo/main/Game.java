package scoobydoo.main;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import scoobydoo.engine.game.CustomJFrame;
import scoobydoo.engine.game.MainWindow;
import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Keyboard;
import scoobydoo.engine.input.Mouse;
import scoobydoo.engine.sound.SoundManager;
import scoobydoo.gui.LoadingScreen;

public class Game {

	// CONSTANTS
	public static final String GAME_NAME = "Scooby Doo Zombie Game";
	// Ticks per second
	public static final int TPS = 30;
	public static final int MILLIS_PER_TICK = 1000 / TPS;
	public static final Font NORMAL_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 18);

	// GLOBAL VARIABLES
	public static JFrame theFrame;
	public static MainWindow theWindow;
	private static boolean isRunning;
	private static Screen theScreen;

	public static void main(String[] args) {
		// Loop the music
		new Runnable() {
			private String currentSound = "CREEPY2";

			@Override
			public void run() {
				currentSound = "CREEPY2".equals(currentSound) ? "CREEPY1" : "CREEPY2";
				SoundManager.playSound(currentSound, this);
			}
		}.run();

		// Setup the frame
		theWindow = new MainWindow();
		theFrame = new CustomJFrame(theWindow);

		// Display the title screen
		openScreen(new LoadingScreen());

		// The main game loop. One run-through of this loop = one tick
		isRunning = true;
		while (isRunning) {
			long startTime = System.nanoTime();

			tick();

			long deltaTime = MILLIS_PER_TICK - (System.nanoTime() - startTime) / 1000000;
			if (deltaTime > 0) {
				try {
					Thread.sleep(deltaTime);
				} catch (InterruptedException e) {
					// ignore
				}
			} else if (deltaTime < 0) {
				System.err.println("Tickrate is struggling! We're " + (-deltaTime) + "ms behind!");
			}
		}
	}

	public static void shutdown() {
		SoundManager.closeAllSounds();
		theFrame.dispose();
		isRunning = false;
	}

	// This is called every tick, do stuff that needs to happen every tick in
	// here
	private static void tick() {
		// Update inputs. Do this before everything else so things react to
		// input more instantly
		Keyboard.updateTick();
		Mouse.updateTick();

		// Do screen stuff
		if (theScreen != null) {
			// Handle mouse input for the screen for left and right click
			Point mouseLocation = null;
			for (int button = MouseEvent.BUTTON1; button <= MouseEvent.BUTTON2; button++) {
				if (Mouse.isButtonPressed(button)) {
					if (mouseLocation == null) {
						mouseLocation = Mouse.getMouseLocation();
					}
					theScreen.mousePressed(mouseLocation.x, mouseLocation.y, button);
				}
				if (Mouse.isButtonReleased(button)) {
					if (mouseLocation == null) {
						mouseLocation = Mouse.getMouseLocation();
					}
					theScreen.mouseReleased(mouseLocation.x, mouseLocation.y, button);
				}
			}

			// Update the screen
			theScreen.updateTick();
		}

		// Repaint the window
		theWindow.repaint();
	}

	/**
	 * Called to change the currently open screen
	 */
	public static void openScreen(Screen screen) {
		if (theScreen != null) {
			theScreen.onScreenClosed();
		}
		theScreen = screen;
		screen.onScreenOpened();
		screen.validate(theWindow.getWidth(), theWindow.getHeight());
	}

	/**
	 * Returns the currently open screen
	 */
	public static Screen getOpenScreen() {
		return theScreen;
	}

}
