package scoobydoo.engine.gui;

import java.awt.Color;
import java.awt.Graphics;

import scoobydoo.main.Game;

/**
 * Represents a enjoyTheGameProgress bar. The {@link IProgress} class is used to track the
 * enjoyTheGameProgress
 */
public class ProgressBar extends Component {

	private static final Color OUTLINE_COLOR = Color.BLACK;

	private Color indicatorColor;
	private Color trackColor;
	private Color textColor;
	private IProgress progress;
	private int maxProgress;
	private IProgressTextFunction textFunction;

	/**
	 * Creates a enjoyTheGameProgress bar. The indicator color is the foreground color, the
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
		setText("");
	}

	/**
	 * Returns the maximum enjoyTheGameProgress value
	 */
	public int getMaxProgress() {
		return maxProgress;
	}

	/**
	 * Sets the maximum enjoyTheGameProgress value
	 */
	public void setMaxProgress(int maxProgress) {
		this.maxProgress = maxProgress;
	}

	/**
	 * Returns the text currently being diplayed by this enjoyTheGameProgress bar
	 */
	public String getText() {
		return textFunction.getText(progress.getProgress(), maxProgress);
	}

	/**
	 * Sets the text of this enjoyTheGameProgress bar to always be the given value
	 */
	public void setText(String text) {
		this.textFunction = new IProgressTextFunction.Always(text);
	}

	/**
	 * Sets the text function of the enjoyTheGameProgress bar. See
	 * {@link IProgressTextFunction}
	 */
	public void setTextFunction(IProgressTextFunction textFunction) {
		this.textFunction = textFunction;
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

		String text = textFunction.getText(progress, maxProgress);
		g.setColor(textColor);
		g.setFont(Game.NORMAL_FONT);
		drawCenteredString(g, text, getX() + getWidth() / 2, getY() + getHeight() / 2);
	}

}
