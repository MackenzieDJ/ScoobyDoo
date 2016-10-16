package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class AmmoRuleScreen extends Screen {

	@Override
	public void layout() {

		addImage(width / 2 - 250, 0, 500, 100, Images.logo);
		addLabel(100, 110, 12, 1, "Ammunition Rules:", Color.RED);
		addButton(width - 200, height - 50, 200, 50, "Back", "Back");
		
		addLabel(300, 140, 12, 1, "Ammunition is used to kill zombies that may attack", Color.RED);
		addLabel(300, 165, 12, 1, "It can be found randomly, or given by fellow survivors", Color.RED);
	
		
	}

	@Override
	public void onButtonPressed(String buttonId) {

		if ("Back".equals(buttonId)) {

			Game.openScreen(new RulesScreen());
		}
	
	}

}
