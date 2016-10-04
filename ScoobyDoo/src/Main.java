import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {

	// CONSTANTS
	public static final String GAME_NAME = "Scooby Doo Zombie Game";
	// Ticks per second
	public static final int TPS = 30;
	public static final int MILLIS_PER_TICK = 1000 / TPS;

	// GLOBAL VARIABLES
	public static JFrame theFrame;
	public static MainWindow theWindow;
	private static boolean isRunning;

	public static void main(String[] args) {
		// Setup the frame
		theFrame = new JFrame(GAME_NAME);
		theWindow = new MainWindow();
		theFrame.setContentPane(theWindow);

		theFrame.pack();
		theFrame.setLocationRelativeTo(null);
		theFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		theFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// This runs when the user presses the 'x' button
				theFrame.dispose();
				shutdown();
			}
		});
		theFrame.addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				Keyboard.clearKeys();
			}
		});
		theWindow.requestFocusInWindow();
		theFrame.setVisible(true);

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
		Keyboard.updateTick();

		if (Keyboard.isKeyDown("test")) {
			System.out.println("Test key held down");
		}
	}

}
