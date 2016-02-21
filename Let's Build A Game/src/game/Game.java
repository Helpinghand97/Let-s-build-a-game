package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -6027780205995783372L;
	//Setting the Resolution
	public static final int WIDTH = 640 + 64, HEIGHT = WIDTH / 12 * 9;
	
	//Creating the thread for the game
	public Thread thread;
	
	//If its running or not
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	private Spawn spawn;
	private Random ran;
	private Menu menu;
	
	public enum STATE {
		Menu,
		Game
	};
	
	public STATE gameState = STATE.Menu;
	
	public static void main(String agrs[]){
		new Game();
	}
	
	//Sending the things the constructor is asking for in the Window Class
	public Game(){
		handler = new Handler();
		ran = new Random();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
		
		hud = new HUD();
		spawn = new Spawn(handler, hud);
		menu = new Menu(this, handler);
		this.addMouseListener(menu);
		
		if(gameState == STATE.Game){
		}
	}
	
	//When the Game starts this code runs at the same time
	public synchronized void start(){
		thread= new Thread(this);
		thread.start();
		running = true;
		
	}
	
	//While the code is running it gets the Frames
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis()- timer > 1000){
				timer+= 1000;
				frames = 0;
			}
		}

	}
	
	//Gets the ticks and sends it to multiple classes
	private void tick(){
		handler.tick();
		if(gameState == STATE.Game){
		hud.tick();
		spawn.tick();
		}
		else if(gameState == STATE.Menu){
			menu.tick();
		}
	}
	
	//Renders the background images and creates a buffer
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);

		if(gameState == STATE.Game){
			hud.render(g);
		}
		else if(gameState == STATE.Menu){
			menu.render(g);
		}
		else{
			g.setColor(Color.white);
			g.drawString("Menu", 100, 100);
		}
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max){
		if(var >= max)
			return var = max;
		else if(var <=min)
			return var = min;
		else
			return var;
	}
	
		
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
