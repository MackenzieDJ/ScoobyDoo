package scoobydoo.gui;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import scoobydoo.engine.gui.IProgress;
import scoobydoo.engine.gui.IProgressTextFunction;
import scoobydoo.engine.gui.ProgressBar;
import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.main.GameLogic;
import scoobydoo.resources.Images;

public class StatsScreen extends Screen {

	@Override
	public void layout() {
		// Misc labels and buttons
		addLabel(width - 180, 25, 30, 1, "Game Statistics", Color.RED);

		addButton(width - 200, height - 50, 200, 50, "Press To Continue", "Continue");
		addButton(0, height - 50, 200, 50, "Press To Shoot!", "Fire");
		addButton(0, 0, 200, 50, "Rules", "Rules");
		// Health of gang
		ProgressBar HealthProgressBar = new ProgressBar(width - 300, 50, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "gangHealth"), GameLogic.MAX_HEALTH);
		HealthProgressBar.setTextFunction(new IProgressTextFunction.Format("Health: $%%"));
		addComponent(HealthProgressBar);

		addLabel(width - 170, 110, 30, 1, "Health of the gang", Color.RED);

		// Ammo
		ProgressBar AmmoProgressBar = new ProgressBar(width - 300, 130, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "ammunition"), GameLogic.MAX_AMMO);
		AmmoProgressBar.setTextFunction(new IProgressTextFunction.Format("Ammunition: $%%"));
		addComponent(AmmoProgressBar);

		addLabel(width - 170, 190, 30, 1, "Ammunition", Color.RED);

		// Scooby snack supply
		ProgressBar SnacksProgressBar = new ProgressBar(width - 300, 210, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "scoobySnacksLeft"),
				GameLogic.MAX_SCOOBY_SNACKS);
		SnacksProgressBar.setTextFunction(new IProgressTextFunction.Format("Snack Supply: $%%"));
		addComponent(SnacksProgressBar);

		addLabel(width - 170, 270, 30, 1, "Scooby Snacks left", Color.RED);

		// Survivors found
		ProgressBar SurvivorProgressBar = new ProgressBar(width - 300, 290, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "survivorsFound"),
				GameLogic.MAX_SURVIVORS);
		SurvivorProgressBar.setTextFunction(new IProgressTextFunction.Format("Survivors: $p/$m"));
		addComponent(SurvivorProgressBar);

		addLabel(width - 170, 350, 30, 1, "Survivors Found!!!", Color.RED);

		// Dice Rolled
		addImage(210, height - 50, 50, 50, Images.dice[GameLogic.getRoll1() - 1]);
		addImage(width - 260, height - 50, 50, 50, Images.dice[GameLogic.getRoll2() - 1]);
		addLabel(300, height - 25, 30, 1, "Last Roll", Color.RED);

		// Actions
		addImage(50, 50, 175, 175, GameLogic.getObject1().getImage());
		addImage(50, 225, 200, 175, GameLogic.getObject2().getImage());
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("Fire".equals(buttonId)) {
			if (GameLogic.ammunition == 0 || GameLogic.hasFired || GameLogic.zombiesInPlay == 0) {
				JOptionPane.showMessageDialog(null, "You can't fire a bullet at the moment");
			} else {
				GameLogic.ammunition -= 2;
				if (GameLogic.ammunition < 0) {
					GameLogic.ammunition = 0;
				}
				GameLogic.zombiesInPlay--;
				GameLogic.hasFired = true;
				JOptionPane.showMessageDialog(null, "You killed a zombie!");
			}
		}

		if ("Continue".equals(buttonId)) {
			Random rand = new Random();
			GameLogic.hasFired = false;
			while (GameLogic.zombiesInPlay > 0) {
				GameLogic.zombiesInPlay--;
				JOptionPane.showMessageDialog(null, "A zombie killed a gang member :(");
				if (GameLogic.killGangMember(rand)) {
					break;
				}
			}

			Game.openScreen(new DisplayCharactersScreen());
		}
		if ("Rules".equals(buttonId)) {

			Game.openScreen(new RulesScreen());
		}
	}
}
