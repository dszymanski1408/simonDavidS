/**
 * 
 */
package simonDavidS;

import java.awt.Graphics2D;

import gui.components.Visible;

/**
 * @author David Szymanski
 *
 */
public interface ProgressInterfaceDavidS extends Visible {

	void setSequenceSize(int size);

	void setRound(int roundNumber);

	void gameOver();

	void update(Graphics2D g);

}
