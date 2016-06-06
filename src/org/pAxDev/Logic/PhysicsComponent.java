package org.pAxDev.Logic;

/**
 * Created by Lance on 4/21/2016.
 */
public class PhysicsComponent {
    DynamicCollider collider;
    float currentX = 599;
    float currentY = 599;
    float newX;
    float newY;
    float friction = 0.95f;
    float gravity = -0.787f;

    public PhysicsComponent(DynamicCollider collider) {
        this.collider = collider;
    }

    public void update(int delta) {
        newX = collider.getX();
        newY = collider.getY();
        System.out.println(newY);
        collider.setX(collider.getX() + getX_Velocity(delta));
        collider.setY(collider.getY() + getY_Velocity(delta));
        currentX = newX;
        currentY = newY;
    }

    private float getX_Velocity(int delta) {
        return ((newX - currentX) * getFriction() );
    }

    private float getY_Velocity(int delta) {
        return ((newY - currentY) + getGravity() * getFriction());
    }

    public float getFriction() {
        return friction;
    }

    public float getGravity() {
        return gravity;
    }
}
