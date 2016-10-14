package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.IProgress;
import scoobydoo.engine.gui.IProgressTextFunction;
import scoobydoo.engine.gui.ProgressBar;
import scoobydoo.engine.gui.Screen;
import scoobydoo.main.GameLogic;

public class Stats extends Screen {

	@Override
	public void layout() {
		addLabel(width - 180, 25, 30, 1, "Game Statistics", Color.GREEN);

		addButton(width - 200, height - 50, 200, 50, "Press To Continue", "Continue");
		addButton(0, height - 50, 200, 50, "Press To Shoot!", "Fire");

		ProgressBar HealthProgressBar = new ProgressBar(width - 300, 50, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "gangHealth"), 170);
		HealthProgressBar.setTextFunction(new IProgressTextFunction.Format("Health: $%%"));
		addComponent(HealthProgressBar);

		addLabel(width - 170, 110, 30, 1, "Health of the gang", Color.GREEN);

		ProgressBar AmmoProgressBar = new ProgressBar(width - 300, 130, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "ammunition"), 170);
		AmmoProgressBar.setTextFunction(new IProgressTextFunction.Format("Ammunition: $%%"));
		addComponent(AmmoProgressBar);

		addLabel(width - 170, 190, 30, 1, "Ammunition", Color.GREEN);

		ProgressBar SnacksProgressBar = new ProgressBar(width - 300, 210, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "scoobySnacksLeft"), 170);
		SnacksProgressBar.setTextFunction(new IProgressTextFunction.Format("Snack Supply: $%%"));
		addComponent(SnacksProgressBar);

		addLabel(width - 170, 270, 30, 1, "Scooby Snacks left", Color.GREEN);

		ProgressBar SurvivorProgressBar = new ProgressBar(width - 300, 290, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, IProgress.FieldValue.staticField(GameLogic.class, "survivorsFound"), 10);
		SurvivorProgressBar.setTextFunction(new IProgressTextFunction.Format("Survivors: $p/$m"));
		addComponent(SurvivorProgressBar);

		addLabel(width - 170, 350, 30, 1, "Survivors Found!!!", Color.GREEN);

	}

}
