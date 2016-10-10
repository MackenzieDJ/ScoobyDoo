package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.ImageDisplay;
import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Images;

public class TitleScreen extends Screen {

	private static final int RODAWAY_DISAPPEAR_DELAY = 100;

	private int ticksExisted = 0;
	private ImageDisplay rodaway;

	@Override
	public void layout() {
		addButton(width / 2 - 150 / 2, height / 2 - 50 / 2, 150, 50, "Hello World", "hello");
		addLabel(50, 50, 100, 100, "Hello Scooby", Color.GREEN);
		rodaway = addImage(0, 0, 50, 50, Images.test);
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("hello".equals(buttonId)) {
			System.out.println("Hello World");
		}
	}

	@Override
	public void updateTick() {
		ticksExisted++;
		if (ticksExisted > RODAWAY_DISAPPEAR_DELAY) {
			removeComponent(rodaway);
		}
	}

}
