package com.CountedReturns.Game;

import java.awt.Canvas;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	//VARIABLES BELOW
	private boolean running = false;
	
	private int WIDTH = 640;
	private int HEIGHT = 480;
	
	private int fps = 0;
	private int ups = 0;
	
	//END OF VARIABLES
		

	public static void main(String[] args) {
		
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 20.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				fps = frames;
				ups = updates;
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void render() {
		
	}
	
	private void tick() {
		System.out.println("FPS:" + fps);
		System.out.println("Ticks: " + ups);
		System.out.println("Width: " + WIDTH);
		System.out.println("Height: " + HEIGHT);
	}
	
}