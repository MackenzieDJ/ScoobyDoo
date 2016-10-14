package scoobydoo.gui;

import java.util.Random;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class DoubleDiceRollScreen extends Screen {

	@Override
	public void layout() {
		addImage(0, 0, width, height, Images.DICE2);
		// addLabel(width / 2, (height / 3) , 30, 1, "Good Luck!!!",
		// Color.GREEN);
		addButton(width / 2 - 200 / 2, height / 3 + 50, 200, 50, "ROLL!", "Roll");
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("Roll".equals(buttonId)) {
			System.out.println("Roll2");
			Random Rand = new Random();
			int option = Rand.nextInt(6);
			int option3 = Rand.nextInt(6);
			int option1 = option + 1;
			int option2 = option3 + 1;
			System.out.println("OPTION " + option1 + " + " + option2);
			Game.openScreen(new StatsScreen());
		}
	}
}