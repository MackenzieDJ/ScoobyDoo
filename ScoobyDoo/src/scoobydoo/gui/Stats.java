package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.IProgress;
import scoobydoo.engine.gui.ProgressBar;
import scoobydoo.engine.gui.Screen;

public class Stats extends Screen {

	public int progress = 0;
	public int Survivor = 100;
	public int Health = 170;
	public int Ammunition = 50;
	public int Snack = 70;

	@Override
	public void layout() {

		addLabel(width - 180, 25, 30, 1, "Game Statistics", Color.GREEN);

		addButton(width - 200, height - 50, 200, 50, "Press To Continue", "Continue");
		addButton(0, height - 50, 200, 50, "Press To Shoot!", "Fire");

		ProgressBar HealthProgressBar = new ProgressBar(width - 300, 50, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, new IProgress.FieldValue(this, "Health"), 170);
		HealthProgressBar.setText("Health Of The Gang");
		addComponent(HealthProgressBar);

		addLabel(width - 170, 110, 30, 1, "Health: " + Math.floor(((double) Health / 170) * 100) + "%", Color.GREEN);

		ProgressBar AmmoProgressBar = new ProgressBar(width - 300, 130, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, new IProgress.FieldValue(this, "Ammunition"), 170);
		AmmoProgressBar.setText("Ammunition");
		addComponent(AmmoProgressBar);

		addLabel(width - 170, 190, 30, 1, "Ammunition: " + Math.floor(((double) Ammunition / 170) * 100) + "%",
				Color.GREEN);

		ProgressBar SnacksProgressBar = new ProgressBar(width - 300, 210, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, new IProgress.FieldValue(this, "Snack"), 170);
		SnacksProgressBar.setText("Scooby Snacks left");
		addComponent(SnacksProgressBar);

		addLabel(width - 170, 270, 30, 1, "Snack Supply: " + Math.floor(((double) Snack / 170) * 100) + "%",
				Color.GREEN);

		ProgressBar SurvivorProgressBar = new ProgressBar(width - 300, 290, 300, 40, Color.RED, Color.RED.darker(),
				Color.WHITE, new IProgress.FieldValue(this, "Survivor"), 170);
		SurvivorProgressBar.setText("Survivor's Found!!!");
		addComponent(SurvivorProgressBar);

		addLabel(width - 170, 350, 30, 1, "Survivor's: " + Math.floor(((double) Survivor / 170) * 100) + "%",
				Color.GREEN);

	}

}
