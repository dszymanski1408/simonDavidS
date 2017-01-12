package simonDavidS;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Components;

public class Button extends Components implements ButtonInterfaceDavidS {
	private static int w = 40;
	private static int h = 40;
	private static int x;
	private static int y;
	private Action act;
	private Color color;
	private Color normalColor;
	private boolean isHighlighted;
	
	public Button() {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		if(act != null){
			act.act();
		}
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return x>getX() && x<getX()+getWidth() && 
				y > getY() && y<getY()+getHeight();
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
		update();
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub
		this.act = a;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		isHighlighted = true;
		normalColor = color;
		update();
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		isHighlighted = false;
		normalColor = Color.DARK_GRAY;
		update();
		
		
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		if(!isHighlighted){
			g.setColor(normalColor);
			g.fillOval(x,y,w,h);
			g.setColor(Color.black);
			g.drawOval(x, y, w - 1, h - 1);
		}
		if(isHighlighted){
			g.setColor(normalColor);
			g.fillOval(x, y, w, h);
			g.setColor(Color.black);
			g.drawOval(x, y, w - 1, h -1);
		}
		
	}

}
