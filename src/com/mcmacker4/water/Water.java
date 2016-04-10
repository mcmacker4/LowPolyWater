package com.mcmacker4.water;

import static org.lwjgl.opengl.GL11.*;

public class Water implements Runnable {
	
	@Override
	public void run() {
		Display.create(1280, 720, "Low Poly Water");
		while(!Display.shouldClose()) {
			glClear(GL_COLOR_BUFFER_BIT);
			Display.update();
		}
		Display.destroy();
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Water());
		thread.setName("Water");
		thread.start();
	}

}
