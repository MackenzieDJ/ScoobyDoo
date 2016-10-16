package scoobydoo.gui;

import java.awt.Color;
import java.util.Random;

import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.sound.SoundManager;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class WelcomeScreen extends Screen {

	@Override
	public void layout() {

		addImage(width / 2 - 250, -20, 500, 200, Images.logo);
		// SoundManager.playSound(name);
		addLabel(width / 2 - 15, (height / 3) - 20, 30, 3, "You Have Been Challenged", Color.RED);
		addLabel(60, (height / 3) - 5, 10, 3, "Objectives:", Color.RED);
		addLabel(300, (height / 3) + 30, 60, 1, "You Must Help The Gang Make It Through The Apocalypse", Color.RED);
		addLabel(300, (height / 3) + 60, 60, 1, "The Gang Are Currently Surrounded by Zombies", Color.RED);
		addLabel(280, (height / 3) + 90, 55, 1, "The First Roll Will Decide How Many of The Gang Survive",Color.RED);
		addLabel(280, (height / 3) + 120, 55, 1, "The Next Roll Will Decide What Supplies You Get",Color.RED);
		addLabel(280, (height / 3) + 150, 55, 1, "However You Could Stumble Across Survivors Or Zombies",Color.RED);
		addLabel(280, (height / 3) + 210, 55, 1, "GOOD LUCK!!!",Color.RED);
		addLabel(280, (height / 3) + 250, 55, 1, "FROM THE MYSTERY MACHINE",Color.RED);
		addButton(width -200, height - 50, 200, 50, "NEXT", "Next");
	}
	@Override
	public void onButtonPressed(String buttonId) {
		
		if ("Next".equals(buttonId)) {
	
			Game.openScreen(new SingleDiceRollScreen());
		}
	
	}
}