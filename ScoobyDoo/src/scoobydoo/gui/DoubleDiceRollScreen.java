package scoobydoo.gui;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

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
			Game.redraw();

			if (GameLogic.scoobySnacksLeft > 0) {
				GameLogic.scoobySnacksLeft -= GameLogic.survivorsFound / 2 + 1;
			} else {
				GameLogic.gangHealth -= 5;
				if (GameLogic.gangHealth <= 0) {
					GameLogic.gangHealth = 0;
					JOptionPane.showMessageDialog(null, "A gang member starved to death");
					GameLogic.killGangMember(Rand);
				}
			}

			GameLogic.getObject1().performAction();
			GameLogic.getObject2().performAction();

			if (GameLogic.scoobySnacksLeft == GameLogic.MAX_SCOOBY_SNACKS) {
				GameLogic.gangHealth += 3;
				if (GameLogic.gangHealth > GameLogic.MAX_HEALTH) {
					GameLogic.gangHealth = GameLogic.MAX_HEALTH;
				}
			}
		}

	}
}