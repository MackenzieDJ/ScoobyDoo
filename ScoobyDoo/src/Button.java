import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Button extends Component {

	private static final Color NORMAL_BG_COLOR = new Color(140, 230, 36); // green
	private static final Color NORMAL_OUTLINE_COLOR = new Color(46, 134, 158); // blue
	private static final Color NORMAL_TEXT_COLOR = new Color(242, 56, 7); // orange
	private static final Color HOVERED_BG_COLOR = NORMAL_BG_COLOR.brighter();
	private static final Color HOVERED_OUTLINE_COLOR = NORMAL_OUTLINE_COLOR.brighter();
	private static final Color HOVERED_TEXT_COLOR = NORMAL_TEXT_COLOR.brighter();
	private static final Color PRESSED_BG_COLOR = new Color(190, 240, 16); // yellow-green
	private static final Color PRESSED_OUTLINE_COLOR = new Color(70, 141, 140); // yellow-blue
	private static final Color PRESSED_TEXT_COLOR = new Color(244, 110, 23); // yellow-orange
	private static final Font FONT = new Font(Font.MONOSPACED, Font.PLAIN, 18);

	private String text;
	private String buttonId;

	public Button(int x, int y, int width, int height, String text, String buttonId) {
		super(x, y, width, height);
		this.text = text;
		this.buttonId = buttonId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private boolean isHovered(int x, int y) {
		return x >= getX() && y >= getY() && x < getX() + getWidth() && y < getY() + getHeight();
	}

	@Override
	public void onMouseReleased(int x, int y, int button) {
		if (button == MouseEvent.BUTTON1 && isHovered(x, y)) {
			getOwningScreen().onButtonPressed(buttonId);
		}
	}

	@Override
	public void draw(Graphics g) {
		Color bgColor;
		Color outlineColor;
		Color textColor;
		Point mouseLocation = Mouse.getMouseLocation();
		if (isHovered((int) mouseLocation.x, (int) mouseLocation.y)) {
			if (Mouse.isButtonDown(MouseEvent.BUTTON1)) {
				bgColor = PRESSED_BG_COLOR;
				outlineColor = PRESSED_OUTLINE_COLOR;
				textColor = PRESSED_TEXT_COLOR;
			} else {
				bgColor = HOVERED_BG_COLOR;
				outlineColor = HOVERED_OUTLINE_COLOR;
				textColor = HOVERED_TEXT_COLOR;
			}
		} else {
			bgColor = NORMAL_BG_COLOR;
			outlineColor = NORMAL_OUTLINE_COLOR;
			textColor = NORMAL_TEXT_COLOR;
		}

		g.setColor(bgColor);
		g.fillRect(getX(), getY(), getWidth(), getHeight());

		g.setColor(outlineColor);
		g.drawRect(getX(), getY(), getWidth(), getHeight());

		g.setColor(textColor);
		g.setFont(FONT);
		Rectangle2D textSize = g.getFontMetrics().getStringBounds(text, g);
		g.drawString(text, getX() + getWidth() / 2 - (int) (textSize.getWidth() / 2),
				getY() + getHeight() / 2 + (int) (textSize.getHeight() / 4));
	}

}
