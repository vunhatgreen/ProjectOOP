package code;

import java.awt.Color;
import java.awt.Graphics;

public class AddHealthBar{
	private int x;
	private int y;
	private int sizeX;
	private int sizeY;
	private int health;
	private int deltaHealth;
	private String colorBG = "#888888";
	private String colorHealth = "#5cb85c";
	private String colorBorder = "#ffffff";
	private String colorDeltaHealth = "#c43335";
	

	public AddHealthBar(int x, int y, int sizeX, int sizeY, int health, Graphics g) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.health = health;
		render(g);
	}
	//With color
	public AddHealthBar(int x, int y, int sizeX, int sizeY, String colorBG, String colorHealth, String colorBorder, String colorDeltaHealth, int health, int deltaHealth, Graphics g) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.health = health;
		this.deltaHealth = deltaHealth;
		this.colorBG = colorBG;
		this.colorHealth = colorHealth;
		this.colorBorder = colorBorder;
		render(g);
	}
	
	
	
	public void render(Graphics g) {
		health = new Block(health, 0, 100).clamp();
		g.setColor(Color.decode(colorBG));
		g.fillRect(x, y, sizeX, sizeY);
		g.setColor(Color.decode(colorDeltaHealth));
		g.fillRect(x, y, deltaHealth*sizeX/100, sizeY);
		g.setColor(Color.decode(colorHealth));
		g.fillRect(x, y, health*sizeX/100, sizeY);
		g.setColor(Color.decode(colorBorder));
		g.drawRect(x, y, sizeX, sizeY);
	}
}
