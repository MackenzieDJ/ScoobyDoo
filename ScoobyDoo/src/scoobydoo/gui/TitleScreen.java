package scoobydoo.gui;

import java.awt.Graphics;

import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Images;

public class TitleScreen extends Screen {

	@Override
	public void layout() {
		addButton(width / 2 - 150 / 2, height / 2 - 50 / 2, 150, 50, "Hello World", "hello");
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawImage(Images.test, 0, 0, 50, 50, null);
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("hello".equals(buttonId)) {
			System.out.println("Hello World");
		}
	}

}
