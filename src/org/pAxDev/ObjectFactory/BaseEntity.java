package org.pAxDev.ObjectFactory;

import org.pAxDev.Logic.DynamicCollider;
import org.pAxDev.Logic.PhysicsComponent;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 4/16/2016.
 */
public abstract class BaseEntity {
    //float value for position
    private float x, y, z;
    //float values for scale
    private float width, height;

    private PhysicsComponent physics;



   /* float value for opaque Rest of rgb in hard coded for 1
    * this may need changing in the future
    */
    private float alpha;
    //type is enum that holds the texture
    private EntityType type;

    public void render() {

        glPushMatrix();

        glTranslatef(getX(), getY(), getZ());
        if(getX() > -100 && getX() < 1400)
        glRotatef(0, 0, 0, 1);
        glScalef(width, height, 0);
        glColor4f(1, 1, 1, getAlpha());
       // glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_S,GL_CLAMP);
      //  glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_T,GL_CLAMP);
        type.getTexture().bind();

        glBegin(GL_QUADS);
        glTexCoord2f(type.getTexX(), type.getTexY());
        glVertex3f(-0.5f, 0.5f, 0);// -5 -5
        glTexCoord2f(type.getTexX(), type.getYheight());
        glVertex3f(-0.5f, -0.5f, 0); /// -5 5
        glTexCoord2f(type.getXwidth(), type.getYheight());
        glVertex3f(0.5f, -0.5f, 0); // 5 5
        glTexCoord2f(type.getXwidth(), type.getTexY());
        glVertex3f(0.5f, 0.5f, 0); // 5 -5
        glEnd();


        glPopMatrix();
    }

    public void renderFull() {
        glPushMatrix();

        glTranslatef(getX(), getY(), getZ());

        glRotatef(0, 0, 0, 1);
        glScalef(width, height, 0);
        glColor4f(1, 1, 1, getAlpha());
        //glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_S,GL_CLAMP);
        //glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_T,GL_CLAMP);
        type.getTexture().bind();

        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex3f(-0.5f, 0.5f, 0);// -5 -5
        glTexCoord2f(0, 1);
        glVertex3f(-0.5f, -0.5f, 0); /// -5 5
        glTexCoord2f(1.8f, 1);
        glVertex3f(0.5f, -0.5f, 0); // 5 5
        glTexCoord2f(1.8f, 0);
        glVertex3f(0.5f, 0.5f, 0); // 5 -5
        glEnd();


        glPopMatrix();
    }
    public PhysicsComponent getPhysics() {
        return physics;
    }

    public void initPhysics(DynamicCollider collider) {
        physics = new PhysicsComponent(collider);
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }
}
