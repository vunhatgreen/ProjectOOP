package game;

import java.awt.Graphics;

import code.AddImage;

public class Background {
	
//VARIABLE _______________________________________________________
	
	private int l1x1 = 0, l1x2 = 0;
	private int l1y1 = 0, l1y2 = -Game.HEIGHT;
	private int l2x1 = 0, l2x2 = 0;
	private int l2y1 = 0, l2y2 =-Game.HEIGHT;
	private int velX = 0;
	private int velY = 1;

	
//PROCESS ________________________________________________________	
	
	public void tick() {
		l1x1 += velX;
		l1y1 += velY;
		l1x2 += velX;
		l1y2 += velY;
		
		l2x1 += velX*2;
		l2y1 += velY*2;
		l2x2 += velX*2;
		l2y2 += velY*2;
	}
	
	
//RENDER _________________________________________________________
	
	public void render(Graphics g) {
		//Background
		new AddImage(l1x1, l1y1, Game.WIDTH, Game.HEIGHT, "res//img//bg//galaxy.png", g);
		new AddImage(l1x2, l1y2, Game.WIDTH, Game.HEIGHT, "res//img//bg//galaxy.png", g);

		//Layout 2
		new AddImage(l2x1, l2y1, Game.WIDTH, Game.HEIGHT, "res//img//bg//galaxy2.png", g);
		new AddImage(l2x2, l2y2, Game.WIDTH, Game.HEIGHT, "res//img//bg//galaxy2.png", g);

		//Repeat
		if(l1y1 > Game.HEIGHT-3) l1y1 = -Game.HEIGHT;
		if(l1y2 > Game.HEIGHT-3) l1y2 = -Game.HEIGHT;
		
		if(l2y1 > Game.HEIGHT-3) l2y1 = -Game.HEIGHT;
		if(l2y2 > Game.HEIGHT-3) l2y2 = -Game.HEIGHT;
	}
}
