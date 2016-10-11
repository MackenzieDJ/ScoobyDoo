package scoobydoo.gui;

import scoobydoo.engine.gui.Screen;
import scoobydoo.resources.Images;


public class Characters extends Screen {

	

	@Override
	public void layout() {
		
		addImage(0,0,width/3, height/2, Images.Shaggy);
		addImage((((width/3)+(width/3)/2)-width/6), 0, width/3, height/2, Images.velma);
		addImage((width)-width/3,0,width/3, height/2, Images.Scooby);
		
		addImage(0,height/2, width/3, height/2, Images.FredB);
		addImage((((width/3)+(width/3)/2)-width/6), height/2, width/3, height/2, Images.Title);
		addImage((width)-width/3,height/2,width/3, height/2, Images.Daf);
	
		//addImage(0,0,width/4, height/3, Images.Shaggy);
		//addImage((width/2)-(width/8), 0, width/4, height/3, Images.Title);
		//addImage((width)-width/4,0,width/4, height/3, Images.Scooby);
	}



}
