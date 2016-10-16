package scoobydoo.gui;

import java.awt.Color;
import java.awt.Image;
import java.util.List;

import scoobydoo.engine.gui.Screen;
import scoobydoo.main.Game;
import scoobydoo.main.GameLogic;
import scoobydoo.main.GameLogic.GangMember;
import scoobydoo.resources.Images;

public class DisplayCharactersScreen extends Screen {

	@Override
	public void layout() {
		List<GangMember> aliveMembers = GameLogic.getAliveMembers();
		addLabel((width / 2) - 15, 25, 30, 1, "The Current Gang!", Color.RED);
		addButton(width - 205, height - 70, 200, 50, "Next", "Next");

		for (int i = 0; i < 5; i++) {
			int x = (i % 3) * width / 3;
			int y = (i / 3) * ((height - 50) / 2) + 50;
			int imageWidth = width / 3;
			int imageHeight = (height - 50) / 2;
			Image image;
			if (i >= aliveMembers.size()) {
				image = Images.Grave;
			} else {
				image = aliveMembers.get(i).getImage();
			}
			addImage(x, y, imageWidth, imageHeight, image);
		}

	}

	@Override
	public void onButtonPressed(String buttonId) {
		if ("Next".equals(buttonId)) {
			System.out.println("DoubleDiceRollScreen");
			Game.openScreen(new DoubleDiceRollScreen());
		}
	}

}
