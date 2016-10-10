package scoobydoo.gui;

import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Images;
import scoobydoo.main.Game;

public class LoadingScreen extends Screen {

	private int ticksUntilTitle = 50;

	@Override
	public void layout() {
		addImage(0, 0, width, height, Images.Title);
	}

	@Override
	public void updateTick() {
		ticksUntilTitle--;
		if (ticksUntilTitle <= 0) {
			Game.openScreen(new TitleScreen());
		}
	}

}
