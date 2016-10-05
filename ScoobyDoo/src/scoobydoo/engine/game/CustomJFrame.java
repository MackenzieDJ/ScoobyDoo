package scoobydoo.engine.game;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import scoobydoo.engine.input.Keyboard;
import scoobydoo.engine.input.Mouse;
import scoobydoo.main.Game;

public class CustomJFrame extends JFrame {

	private static final long serialVersionUID = 5862168449191459872L;

	public CustomJFrame(MainWindow window) {
		super(Game.GAME_NAME);
		
		setContentPane(window);

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// This runs when the user presses the 'x' button
				dispose();
				Game.shutdown();
			}
		});
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				Keyboard.clearKeys();
				Mouse.clearButtons();
			}
		});
		requestFocusInWindow();
		setVisible(true);
	}

	@Override
	public void validate() {
		super.validate();
		if (Game.getOpenScreen() != null) {
			Game.getOpenScreen().validate(Game.theWindow.getWidth(), Game.theWindow.getHeight());
		}
	}

}