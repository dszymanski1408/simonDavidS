package simonDavidS;

import gui.GUIApplication;

public class SimonGameDavidS extends GUIApplication {

	public SimonGameDavidS(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		SimonScreenDavidS ssds = 
				new SimonScreenDavidS(getWidth(), getHeight()); 
		setScreen(ssds);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimonGameDavidS sgds = new SimonGameDavidS(800, 500);
		Thread game = new Thread(sgds);
		game.start();
	}

}
