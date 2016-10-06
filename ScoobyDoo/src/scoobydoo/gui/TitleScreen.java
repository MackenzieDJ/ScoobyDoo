package scoobydoo.gui;

import java.awt.Color;
import java.awt.Graphics;

import scoobydoo.engine.gui.Screen;

public class TitleScreen extends Screen {

	@Override
	public void layout() {
		addButton(width / 2 - 150 / 2, height / 2 - 50 / 2, 150, 50, "Hello World", "hello");
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
