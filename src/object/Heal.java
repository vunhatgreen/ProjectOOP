package object;
import java.awt.Graphics;
import java.awt.Rectangle;

import code.*;
import game.*;

public class Heal extends GameObject{

//VARIABLE ________________________________________________________
	
	private int timer;
	public Heal(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		velY = -3;	//speed
	}
	
	
//MASK ____________________________________________________________
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 15, 20);
	}	
	
	
//PROCESS _________________________________________________________	
	
	public void tick() {
		x += velX;
		y += velY + timer++/3;

		
		if(y > Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		
		//Collision
				for(int i = 0; i < handler.object.size(); i++) {
					GameObject tempObj = handler.object.get(i);
					//with player	
						if(tempObj.getId() == ID.Player) 
							if(this.getBounds().intersects(tempObj.getBounds())) {
								handler.removeObject(this);
								HUD.HEALTH += 50;
							}		
				}
				
	}
	
	
//RENDER ____________________________________________________________
	public void render(Graphics g) {
	//Object sprite
		new AddImage(x, y, 15, 20, "res//img//spr//heal.png", g);
		
	}
}
																																																																										