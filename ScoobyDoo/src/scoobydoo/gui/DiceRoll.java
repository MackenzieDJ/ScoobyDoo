package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.ImageDisplay;
import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;

public class DiceRoll extends Screen {
	private int ticksUntilChars = 50;
	private ImageDisplay ALL;

	@Override
	public void layout() {
		addLabel(width / 2, (height / 2) - 40, 30, 1, "PRESS BELOW TO ROLL!!!", Color.GREEN);
		addButton(width / 2 - 200 / 2, height / 2 - 50 / 2, 200, 50, "ROLL!", "Roll");
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("Roll".equals(buttonId)) {
			System.out.println("Role Dice");
			Game.openScreen(new Characters());
		}
	}
}
