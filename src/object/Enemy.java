package object;

import java.awt.Rectangle;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.*;
import game.Object;

public class Enemy extends Object{
	

//CREATE_________________________________________________________________________________________________________
	
	private final int WIDTH = 100;
	private final int HEIGHT = 80;
	
	public Enemy(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, this.WIDTH, this.HEIGHT);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}
	

//RENDER_________________________________________________________________________________________________________
	
	
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(id == ID.Enemy1)
			g.drawImage(new Image("res/img/spr/enemyO.png"), x, y);
		if(id == ID.Enemy2) {
			g.drawImage(new Image("res/img/spr/warningsign.gif"), x, Main.HEIGHT/2);
			g.drawImage(new Image("res/img/spr/enemy2.png"), x, y);
		}
	}
	

//UPDATE_________________________________________________________________________________________________________

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(id == ID.Enemy1) {
			velY = 0.3f;
		}
		if(id == ID.Enemy2) {
			velY = -0.5f;
		}
		
		x += velX*delta;
		y += velY*delta;
		if(y < -100 || y > Main.HEIGHT + 300) {
			handler.removeObject(this);
		}
	//Carry object
//			if(r.nextInt(4)%2 == 0) handler.addObject(new Heal(x+15, y, ID.Heal, handler));
//			if(r.nextInt(9)%3 == 0) handler.addObject(new Power(x+15, y, ID.Power, handler));
		for(int i = 0; i < handler.object.size(); i++) {
			Object tempObj = handler.object.get(i);
			//with enemy	
				if(tempObj.getId() == ID.Bullet) 
					if(this.getBounds().intersects(tempObj.getBounds())) {
						handler.removeObject(this);
						HUD.SCORE += 10;
					}		
		}
	}


}