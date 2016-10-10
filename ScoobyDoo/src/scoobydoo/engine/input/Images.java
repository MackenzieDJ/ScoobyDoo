package scoobydoo.engine.input;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * This class contains all the images used in the game
 */
public class Images {

	private static final Image FAILED_IMAGE = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

	static {
		Graphics g = FAILED_IMAGE.getGraphics();
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 8, 8);
		g.fillRect(8, 8, 8, 8);
		g.setColor(Color.BLACK);
		g.fillRect(8, 0, 8, 8);
		g.fillRect(0, 8, 8, 8);
		g.dispose();
	}

	// Add your images here (not above!)
	public static final Image test = loadImage("test");
	public static final Image Title = loadImage("Title");
	public static final Image ALL = loadImage("ALL");
	public static final Image Shaggy = loadImage("Shaggy");
	public static final Image ScoobyShaggy = loadImage("Scooby+shaggy");
	public static final Image allInMachine = loadImage("all-in-machine");
	public static final Image Scooby = loadImage("Scooby");
	public static final Image FredB = loadImage("FredB");
	public static final Image Daf = loadImage("Daf");
	public static final Image velma = loadImage("velma");

	/**
	 * Loads a image
	 * 
	 * @param resKey
	 *            - the name of the image in the resources
	 */
	public static Image loadImage(String resKey) {
		try {
			InputStream input = Images.class.getResourceAsStream("/images/" + resKey + ".png");
			if (input == null) {
				throw new IOException("input == null");
			}
			return ImageIO.read(input);
		} catch (IOException e) {
			System.err.println("Failed to load image with resKey " + resKey);
			return FAILED_IMAGE;
		}
	}

}
