package framework;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

import object.Bullet;
import object.EnemyBoss;
import object.EnemyBullet;
import object.Id;
import object.Player;

public class BulletManager {
	protected ArrayList<Bullet> bulletManager = new ArrayList<Bullet>();
	protected ArrayList<EnemyBullet> eBulletManager = new ArrayList<EnemyBullet>();

	private float bulletSpeed = 10;
	private Player player;
	private EnemyBoss enemyBoss;
	private Id iD;
	private int delayTime = 0;

	public BulletManager(Player player, Id iD) {
		this.player = player;
		this.iD = iD;
	}

	public BulletManager(EnemyBoss enemyBoss, Id iD) {
		this.enemyBoss = enemyBoss;
		this.iD = iD;
	}

	public void update() {
		try {
			if (iD == Id.playerId) {
				if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
					bulletManager.add(new Bullet(player, player.getPlayerLocation(), new Vector2(0, bulletSpeed)));
				}
			} else if (iD == Id.enemyBossId) {
				if(++delayTime == 50) {
				eBulletManager
						.add(new EnemyBullet(enemyBoss, enemyBoss.getEnemyLocation(), new Vector2(0, bulletSpeed)));
				delayTime = 0;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void render() {
		try {
			int counter = 0;
			int eBulletCounter = 0;
			if (iD == Id.playerId) {
				while (counter < bulletManager.size()) {
					Bullet currentBullet = bulletManager.get(counter);
					if (currentBullet.getBulletLocation().y > 0
							&& currentBullet.getBulletLocation().y < MyGdxGame.screenHeight) {
						currentBullet.update();
						currentBullet.render();
					} else {
						bulletManager.remove(counter);
					}
					counter++;
				}
			} else if (iD == Id.enemyBossId) {
				while (eBulletCounter < eBulletManager.size()) {
					EnemyBullet currentBullet = eBulletManager.get(eBulletCounter);
					if (currentBullet.getEBulletLocation().y > 0) {
						currentBullet.update();
						currentBullet.render();
					} else {
						eBulletManager.remove(eBulletCounter);
					}
					eBulletCounter++;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
