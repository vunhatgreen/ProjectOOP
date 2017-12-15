package framework;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.MyGdxGame.State;

import object.EnemyBoss;
import object.Id;
import object.Player;

public class CollisionHandler {
	private Player player;
	private EnemyManager enemies;
	private EnemyBoss enemyBoss;
	private BulletManager bullets;

	public CollisionHandler(Player player, EnemyManager enemies, BulletManager bullets) {
		this.player = player;
		this.enemies = enemies;
		this.bullets = bullets;
	}

	public void update() {
		try {
			if (!enemies.enemyManager.isEmpty()) {
				for (int i = 0; i < enemies.enemyManager.size(); i++) {
					if (!bullets.bulletManager.isEmpty()) {
						for (int j = 0; j < bullets.bulletManager.size(); j++) {
							if (enemies.enemyManager.get(i).getBounds().overlaps(bullets.bulletManager.get(j).getBounds())) {
								enemies.enemyManager.remove(i);
								bullets.bulletManager.remove(j);
								player.score += 20;					
							}
						}
					}
				}
				for (int i = 0; i < enemies.enemyManager.size(); i++) {
					if (enemies.enemyManager.get(i).getBounds().overlaps(player.getBounds())) {	
						enemies.enemyManager.remove(i);
						player.health--;
					}
				}
			}
			if (!bullets.bulletManager.isEmpty()) {
				for (int j = 0; j < bullets.bulletManager.size(); j++) {
					if (enemies.enemyBossManager.get(0).getBounds().overlaps(bullets.bulletManager.get(j).getBounds())) {
						bullets.bulletManager.remove(j);
						enemies.enemyBossManager.get(0).health--;
						if (enemies.enemyBossManager.get(0).health == 0) {
							enemies.isBossDead = true;
							player.score += 100;
						}
					}
				}
			}
			if (enemies.enemyBossManager.get(0).getBounds().overlaps(player.getBounds())) {
				player.health--;
			}
			if (!enemies.enemyBossManager.get(0).eBulletManager.eBulletManager.isEmpty()) {
				for (int j = 0; j < enemies.enemyBossManager.get(0).eBulletManager.eBulletManager.size(); j++) {
					if (enemies.enemyBossManager.get(0).eBulletManager.eBulletManager.get(j).getBounds().overlaps(player.getBounds())) {
						enemies.enemyBossManager.get(0).eBulletManager.eBulletManager.remove(j);
						player.health--;
					}
				}
			}
		} catch (IndexOutOfBoundsException indexException) {
			indexException.printStackTrace();
		} catch (NullPointerException nullPointer) {
			nullPointer.printStackTrace();
		}
	}
}
