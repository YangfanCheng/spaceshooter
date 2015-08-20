package Main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public Window(){
		super();
		setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	public void addNotify(){super.addNotify();}
}
