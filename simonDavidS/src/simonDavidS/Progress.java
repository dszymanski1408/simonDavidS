package simonDavidS;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import gui.components.Components;

public class Progress extends Components implements ProgressInterfaceDavidS {
	
	private boolean gameOver;
	private static int height = 50;
	private static int width = 140;
	private String round;
	private String sequenceSize;
	private String font = "Comic Sans MS";
	private int size = 20;
	
	
	
	public Progress() {
		super(60, 60, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setSequenceSize(int size) {
		// TODO Auto-generated method stub
		sequenceSize = "Length " + size;
		update();
	}

	@Override
	public void setRound(int roundNumber) {
		// TODO Auto-generated method stub
		round = "Round #" + roundNumber;
		update();
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		gameOver = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font(font , Font.PLAIN,size));
		FontMetrics fm = g.getFontMetrics(); 
		if(!gameOver){
			g.setColor(Color.green);
			g.fillRect(0,0,width,height);
			g.setColor(Color.black);
			g.drawRect(0,0,width-1, height -1);
			if(round != null) g.drawString(round, (width - fm.stringWidth(round))/2, 20);
			if(sequenceSize != null) g.drawString(sequenceSize, (width - fm.stringWidth(sequenceSize))/2, 40);
		}
		else{
			g.setColor(Color.red);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.black);
			g.drawString("Game Over!", (width - fm.stringWidth("Game Over!"))/2, 30);
		}
	}

}
