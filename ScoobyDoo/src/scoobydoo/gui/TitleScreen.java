package scoobydoo.gui;

import java.awt.Color;

import scoobydoo.engine.gui.ImageDisplay;
import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.input.Images;

public class TitleScreen extends Screen {

	private static final int TITLE_DELAY = 10;

	private int ticksExisted = 0;
	private ImageDisplay rodaway;
	private ImageDisplay titleI;
	private ImageDisplay ALL;

	@Override
	public void layout() {
		//addButton(width / 2 - 150 / 2, height / 2 - 50 / 2, 150, 50, "Hello World", "hello");
		addLabel(width/2, (height/2)-40, 30, 1, "Welcome To The Main Game!!!", Color.GREEN);
		//titleI = addImage(0, 0, width, height, Images.Title);
		//rodaway = addImage(0, 0, width, height, Images.test);
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("start".equals(buttonId)) {
			System.out.println("Ready To Start");
		}
	}
	
	
	@Override
	public void updateTick() {
		ticksExisted++;
		if (ticksExisted > TITLE_DELAY) {
			removeComponent(titleI);
			addButton(width / 2 - 150 / 2, height / 2 - 50 / 2, 150, 50, "Press To Start", "start");
		   }
		}
	}
