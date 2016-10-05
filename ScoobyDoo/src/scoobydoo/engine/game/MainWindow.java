package scoobydoo.engine.game;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Keyboard;
import scoobydoo.engine.input.Mouse;
import scoobydoo.main.Game;

public class MainWindow extends JPanel {

	private static final long serialVersionUID = -3880026026104218593L;

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	public MainWindow() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(Keyboard.instance());
		addMouseListener(Mouse.instance());
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (Game.getOpenScreen() != null) {
					Game.getOpenScreen().mousePressed(e.getX(), e.getY(), e.getButton());
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (Game.getOpenScreen() != null) {
					Game.getOpenScreen().mouseReleased(e.getX(), e.getY(), e.getButton());
				}
			}

		});
	}

	@Override
	public void paintComponent(Graphics g) {
		Screen screen = Game.getOpenScreen();
		if (screen != null) {
			screen.draw(g);
		}
	}

}
