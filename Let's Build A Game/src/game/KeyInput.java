package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	//Get the Handler from the Game Class
	public KeyInput(Handler handler){
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	//Runs when the key is Pressed
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				
				if(key == KeyEvent.VK_W){ tempObject.setvelY(-1); keyDown[0] = true; }
				if(key == KeyEvent.VK_S){ tempObject.setvelY(1); keyDown[1] = true; }
				if(key == KeyEvent.VK_A){ tempObject.setvelX(-1); keyDown[2] = true; }
				if(key == KeyEvent.VK_D){ tempObject.setvelX(1); keyDown[3] = true; }
			}
		}
		
				if(key == KeyEvent.VK_ESCAPE)System.exit(1);
		}
		
	//Runs when the Keys are Released
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
				if(tempObject.getId()== ID.Player){
					if(key == KeyEvent.VK_W)keyDown[0]= false;
					if(key == KeyEvent.VK_S)keyDown[1]= false;
					if(key == KeyEvent.VK_A)keyDown[2]= false;
					if(key == KeyEvent.VK_D)keyDown[3]= false;
				
					if(!keyDown[0] && !keyDown[1]) tempObject.setvelY(0);
					
					if(!keyDown[2] && !keyDown[3]) tempObject.setvelX(0);
				}
		}	
	}
	
	
}
