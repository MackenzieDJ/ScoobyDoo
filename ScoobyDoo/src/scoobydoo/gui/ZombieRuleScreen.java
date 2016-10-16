package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class ZombieRuleScreen extends Screen {

	@Override
	public void layout() {

		addImage(width / 2 - 250, 0, 500, 100, Images.logo);
		addLabel(100, 110, 12, 1, "Zombie Rules:", Color.RED);
		addButton(width - 200, height - 50, 200, 50, "Back", "Back");
		addLabel(300, 140, 12, 1, "If you get  zombie you can shoot it if you have ammo", Color.RED);
		addLabel(300, 165, 12, 1, "If there are two zombies one of the gang will Die", Color.RED);
		addLabel(300, 190, 12, 1, "If you take long to shoot your health will go down", Color.RED);
		
	}

	@Override
	public void onButtonPressed(String buttonId) {

		if ("Back".equals(buttonId)) {

			Game.openScreen(new RulesScreen());
		}
	
	}

}
