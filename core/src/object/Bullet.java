package object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

public class Bullet {
	private Texture bulletTexture;
	private Vector2 bulletLocation;
	private Vector2 bulletVelocity;
	private float referentLocationX;
	private float referentLocationY;
	private Player player;
	private Rectangle bulletBounds;
	
	
	public Bullet(Player player, Vector2 sentLocation, Vector2 sentVelocity) {
		this.player = player;
		bulletTexture = new Texture("bullet.png");
		bulletLocation = new Vector2(sentLocation.x, sentLocation.y);
		bulletVelocity = new Vector2(sentVelocity.x, sentVelocity.y);
		init();
	}

	public Vector2 getBulletLocation() {
		return bulletLocation;
	}


	public void setBulletLocation(Vector2 bulletLocation) {
		this.bulletLocation = bulletLocation;
	}


	public Vector2 getBulletVelocity() {
		return bulletVelocity;
	}


	public void setBulletVelocity(Vector2 bulletVelocity) {
		this.bulletVelocity = bulletVelocity;
	}
	
	public Rectangle getBounds() {
		return bulletBounds;
	}
	
	public void init() {
		referentLocationX = (player.getPlayerTexture().getWidth() - bulletTexture.getWidth()) / 2;
		referentLocationY = player.getPlayerTexture().getHeight();
		bulletBounds = new Rectangle(bulletLocation.x, bulletLocation.y, bulletTexture.getWidth(), bulletTexture.getHeight());
		
	}


	public void update() {
		bulletLocation.x += bulletVelocity.x;
		bulletLocation.y += bulletVelocity.y;
		bulletBounds.setPosition(bulletLocation);
	}
	
	public void render() { 
		MyGdxGame.batch.draw(bulletTexture, bulletLocation.x + referentLocationX, bulletLocation.y + referentLocationY);
	}
	
	
}
