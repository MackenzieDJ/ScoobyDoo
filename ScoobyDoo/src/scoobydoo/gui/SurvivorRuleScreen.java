package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class SurvivorRuleScreen extends Screen {

	@Override
	public void layout() {

		addImage(width / 2 - 250, 0, 500, 100, Images.logo);
		addLabel(100, 110, 12, 1, "Survivor Rules:", Color.RED);
		addButton(width - 200, height - 50, 200, 50, "Back", "Back");
		
		addLabel(300, 140, 12, 1, "Survivors are just like you they are trying to survive", Color.RED);
		addLabel(300, 165, 12, 1, "If find a survivor they may join you or shoot you", Color.RED);
		addLabel(300, 190, 12, 1, "If they join you your snack supply will reduce quicker", Color.RED);
		addLabel(300, 215, 12, 1, "Survivors will inctrease your chance of killing zombies", Color.RED);
		
		
	}

	@Override
	public void onButtonPressed(String buttonId) {

		if ("Back".equals(buttonId)) {

			Game.openScreen(new RulesScreen());
		}
	
	}

}
