package scoobydoo.engine.gui;

import java.awt.Color;
import java.awt.Graphics;

import scoobydoo.main.Game;

/**
 * Represents a progress bar. The {@link IProgress} class is used to track the
 * progress
 */
public class ProgressBar extends Component {

	private static final Color OUTLINE_COLOR = Color.BLACK;

	private Color indicatorColor;
	private Color trackColor;
	private Color textColor;
	private IProgress progress;
	private int maxProgress;
	private String text;

	/**
	 * Creates a progress bar. The indicator color is the foreground color, the
	 * track color is the background color.
	 */
	public ProgressBar(int x, int y, int width, int height, Color indicatorColor, Color trackColor, Color textColor,
			IProgress progress, int maxProgress) {
		super(x, y, width, height);
		this.indicatorColor = indicatorColor;
		this.trackColor = trackColor;
		this.textColor = textColor;
		this.progress = progress;
		this.maxProgress = maxProgress;
		this.text = "";
	}

	/**
	 * Returns the maximum progress value
	 */
	public int getMaxProgress() {
		return maxProgress;
	}

	/**
	 * Sets the maximum progress value
	 */
	public void setMaxProgress(int maxProgress) {
		this.maxProgress = maxProgress;
	}

	/**
	 * Returns the text displayed by this progress bar
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text displayed by this progress bar
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(trackColor);
		g.fillRect(getX(), getY(), getWidth(), getHeight());

		g.setColor(indicatorColor);
		int progress = this.progress.getProgress();
		if (progress < 0) {
			progress = 0;
		} else if (progress > maxProgress) {
			progress = maxProgress;
		}
		g.fillRect(getX(), getY(), progress * getWidth() / maxProgress, getHeight());

		g.setColor(OUTLINE_COLOR);
		g.drawRect(getX(), getY(), getWidth(), getHeight());

		g.setColor(textColor);
		g.setFont(Game.NORMAL_FONT);
		drawCenteredString(g, text, getX() + getWidth() / 2, getY() + getHeight() / 2);
	}

}
