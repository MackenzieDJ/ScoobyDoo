package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.IProgress;
import scoobydoo.engine.gui.ProgressBar;
import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class TitleScreen extends Screen {

	public int enjoyTheGameProgress = 0;
	private int enjoyTheGameProgressDirection = 1;

	@Override
	public void layout() {
		addImage(0, 0, width, height, Images.allInMachine);

		addLabel((width / 2) - 15, height - 220, 30, 1, "Welcome To The Main Game", Color.RED);
		addButton((width / 2) - 100, height - 200, 200, 50, "Press To Start", "start");

		addButton(width / 2 - 200 / 2, height - 125, 200, 50, "QUIT", "Quit");

		ProgressBar testProgressBar = new ProgressBar(width / 2 - 300 / 2, height - 50, 300, 40, Color.GREEN.darker(),
				Color.GREEN.darker().darker(), Color.WHITE, new IProgress.FieldValue(this, "enjoyTheGameProgress"), 50);
		testProgressBar.setText("ENJOY THE GAME!!!");
		addComponent(testProgressBar);

	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("start".equals(buttonId)) {
			System.out.println("Ready To Start");
			Game.openScreen(new DiceRoll());
		}
		if ("Quit".equals(buttonId)) {
			Game.shutdown();
		}
	}

	@Override
	public void updateTick() {
		enjoyTheGameProgress += enjoyTheGameProgressDirection;
		if (enjoyTheGameProgress == 50) {
			enjoyTheGameProgressDirection = -1;
		} else if (enjoyTheGameProgress == 0) {
			enjoyTheGameProgressDirection = 1;
		}
	}
}
