package scoobydoo.gui;

import java.awt.Image;
import java.util.List;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.GameLogic;
import scoobydoo.main.GameLogic.GangMember;
import scoobydoo.resources.Images;

public class Characters extends Screen {

	@Override
	public void layout() {
		List<GangMember> aliveMembers = GameLogic.getAliveMembers();

		for (int i = 0; i < 6; i++) {
			int x = (i % 3) * width / 3;
			int y = (i / 3) * height / 2;
			int imageWidth = width / 3;
			int imageHeight = height / 2;
			Image image;
			if (i >= aliveMembers.size()) {
				image = Images.test;
			} else {
				image = aliveMembers.get(i).getImage();
			}
			addImage(x, y, imageWidth, imageHeight, image);
		}
	}

}
