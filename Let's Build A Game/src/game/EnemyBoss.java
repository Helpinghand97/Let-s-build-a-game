package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{
	
	private Handler handler;
	private Random ran = new Random();

	private int timer = 100;
	private int timer2 = 50;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		this.handler = handler;
		velY = 0;
		velX = 2;
	}


	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0)velY=0;
		else timer --;
		if(timer <= 0) timer2--;
		
		if(timer2 <= 0){
			if (velX == 0) velX = 3;
			int spawn = ran.nextInt(10);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int) x, (int) y, ID.Enemy, handler));
		}
		
		//if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
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