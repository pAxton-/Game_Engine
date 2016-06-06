package org.pAxDev.Logic;

import org.pAxDev.ObjectFactory.BaseEntity;

import java.util.ArrayList;

/**
 * Created by Lance on 4/19/2016.
 */
public class GraphicsEngine {
    private ArrayList<BaseEntity> entities = new ArrayList<>();

    private static GraphicsEngine instance = new GraphicsEngine();

    private GraphicsEngine(){}

    public static GraphicsEngine getInstance() {
        return instance;
    }

    public void addEntity(BaseEntity entity) {
        entities.add(entity);
    }

    public void removeEntity(BaseEntity entity) {
        entities.remove(entity);
    }

    private boolean isReadytoRender(BaseEntity entity) {
        if (entity.getY() > 0 && entity.getY() < 768 && entity.getX() > -100 && entity.getX() < 1466) {
            return true;
        } else {return false;}
    }

    public void render() {
        for(BaseEntity entity : entities) {
            if(isReadytoRender(entity)) {
                entity.render();
            }

        }
    }


}
