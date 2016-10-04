import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {

	public static final String GAME_NAME = "Scooby Doo Zombie Game";

	public static JFrame theFrame;
	public static MainWindow theWindow;
	private static boolean isRunning;

	public static void main(String[] args) {
		theFrame = new JFrame(GAME_NAME);
		theWindow = new MainWindow();
		theFrame.setContentPane(theWindow);

		theFrame.pack();
		theFrame.setLocationRelativeTo(null);
		theFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		theFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				theFrame.dispose();
				shutdown();
			}
		});
		theFrame.setVisible(true);

		isRunning = true;

		while (isRunning) {
			long startTime = System.nanoTime();

			tick();

			long deltaTime = (System.nanoTime() - startTime) / 1000000;
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

	private static void tick() {

	}

}
