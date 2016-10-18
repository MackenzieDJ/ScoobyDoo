package scoobydoo.gui;



import scoobydoo.engine.gui.Screen;
import scoobydoo.engine.sound.SoundManager;
import scoobydoo.main.Game;
import scoobydoo.resources.Images;

public class LoadingScreen extends Screen {

	private int ticksUntilTitle = 150;
	

	
	
	@Override
	public void onScreenOpened() {
		SoundManager.playSound("scooby doo");
	}

	@Override
	public void layout() {
		addImage(0, 0, width, height, Images.Title);
		
	}

	@Override
	public void updateTick() {
		ticksUntilTitle--;
		
		if (ticksUntilTitle <= 0) {
			Game.openScreen(new WelcomeScreen());
		}
	}





}
