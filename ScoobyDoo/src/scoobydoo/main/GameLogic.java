package scoobydoo.main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import scoobydoo.resources.Images;

public class GameLogic {

	private GameLogic() {
	}
	
	private static List<GangMember> aliveMembers = new ArrayList<GangMember>();

	public static List<GangMember> getAliveMembers() {
		return aliveMembers;
	}

	public static enum GangMember {
		SCOOBY(Images.Scooby), SHAGGY(Images.Shaggy), VELMA(Images.velma), DAPHNE(Images.Daf), FRED(Images.FredB);

		private Image image;

		private GangMember(Image image) {
			this.image = image;
		}

		public Image getImage() {
			return image;
		}

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

		public static GangMember randomMember(Random rand) {
			return values()[rand.nextInt(values().length)];
		}
	}

}
