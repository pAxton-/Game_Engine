package org.pAxDev.Logic;

import org.pAxDev.ObjectFactory.*;

import java.util.ArrayList;

/**
 * Created by Lance on 4/17/2016.
 */
public class PhysicsEngine {
    private static PhysicsEngine ourInstance = new PhysicsEngine();
    private BaseEntity player;
    private boolean onGround = false;
    private float accel = 2;
    private  float gravAccl = 0;
    private ArrayList<StaticEntity> staticEntities;


    public static PhysicsEngine getInstance() {
        return ourInstance;
    }

    private PhysicsEngine() {
    }

    public void update(int delta) {

        player.getPhysics().update(delta);

        for(StaticEntity se : staticEntities) {
            staticForce(se.getFriction(),1,se,delta);
        }


    }

    public void setPlayer(BaseEntity player) {
        this.player = player;
    }

    public void setStaticEntities(ArrayList<StaticEntity> entities) {
        this.staticEntities = entities;
    }

    public ArrayList<StaticEntity> getStaticEntities() {
        return staticEntities;
    }

    public void addForce(float x, float y, BaseEntity player, int delta) {
    //    player.setY(player.getY()  +y + accel *delta);
     //   player.setY(player.getY() + (float)Math.sin(accel) * 2 * y * delta);
     //   accel -= accel + 10f;
      //  player.setX(player.getX() * 0.9f +x*delta);

    }

    public void staticForce(float x, float y, StaticEntity e, int delta) {
        e.setX(e.getX() + x * delta);

    }

    public boolean isOnGround() {
        accel = 1;
        return onGround;
    }

    public BaseEntity getPlayer() {
        return player;
    }

}
