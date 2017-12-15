package object;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

public class Enemy {
	private Texture enemyTexture;
	private Texture enemyBossTexture;
	private Vector2 enemyLocation;
	public Rectangle enemyBounds;
	public int health = 100;
	private Random r = new Random();
	
	public Enemy() {
		init();
	}
	
	
	public Texture getEnemyTexture() {
		return enemyTexture;
	}

	

	public void setEnemyTexture(Texture enemyTexture) {
		this.enemyTexture = enemyTexture;
	}

	public Vector2 getEnemyLocation() {
		return enemyLocation;
	}



	public void setEnemyLocation(Vector2 enemyLocation) {
		this.enemyLocation = enemyLocation;
	}

	public Rectangle getBounds() {
		return enemyBounds;
	}
	
	public void setBounds(Rectangle enemyBossBounds) {
		enemyBounds = enemyBossBounds;
	}
	
	public void init() {
		enemyTexture = new Texture("enemyO.png");
		enemyLocation = new Vector2(r.nextFloat()*(MyGdxGame.screenWidth - enemyTexture.getWidth()), MyGdxGame.screenHeight + enemyTexture.getHeight());
		enemyBounds = new Rectangle(enemyLocation.x, enemyLocation.y, enemyTexture.getWidth(), enemyTexture.getHeight());
	}
	
	public void update() {
		enemyLocation.y -= 5;
		enemyBounds.setPosition(enemyLocation);
	}
	
	public void render() {
		MyGdxGame.batch.draw(enemyTexture, enemyLocation.x, enemyLocation.y);
	}
}
