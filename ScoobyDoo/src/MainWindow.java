import java.awt.Dimension;

import javax.swing.JPanel;

public class MainWindow extends JPanel {

	private static final long serialVersionUID = -3880026026104218593L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public MainWindow() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

}
