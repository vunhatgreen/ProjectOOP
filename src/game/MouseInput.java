package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import code.Block;


public class MouseInput implements MouseListener, MouseMotionListener{
	private Handler handler;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
		
	}
//PLAYER MOVEMENT	

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		int newX = e.getX();
		int newY = e.getY();
		newX = new Block(newX, 0, Game.WIDTH-60).clamp();
		newY = new Block(newY, 30, Game.HEIGHT-130).clamp();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			//key for player
			if(tempObj.getId() == ID.Player) {
				if(newX != tempObj.getX()) { tempObj.setX(newX); }
				if(newY != tempObj.getX()) { tempObj.setY(newY); }
			}
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
