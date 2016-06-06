package org.pAxDev.ObjectFactory;

/**
 * Created by Lance on 4/17/2016.
 */
public abstract class StaticEntity extends BaseEntity {

    private float friction = 0;

    public float getFriction() {
        return friction;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }
}
