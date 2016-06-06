package org.pAxDev.Logic;

import org.pAxDev.ObjectFactory.StaticEntity;

import java.util.ArrayList;

/**
 * Created by Lance on 4/20/2016.
 */
public class Collision {
    private DynamicCollider entity;
    private ArrayList<StaticEntity> worldEntities;

    public Collision(DynamicCollider entity) {
        this.entity = entity;
        this.worldEntities = PhysicsEngine.getInstance().getStaticEntities();
    }

    public void update() {

    }

    public boolean isColliding() {
        for(StaticEntity se : worldEntities) {
            if(inRange(entity.getX(), se.getX() - se.getWidth(), se.getX() + se.getWidth()) &&
                    (inRange(entity.getY(), se.getY() - se.getHeight(), se.getY() + se.getHeight()))){
                return true;
            }
        }
        return false;
    }

    private boolean inRange(float value, float min, float max) {
        return value >= min && value <= max;
    }

}
