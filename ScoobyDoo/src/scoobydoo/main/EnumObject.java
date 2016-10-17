package scoobydoo.main;

import java.awt.Image;

import scoobydoo.resources.Images;

public enum EnumObject {

	ZOMBIE(Images.zombie), AMMO(Images.ammo), SNACK(Images.snack), SURVIVOR(Images.survivor), NOTHING(Images.nothing);

	private Image image;

	private EnumObject(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}

	public static EnumObject getByDiceRoll(int diceRoll) {
		return BY_DICE_ROLL[diceRoll - 1];
	}

	private static final EnumObject[] BY_DICE_ROLL = { ZOMBIE, AMMO, ZOMBIE, SNACK, NOTHING, SURVIVOR };

}
