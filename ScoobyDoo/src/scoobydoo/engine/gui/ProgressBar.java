package scoobydoo.engine.gui;

import java.awt.Color;
import java.awt.Graphics;

import scoobydoo.main.Game;

public class ProgressBar extends Component {

	private static final Color OUTLINE_COLOR = Color.BLACK;

	private Color indicatorColor;
	private Color trackColor;
	private Color textColor;
	private IProgress progress;
	private int maxProgress;
	private String text;

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

	public int getMaxProgress() {
		return maxProgress;
	}

	public void setMaxProgress(int maxProgress) {
		this.maxProgress = maxProgress;
	}

	public String getText() {
		return text;
	}

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
