package scoobydoo.gui;



import scoobydoo.engine.gui.Screen;
import scoobydoo.resources.Images;

public class Dice2 extends Screen {

	@Override
	public void layout() {
		addImage(0, 0, width, height, Images.DICE2);
		// addLabel(width / 2, (height / 3) , 30, 1, "Good Luck!!!",
		// Color.GREEN);
		addButton(width / 2 - 200 / 2, height / 3 + 30, 200, 50, "ROLL!", "Roll");
	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("Roll".equals(buttonId)) {
			System.out.println("Roll2");
			
		}
	}
}