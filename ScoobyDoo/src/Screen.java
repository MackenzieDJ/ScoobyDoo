import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Screen {

	protected int width;
	protected int height;
	private List<Component> components = Collections.synchronizedList(new ArrayList<Component>());

	public final void validate(int width, int height) {
		this.width = width;
		this.height = height;
		synchronized (components) {
			for (Component component : components) {
				component.registerOwningScreen(null);
			}
			components.clear();
		}
		layout();
	}

	public void onScreenOpened() {
	}

	public void onScreenClosed() {
	}

	public void layout() {
	}

	public void addComponent(Component component) {
		components.add(component);
		component.registerOwningScreen(this);
	}

	public void removeComponent(Component component) {
		components.remove(component);
		component.registerOwningScreen(null);
	}

	public List<Component> getComponents() {
		return Collections.unmodifiableList(components);
	}

	// button can be MouseEvent.BUTTON1 for left-click, MouseEvent.BUTTON2 for
	// right-click
	public void mousePressed(int x, int y, int button) {
		synchronized (components) {
			for (Component component : new ArrayList<Component>(components)) {
				component.onMousePressed(x, y, button);
			}
		}
	}

	public void mouseReleased(int x, int y, int button) {
		synchronized (components) {
			for (Component component : new ArrayList<Component>(components)) {
				component.onMouseReleased(x, y, button);
			}
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		synchronized (components) {
			for (Component component : components) {
				component.draw(g);
			}
		}
	}

	public void updateTick() {
		synchronized (components) {
			for (Component component : new ArrayList<Component>(components)) {
				component.updateTick();
			}
		}
	}

	public void onButtonPressed(String buttonId) {
	}

}
