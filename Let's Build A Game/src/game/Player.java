package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	
	Handler handler;
	//Gets the Player position and the ID from the Game Class
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		this.handler = handler;
	}
	//Another version for update of where the Object is
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 64);
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
		collision();
	}
	
	private void collision(){
		
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Enemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){
				
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1;
				}
			}
		}
	}
	
	//Renders the graphics of the Player
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}
	
	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 32, 32);
	}
}