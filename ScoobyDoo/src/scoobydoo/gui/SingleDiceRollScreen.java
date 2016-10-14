package scoobydoo.gui;

import java.awt.Color;
import java.util.Random;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.main.GameLogic;
import scoobydoo.main.GameLogic.GangMember;
import scoobydoo.resources.Images;

public class SingleDiceRollScreen extends Screen {
	

	@Override
	public void layout() {
			addImage(0, 0, width, height, Images.Background);
		addLabel(width / 2, (height / 3) - 20, 30, 1, "PRESS BELOW TO ROLL!!!", Color.GREEN);
		addButton(width / 2 - 200 / 2, height / 3 , 200, 50, "ROLL!", "Roll");
	}

	@Override
	public void onButtonPressed(String buttonId) {
		int ai = 4;
		if ("Roll".equals(buttonId)) {
			System.out.println("Role Dice");
			Random Rand = new Random();
			int people = Rand.nextInt(ai);
			people++;
			System.out.println(people);
			ai = 6;
			GameLogic.getAliveMembers().add(GangMember.SCOOBY);
			int a = 1;
			while (a <= people)
			{
				GameLogic.addRandomGangMember(Rand);
				a++;
			}
			Game.openScreen(new DisplayCharactersScreen());
		}
	}
}
