/**
 * 
 */
package simonDavidS;
//now it works
import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

/**
 * @author David Szymanski
 *
 */
public interface ButtonInterfaceDavidS extends Clickable {
	public void setColor(Color color);
	public void setX(int x);
	public void setY(int y);
	public void setAction(Action a);
	public void highlight();
	public void dim();
}
