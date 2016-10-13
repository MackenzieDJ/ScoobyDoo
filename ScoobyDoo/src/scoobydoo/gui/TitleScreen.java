package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.IProgress;
import scoobydoo.engine.gui.ProgressBar;
import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;

public class TitleScreen extends Screen {

	public int progress = 0;

	@Override
	public void layout() {
		addLabel(width / 2, (height / 2) - 40, 30, 1, "Welcome To The Main Game!!!", Color.GREEN);
		addButton(width / 2 - 200 / 2, height / 2 - 50 / 2, 200, 50, "Press To Start", "start");

		// This progress bar accepts values 0-170 and uses the field named
		// "progress" in this class.
		ProgressBar testProgressBar = new ProgressBar(width / 2 - 300 / 2, height - 50, 300, 40, Color.RED,
				Color.RED.darker(), Color.WHITE, new IProgress.FieldValue(this, "progress"), 170);
		testProgressBar.setText("Test progress bar");
		addComponent(testProgressBar);
		
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("start".equals(buttonId)) {
			System.out.println("Ready To Start");
			Game.openScreen (new DiceRoll());
		}
	}

	@Override
	public void updateTick() {
		progress++;
		System.out.println(progress);
	}
}
