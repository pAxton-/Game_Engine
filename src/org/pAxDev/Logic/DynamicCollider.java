package org.pAxDev.Logic;

/**
 * Created by Lance on 4/20/2016.
 */
public interface DynamicCollider {

    boolean isColliding();

    boolean startCollision();

    boolean endCollision();

    void setX(float x);

    void setY(float y);

    float getX();

    float getY();

    float setSpeed();

    float setFriction();

    float setMass();
}
