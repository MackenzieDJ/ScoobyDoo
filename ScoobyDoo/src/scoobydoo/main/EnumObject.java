package scoobydoo.main;

import java.awt.Image;

import javax.swing.JOptionPane;

import scoobydoo.resources.Images;

public enum EnumObject {

	ZOMBIE(Images.zombie) {
		@Override
		public void performAction() {
			GameLogic.zombiesInPlay++;
		}
	},
	AMMO(Images.ammo) {
		@Override
		public void performAction() {
			GameLogic.ammunition += 5;
			if (GameLogic.ammunition > GameLogic.MAX_AMMO) {
				GameLogic.ammunition = GameLogic.MAX_AMMO;
			}
		}
	},
	SNACK(Images.snack) {
		@Override
		public void performAction() {
			GameLogic.scoobySnacksLeft += 5;
			if (GameLogic.scoobySnacksLeft > GameLogic.MAX_SCOOBY_SNACKS) {
				GameLogic.scoobySnacksLeft = GameLogic.MAX_SCOOBY_SNACKS;
			}
		}
	},
	SURVIVOR(Images.survivor) {
		@Override
		public void performAction() {
			GameLogic.survivorsFound++;
			if (GameLogic.survivorsFound == GameLogic.MAX_SURVIVORS) {
				// We've won the game
				JOptionPane.showMessageDialog(null, "You've won the game!");
				Game.shutdown();
			}
		}
	},
	NOTHING(Images.nothing) {
		@Override
		public void performAction() {
			// Does nothing like Matt working with Ben
		}
	};

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

	public abstract void performAction();

	private static final EnumObject[] BY_DICE_ROLL = { ZOMBIE, AMMO, ZOMBIE, SNACK, NOTHING, SURVIVOR };

}
