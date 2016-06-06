package org.pAxDev.Logic;

import org.pAxDev.ObjectFactory.BaseEntity;

/**
 * Created by Lance on 4/20/2016.
 */
public class DynamicEntity extends BaseEntity implements DynamicCollider {


    @Override
    public boolean isColliding() {
        return false;
    }

    @Override
    public boolean startCollision() {
        return false;
    }

    @Override
    public boolean endCollision() {
        return false;
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public float setSpeed() {
        return 0;
    }

    @Override
    public float setFriction() {
        return 0;
    }

    @Override
    public float setMass() {
        return 0;
    }
}
