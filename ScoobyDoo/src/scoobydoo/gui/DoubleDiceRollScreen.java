package scoobydoo.gui;

import java.awt.Color;
import java.util.Random;

import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.sound.SoundManager;
import scoobydoo.main.Game;
import scoobydoo.main.GameLogic;
import scoobydoo.resources.Images;

public class DoubleDiceRollScreen extends Screen {

	@Override
	public void layout() {

		addImage(0, 0, width, height, Images.DICE2);
		addButton(width / 2 - 200 / 2, height / 3 + 50, 200, 50, "ROLL!", "Roll");
		addLabel(width / 2 - 12, (height / 3) + 40, 24, 1, "Roll To See What Happens", Color.RED);

	}

	@Override
	public void onButtonPressed(String buttonId) {

		if ("Roll".equals(buttonId)) {
			SoundManager.playSound("Roll");
			System.out.println("Roll2");
			Random Rand = new Random();
			int option = Rand.nextInt(6);
			int option3 = Rand.nextInt(6);
			GameLogic.setRoll1(option + 1);
			GameLogic.setRoll2(option3 + 1);
			System.out.println("OPTION " + GameLogic.getRoll1() + " + " + GameLogic.getRoll2());
			Game.openScreen(new StatsScreen());
		}

	}
}