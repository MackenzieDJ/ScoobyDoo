package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.IProgress;
import scoobydoo.engine.gui.ProgressBar;
import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class TitleScreen extends Screen {

	public int progress = 0;

	@Override
	public void layout() {
		addImage(0, 0, width, height, Images.allInMachine);

		addLabel((width / 2) - 15, height - 220, 30, 1, "Welcome To The Main Game", Color.RED);
		addButton((width / 2) - 100, height - 200, 200, 50, "Press To Start", "start");

		addButton(width / 2 - 200 / 2, height - 125, 200, 50, "QUIT", "Quit");

		// This progress bar accepts values 0-170 and uses the field named
		// "progress" in this class.
		ProgressBar testProgressBar = new ProgressBar(width / 2 - 300 / 2, height - 50, 300, 40, Color.RED,
				Color.RED.darker(), Color.WHITE, new IProgress.FieldValue(this, "progress"), 170);
		testProgressBar.setText("ENJOY THE GAME");
		addComponent(testProgressBar);

	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("start".equals(buttonId)) {
			System.out.println("Ready To Start");
			Game.openScreen(new DiceRoll());
		}
		if ("Quit".equals(buttonId)) {
			System.exit(0);
		}
	}

	@Override
	public void updateTick() {
		progress++;

	}
}
