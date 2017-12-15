package object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

public class EnemyBullet {
	
	private EnemyBoss enemyBoss;
	private Texture eBulletTexture;
	private Vector2 eBulletLocation;
	private Vector2 eBulletVelocity;
	private float referentLocationX;
	private float referentLocationY;
	private Rectangle eBulletBounds;
	
	public EnemyBullet(EnemyBoss enemy, Vector2 sentLocation, Vector2 sentVelocity) {
		// TODO Auto-generated constructor stub
		this.enemyBoss = enemy;
		this.eBulletTexture = new Texture("bullet1.png");
		this.eBulletLocation = new Vector2(sentLocation.x + 125, sentLocation.y);
		this.eBulletVelocity = new Vector2(sentVelocity.x, sentVelocity.y);
		init();
	}
	
	
	
	public Vector2 getEBulletLocation() {
		return eBulletLocation;
	}



	public void setEBulletLocation(Vector2 eBulletLocation) {
		this.eBulletLocation = eBulletLocation;
	}



	public Vector2 getEBulletVelocity() {
		return eBulletVelocity;
	}



	public void setEBulletVelocity(Vector2 eBulletVelocity) {
		this.eBulletVelocity = eBulletVelocity;
	}



	public Rectangle getBounds() {
		return eBulletBounds;
	}
	
	public void init() {
		referentLocationX = (enemyBoss.getEnemyTexture().getWidth() - eBulletTexture.getWidth()) / 2 - 125;
		referentLocationY = MyGdxGame.screenHeight - enemyBoss.getEnemyTexture().getHeight();
		eBulletBounds = new Rectangle(eBulletLocation.x, eBulletLocation.y, eBulletTexture.getWidth(), eBulletTexture.getHeight());
	}


	public void update() {
		eBulletLocation.y -= eBulletVelocity.y;
		eBulletLocation.x += eBulletVelocity.x;
		eBulletBounds.setPosition(eBulletLocation);
	}
	
	public void render() { 
		MyGdxGame.batch.draw(eBulletTexture, eBulletLocation.x + referentLocationX, eBulletLocation.y);
	}
}
