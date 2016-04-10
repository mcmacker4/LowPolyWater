package com.mcmacker4.water;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Display {
	
	private static long window;
	
	public static void create(int width, int height, String title) {
		
		if(glfwInit() != GL_TRUE)
			throw new IllegalStateException("Could not initialize GLFW.");
		
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		
		window = glfwCreateWindow(width, height, title, NULL, NULL);
		
		if(window == NULL)
			throw new IllegalStateException("Could not create GLFW window.");
		
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(
				window,
				(vidmode.width() - width) / 2,
				(vidmode.height() - height) / 2
		);
		
		glfwShowWindow(window);
		
		glfwMakeContextCurrent(window);
		
		GL.createCapabilities();
		
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		
	}
	
	public static void update() {
		glfwSwapBuffers(window);
		glfwPollEvents();
	}
	
	public static boolean shouldClose() {
		return glfwWindowShouldClose(window) == GL_TRUE;
	}
	
	public static void destroy() {
		glfwDestroyWindow(window);
	}

}
