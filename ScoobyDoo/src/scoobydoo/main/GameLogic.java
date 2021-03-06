package scoobydoo.main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import scoobydoo.resources.Images;

/**
 * A class which stores variables for the game logic, and contains functions to
 * do with the game logic
 */
public class GameLogic {

	private GameLogic() {
	}

	private static List<GangMember> aliveMembers = new ArrayList<GangMember>();

	public static final int MAX_SURVIVORS = 10;
	public static final int MAX_HEALTH = 100;
	public static final int MAX_AMMO = 100;
	public static final int MAX_SCOOBY_SNACKS = 150;

	public static int survivorsFound = 0;
	public static int gangHealth = 100;
	public static int ammunition = 10;
	public static int scoobySnacksLeft = 75;
	public static int zombiesInPlay = 0;
	public static boolean hasFired = false;

	private static int roll1;
	private static int roll2;
	private static EnumObject object1;
	private static EnumObject object2;

	public static int getRoll1() {
		return roll1;
	}

	public static int getRoll2() {
		return roll2;
	}

	public static EnumObject getObject1() {
		return object1;
	}

	public static EnumObject getObject2() {
		return object2;
	}

	public static void setRoll1(int roll1) {
		GameLogic.roll1 = roll1;
		object1 = EnumObject.getByDiceRoll(roll1);
	}

	public static void setRoll2(int roll2) {
		GameLogic.roll2 = roll2;
		object2 = EnumObject.getByDiceRoll(roll2);
	}

	/**
	 * Returns a modifiable list of alive gang members
	 */
	public static List<GangMember> getAliveMembers() {
		return aliveMembers;
	}

	/**
	 * Returns true if they lost the game
	 */
	public static boolean killGangMember(Random rand) {
		GameLogic.getAliveMembers().remove(rand.nextInt(GameLogic.getAliveMembers().size()));
		if (GameLogic.getAliveMembers().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You have no alive gang members left, you lost the game :(");
			Game.shutdown();
			return true;
		}
		return false;
	}

	/**
	 * Brings one single random gang member to life
	 */
	public static void addRandomGangMember(Random rand) {
		aliveMembers.add(GangMember.randomMember(rand, aliveMembers));
	}

	/**
	 * A gang member
	 */
	public static enum GangMember {
		SCOOBY(Images.Scooby), SHAGGY(Images.Shaggy), VELMA(Images.velma), DAPHNE(Images.Daf), FRED(Images.FredB);

		private Image image;

		private GangMember(Image image) {
			this.image = image;
		}

		/**
		 * Gets the image associated with this gang member
		 */
		public Image getImage() {
			return image;
		}

		/**
		 * Returns a random gang member not in the list specified
		 */
		public static GangMember randomMember(Random rand, List<GangMember> excluding) {
			if (excluding.containsAll(Arrays.asList(values()))) {
				throw new IllegalArgumentException("No gang members to pick from");
			}

			GangMember chosen;
			do {
				chosen = randomMember(rand);
			} while (excluding.contains(chosen));
			return chosen;
		}

		/**
		 * Returns a random gang member
		 */
		public static GangMember randomMember(Random rand) {
			return values()[rand.nextInt(values().length)];
		}
	}

}
