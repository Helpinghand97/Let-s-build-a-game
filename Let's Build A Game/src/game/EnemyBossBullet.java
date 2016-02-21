package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	Random ran = new Random();
	private Handler handler;
	
	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		this.handler = handler;
		velY = (ran.nextInt(5 - -5) + -5);
		velX = 2;
	}


	public void tick() {
		x += velX;
		y += velY;
		
		//if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		handler.addObject(new Trail((int)x,(int)y, ID.Trail, Color.red, 16, 16, 0.02f, handler ));
	}


	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {

		return new Rectangle((int) x,(int)y, 16, 16);
	}

}
