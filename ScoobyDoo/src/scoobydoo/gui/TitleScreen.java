package scoobydoo.gui;
import java.awt.Color;
import java.awt.Graphics;

import scoobydoo.engine.gui.Button;
import scoobydoo.engine.gui.Screen;

public class TitleScreen extends Screen {

	private Button helloButton;

	@Override
	public void onScreenOpened() {
		helloButton = new Button(0, 0, 150, 50, "Hello World", "hello");
	}

	@Override
	public void layout() {
		helloButton.setX(width / 2 - helloButton.getWidth() / 2);
		helloButton.setY(height / 2 - helloButton.getHeight() / 2);
		addComponent(helloButton);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.RED);
		g.fillRect(10, 10, 10, 10);
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("hello".equals(buttonId)) {
			System.out.println("Hello World");
		}
	}

}
