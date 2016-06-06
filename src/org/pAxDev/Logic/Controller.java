package org.pAxDev.Logic;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.pAxDev.ObjectFactory.Map;
import org.pAxDev.ObjectFactory.Player;
import org.pAxDev.ObjectFactory.StaticEntity;

import java.util.ArrayList;

/**
 * Created by Lance on 4/17/2016.
 */
public class Controller {
    private static Controller ourInstance = new Controller();
    private ArrayList<StaticEntity> entities;
    private Collision collision;
    private Player player;
    private boolean isJumping = false;
    private long timeJumpStarted;
    float speed = 0f;

    public static Controller getInstance() {
        return ourInstance;
    }

    private Controller() {}

    public void init(Player player) {
        entities = Map.getInstance().getEntities();
        this.player = player;
        PhysicsEngine.getInstance().setStaticEntities(entities);
        PhysicsEngine.getInstance().setPlayer(player);
        collision = new Collision(player);
    }
    public void update(int delta) {
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
           // player.getPhysics().currentX = 0;
           for(StaticEntity se : entities) {
               //se.setX(se.getX() - 0.13f* delta);
               speed = -0.3f;
               se.setFriction(speed);
           }
        } else {
            for(StaticEntity se : entities) {
                //se.setX(se.getX() - 0.13f* delta);
                if (speed < 0 ){//&& PhysicsEngine.getInstance().isOnGround()) {
                    speed += 0.000001f/2;
                }
                if (speed > 0f) {
                    speed = 0;
                }
                se.setFriction(speed);
            }

        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE ) && PhysicsEngine.getInstance().isOnGround() && !isJumping) {
            isJumping = true;
            timeJumpStarted = getTime();
        }
        if(isJumping) {
            jump(delta);
            System.out.println("GetTime " + getTime() + " ..timejumpstart " + timeJumpStarted);
        }
        if(isJumping && getTime() > timeJumpStarted + 300 ) {
            speed -= 0.000001f/2;
            isJumping = false;
        }
        PhysicsEngine.getInstance().update(delta);

    }

    private void jump(int delta) {
        PhysicsEngine.getInstance().addForce(1f,2f,player, delta);
    }
    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
}
