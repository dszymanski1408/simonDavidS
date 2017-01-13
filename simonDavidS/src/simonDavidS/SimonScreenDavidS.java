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
		label.setText("");
		nextRound();
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;
		roundNumber++;
		moves.add(randomMove());
		progress.setSequenceSize(moves.size());
		progress.setRound(roundNumber);
		changeText("Simon's Turn");
		changeText("");
		playSequence();
		changeText("Your Turn");
		changeText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		// TODO Auto-generated method stub
		ButtonInterfaceDavidS b = null;
		for(int i = 0; i < moves.size(); i++){
			if(b != null){
				b.dim();
			}
			b = moves.get(i).getButton();
			b.highlight();
			int sleepTime = (int)((1000/roundNumber + 1) * 2);
			try {
			Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(b != null){
			b.dim();
		}
	}
	
	private void changeText(String string) {
		// TODO Auto-generated method stub
		label.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons(viewObjects);
		for(int i = 0; i < buttons.length; i++){
			viewObjects.add(buttons[i]);
		}
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

	private MoveInterfaceDavidS getMove(ButtonInterfaceDavidS b) {
		// TODO Auto-generated method stub
		return new Move(b);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceDavidS getProgress() {
		// TODO Auto-generated method stub
		return new Progress();
	}

	private void addButtons(ArrayList<Visible> viewObject) {
		// TODO Auto-generated method stub
		int numberOfButtons = 5;
		Color[] colors = {Color.blue, Color.red, Color.yellow, Color.green, Color.magenta};
		int[] x = {100, 200, 300, 400, 500};
		buttons = new ButtonInterfaceDavidS[numberOfButtons];	
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = getAButton();
			buttons[i].setColor(colors[i]);
			buttons[i].setX(x[i]);
			buttons[i].setY(300);
			final ButtonInterfaceDavidS b = buttons[i];
			b.dim();
			buttons[i].setAction(new Action(){
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == moves.get(sequenceIndex).getButton()){
							sequenceIndex++;
							
						}
						else{
							progress.gameOver();
							acceptingInput = false;
							return;
						}
						if(sequenceIndex == moves.size()){
							Thread nextRound = new Thread(SimonScreenDavidS.this);
							nextRound.start(); 
						}
						
					}
				}
			});
			buttons[i] = b;
			viewObject.add(b);
		}
	}

	private ButtonInterfaceDavidS getAButton() {
		// TODO Auto-generated method stub
		return new Button();
	}

}
