import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public class Mouse extends MouseAdapter {

	private static final Mouse INSTANCE = new Mouse();

	private final Set<Integer> buttonsPressed = new HashSet<Integer>();
	private final Set<Integer> buttonsReleased = new HashSet<Integer>();
	private final Set<Integer> buttonsDown = new HashSet<Integer>();
	private final Set<Integer> pendingButtonsPressed = new HashSet<Integer>();
	private final Set<Integer> pendingButtonsReleased = new HashSet<Integer>();

	private final Object SYNC_LOCK = new Object();

	private Mouse() {
	}
	
	public static Mouse instance() {
		return INSTANCE;
	}

	public static boolean isButtonPressed(int button) {
		return INSTANCE.doIsButtonPressed(button);
	}

	private boolean doIsButtonPressed(int button) {
		synchronized (SYNC_LOCK) {
			return buttonsPressed.contains(button);
		}
	}

	public static boolean isButtonReleased(int button) {
		return INSTANCE.doIsButtonReleased(button);
	}

	private boolean doIsButtonReleased(int button) {
		synchronized (SYNC_LOCK) {
			return buttonsReleased.contains(button);
		}
	}

	public static boolean isButtonDown(int button) {
		return INSTANCE.doIsButtonDown(button);
	}

	private boolean doIsButtonDown(int button) {
		synchronized (SYNC_LOCK) {
			return buttonsDown.contains(button);
		}
	}

	public static void pressButton(int button) {
		INSTANCE.doPressButton(button);
	}

	private void doPressButton(int button) {
		synchronized (SYNC_LOCK) {
			if (!buttonsDown.contains(button)) {
				pendingButtonsPressed.add(button);
			}
		}
	}

	public static void releaseButton(int button) {
		INSTANCE.doReleaseButton(button);
	}

	private void doReleaseButton(int button) {
		synchronized (SYNC_LOCK) {
			if (buttonsDown.contains(button)) {
				pendingButtonsReleased.add(button);
			}
		}
	}

	public static void clearButtons() {
		INSTANCE.doClearButtons();
	}

	private void doClearButtons() {
		synchronized (SYNC_LOCK) {
			for (Integer button : buttonsDown) {
				pendingButtonsReleased.add(button);
			}
		}
	}

	public static void updateTick() {
		INSTANCE.doUpdateTick();
	}

	private void doUpdateTick() {
		synchronized (SYNC_LOCK) {
			buttonsPressed.clear();
			for (Integer button : pendingButtonsPressed) {
				buttonsPressed.add(button);
				buttonsDown.add(button);
			}
			pendingButtonsPressed.clear();

			buttonsReleased.clear();
			for (Integer button : pendingButtonsReleased) {
				buttonsReleased.add(button);
				buttonsDown.remove(button);
			}
			pendingButtonsReleased.clear();
		}
	}

	public static Point getMouseLocation() {
		Point locOnScreen = MouseInfo.getPointerInfo().getLocation();
		Point windowLoc = Game.theWindow.getLocationOnScreen();
		return new Point(locOnScreen.x - windowLoc.x, locOnScreen.y - windowLoc.y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		doPressButton(e.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		doReleaseButton(e.getButton());
	}

}
