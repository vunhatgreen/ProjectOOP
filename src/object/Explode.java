package object;
import java.awt.Graphics;
import java.awt.Rectangle;

import code.*;
import game.*;

public class Explode extends GameObject{

//VARIABLE ________________________________________________________
	
	private int timer;
	public Explode(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		velY = 3;	//speed
	}
	
	
	
//MASK ____________________________________________________________
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 15, 20);
	}	
	
	
//PROCESS _________________________________________________________	
	
	public void tick() {
		timer++;
		x += velX;
		y += velY;
		
		if(timer > 30) {
			handler.removeObject(this);
		}
		
		
	}
	
	
//RENDER ____________________________________________________________
	public void render(Graphics g) {
	//Object sprite
		//new AddImage(x, y, 50, 50, "res//img//eff//ezgif-4-c14022e36a.gif", g);
		
	}
}
																																																																										