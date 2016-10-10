package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Images;

public class TitleScreen extends Screen {

	@Override
	public void layout() {
		addButton(width / 2 - 150 / 2, height / 2 - 50 / 2, 150, 50, "Hello World", "hello");
		addLabel(50, 50, 100, 100, "Hello Scooby", Color.GREEN);
		addImage(0, 0, 50, 50, Images.test);
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("hello".equals(buttonId)) {
			System.out.println("Hello World");
		}
	}

}
