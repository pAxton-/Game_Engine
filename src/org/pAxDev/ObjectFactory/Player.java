package org.pAxDev.ObjectFactory;

import org.pAxDev.Logic.DynamicEntity;
import org.pAxDev.Logic.PhysicsComponent;

/**
 * Created by Lance on 4/17/2016.
 */
public class Player extends DynamicEntity {


    public void init() {
        setX(600);
        setY(600);
        setZ(0.2f);
        setWidth(90);
        setHeight(90);
        setAlpha(1);
        setType(EntityType.PLAYER);
        EntityType.PLAYER.setHeight(.125f);
        EntityType.PLAYER.setWidth(.25f);
        initPhysics(this);
    }


}
