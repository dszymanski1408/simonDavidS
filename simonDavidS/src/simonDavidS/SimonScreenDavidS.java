package simonDavidS;

import java.awt.Color;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class SimonScreenDavidS extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceDavidS[] buttons;
	private ProgressInterfaceDavidS progress;
	private ArrayList<MoveInterfaceDavidS> moves;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenDavidS(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		progress = getProgress();
		label = new TextLabel(130, 230, 300, 40, "Let's play Simon!");
		moves = new ArrayList<MoveInterfaceDavidS>();
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	
	private MoveInterfaceDavidS randomMove() {
		// TODO Auto-generated method stub
		ButtonInterfaceDavidS b;
		int randomInt = (int)(Math.random()*buttons.length);
		while(randomInt == lastSelectedButton){
			randomInt = (int)(Math.random()*buttons.length);
		}
		b = buttons[randomInt];
		return getMove(b);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceDavidS getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		int numberOfButtons = 4;
		Color[] colors = {Color.blue, Color.red, Color.yellow, Color.green};
		int[] xs = {100, 150, 100, 150};
		int[] ys = {100, 200, 300, 200};
		for(int i = 0; i < numberOfButtons; i++){
			final ButtonInterfaceDavidS b = getAButton();
			b.setColor(colors[i]);
			b.setX(xs[i]);
			b.setY(ys[i]);
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								Thread.sleep(800);
								b.dim();
							}
						});
						blink.start();
						if(b == moves.get(sequenceIndex).getButton()){
							
						}
					}
				}
			});
		}
	}

}
