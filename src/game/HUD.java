package game;

import java.awt.Graphics;

import code.AddHealthBar;
import code.AddString;
import code.Block;

public class HUD {
	
//VARIABLE _______________________________________________________
	
	public static int LEVEL = 0;
	public static int TIMER = 0;
	public static int POWER = 1;
	public static int SCORE = 0;
	public static int HEALTH = 100;
	public static int deltaHealth = HEALTH;
	
	

	//PROCESS ________________________________________________________	
	
	//Getter & setter


	public void tick() {
		TIMER++;
		HEALTH = new Block(HEALTH, 0, 100).clamp();
		if(deltaHealth > HEALTH) deltaHealth--;
		else deltaHealth = HEALTH;
		
	}
	
	
//RENDER _________________________________________________________
	
	public void render(Graphics g) {
		//HUD
		new AddHealthBar(Game.WIDTH/2-60, Game.HEIGHT-50, 120, 7, "#888888","#ffffff", "#ffffff", "#c43335", HEALTH, deltaHealth, g);
//		new AddHealthBar(20, 20, 120, 8, "#888888","#ffffff", "#ffffff", "#c43335", HEALTH, deltaHealth, g);
		
		new AddString(15, Game.HEIGHT-45, "#FFFFFF", "Level: " + LEVEL, g);
		new AddString(Game.WIDTH-70, Game.HEIGHT-45, "#FFFFFF", "Power: " + POWER, g);
	
	}
}
