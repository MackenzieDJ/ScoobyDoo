package scoobydoo.main;

import javax.swing.JFrame;

import scoobydoo.engine.game.CustomJFrame;
import scoobydoo.engine.game.MainWindow;
import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Keyboard;
import scoobydoo.engine.input.Mouse;
import scoobydoo.gui.TitleScreen;

public class Game {

	// CONSTANTS
	public static final String GAME_NAME = "Scooby Doo Zombie Game";
	// Ticks per second
	public static final int TPS = 30;
	public static final int MILLIS_PER_TICK = 1000 / TPS;

	// GLOBAL VARIABLES
	public static JFrame theFrame;
	public static MainWindow theWindow;
	private static boolean isRunning;
	private static Screen theScreen;

	public static void main(String[] args) {
		// Setup the frame
		theWindow = new MainWindow();
		theFrame = new CustomJFrame(theWindow);

		// Display the title screen
		openScreen(new TitleScreen());

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
		isRunning = false;
	}

	// This is called every tick, do stuff that needs to happen every tick in
	// here
	private static void tick() {
		// Update inputs. Do this before everything else so things react to
		// input more instantly
		Keyboard.updateTick();
		Mouse.updateTick();

		if (Keyboard.isKeyDown("test")) {
			System.out.println("Test key held down");
		}

		// Update the current screen
		if (theScreen != null) {
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
