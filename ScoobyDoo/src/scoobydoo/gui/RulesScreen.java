package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class RulesScreen extends Screen {

	@Override
	public void layout() {

		addImage(width / 2 - 250, 0, 500, 100, Images.logo);
		addButton(width - 200, height - 50, 200, 50, "Stats", "Stats");

		addImage(20, 105, 150, 150, Images.DoubleRoll[0]);
		addImage(20, 260, 150, 150, Images.DoubleRoll[1]);

		addImage(width / 2 + 20, 105, 150, 150, Images.DoubleRoll[3]);
		addImage(width / 2 + 20, 260, 150, 150, Images.DoubleRoll[5]);

		addLabel(200, 135, 6, 1, "Zombie", Color.RED);
		addLabel(200, 285, 6, 1, "Ammunition", Color.RED);

		addLabel(width / 2 + 220, 135, 6, 1, "Snacks", Color.RED);
		addLabel(width / 2 + 220, 285, 6, 1, "Survivor", Color.RED);

		addButton(175, 210, 100, 25, "More", "Zombie");
		addButton(175, 360, 100, 25, "More", "Ammo");

		addButton(width / 2 + 175, 210, 100, 25, "More", "Snacks");
		addButton(width / 2 + 175, 360, 100, 25, "More", "Survivor");

	}

	@Override
	public void onButtonPressed(String buttonId) {

		if ("Stats".equals(buttonId)) {

			Game.openScreen(new StatsScreen());
		}
		if ("Zombie".equals(buttonId)) {

			Game.openScreen(new ZombieRuleScreen());
		}
		
		if ("Ammo".equals(buttonId)) {

			Game.openScreen(new AmmoRuleScreen());
		}
		if ("Snacks".equals(buttonId)) {

			Game.openScreen(new SnackRuleScreen());
		}
		if ("Survivor".equals(buttonId)) {

			Game.openScreen(new SurvivorRuleScreen());
		}
	}

}
