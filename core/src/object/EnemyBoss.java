package object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

import framework.BulletManager;

public class EnemyBoss extends Enemy {
	
	private Vector2 bossVelocity = new Vector2(1, 5);
	public BulletManager eBulletManager;
	private Texture bossTexture;
	
	public EnemyBoss() {
		super();
		// TODO Auto-generated constructor stub
		init();
	}
	
	@Override
	public void init() {
		setEnemyTexture(new Texture("enemyBoss.png"));
		setEnemyLocation(new Vector2(MyGdxGame.screenWidth / 2 - getEnemyTexture().getWidth() / 2,
				MyGdxGame.screenHeight + getEnemyTexture().getHeight()));
		setBounds(new Rectangle(getEnemyLocation().x, getEnemyLocation().y,getEnemyTexture().getWidth(),getEnemyTexture().getHeight()));
	eBulletManager = new BulletManager(this, Id.enemyBossId);
	}
	
	@Override
	public void update() {
		if (getEnemyLocation().y >= (MyGdxGame.screenHeight - getEnemyTexture().getHeight() - 5)) {
			getEnemyLocation().y -= bossVelocity.y;
		} else {
			getEnemyLocation().x += bossVelocity.x;
			if (getEnemyLocation().x > (MyGdxGame.screenWidth - getEnemyTexture().getWidth()) || getEnemyLocation().x < 0) {
				bossVelocity.x *= -1;
			}	
		}
		eBulletManager.update();
		getBounds().setPosition(getEnemyLocation());
	}
	
	@Override
	public void render() {
		update();
		eBulletManager.render();
		MyGdxGame.batch.draw(getEnemyTexture(), getEnemyLocation().x, getEnemyLocation().y);
	}
}
