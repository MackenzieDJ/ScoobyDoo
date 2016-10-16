package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class SnackRuleScreen extends Screen {

	@Override
	public void layout() {

		addImage(width / 2 - 250, 0, 500, 100, Images.logo);
		addLabel(100, 110, 12, 1, "Snack Rules:", Color.RED);
		addButton(width - 200, height - 50, 200, 50, "Back", "Back");

		addLabel(300, 140, 12, 1, "Your snacks help keep the gang alive and healthy", Color.RED);
		addLabel(300, 165, 12, 1, "If you run out of snacks your health will decrease", Color.RED);
		addLabel(300, 190, 12, 1, "Each box of snacks found will increase your supply", Color.RED);
		addLabel(300, 215, 12, 1, "Survivors found may also give you some snacks ", Color.RED);
	}

	@Override
	public void onButtonPressed(String buttonId) {

		if ("Back".equals(buttonId)) {

			Game.openScreen(new RulesScreen());
		}
	
	}

}
