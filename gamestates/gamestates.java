package GameStates;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public interface GameStates {
	public abstract void init();
	public abstract void update();
	public abstract void draw(java.awt.Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
}
