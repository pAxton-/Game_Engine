package org.pAxDev.ObjectFactory;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import static org.lwjgl.opengl.GL11.*;


public class Camera {
	Vector2f position;
	Vector2f scale;
	
	public Camera(Vector2f position, Vector2f scale){
		this.position = position;
		this.scale = scale;
		create();
	}
	
	public void create(){
	glMatrixMode(GL_PROJECTION);
				glLoadIdentity();
		glOrtho(0, 1366,0, 768, -5, 5);
		glMatrixMode(GL_MODELVIEW);
		glViewport((int)-position.x, (int)-position.y, (int)scale.x, (int)scale.y);
		
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glClearColor(0.2f,0.2f,0.6f,1);
	}
	
	public void update(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		glViewport((int)-position.x, (int)-position.y, (int)scale.x, (int)scale.y);
		glLoadIdentity();
	}
	
}
