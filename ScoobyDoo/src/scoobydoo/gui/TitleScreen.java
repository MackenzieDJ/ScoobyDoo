package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.ImageDisplay;
import scoobydoo.engine.gui.Screen;

public class TitleScreen extends Screen {

	private ImageDisplay ALL;

	@Override
	public void layout() {
		addLabel(width / 2, (height / 2) - 40, 30, 1, "Welcome To The Main Game!!!", Color.GREEN);
		addButton(width / 2 - 200 / 2, height / 2 - 50 / 2, 200, 50, "Press To Start", "start");
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("start".equals(buttonId)) {
			System.out.println("Ready To Start");
		}
	}
}
