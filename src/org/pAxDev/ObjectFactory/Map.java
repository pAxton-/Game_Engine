package org.pAxDev.ObjectFactory;

import org.pAxDev.Logic.GraphicsEngine;

import java.util.ArrayList;

/**
 * Created by Lance on 4/17/2016.
 */
public class Map {

    private static Map map = new Map();
    private SmoothBrick[] ground = new SmoothBrick[4000];
    private CobbleBrick[] smallRow = new CobbleBrick[300];
    private Background background;
    private ArrayList<StaticEntity> entities = new ArrayList<>();


    private Map(){}

    public static Map getInstance() {
        return map;
    }

    public void init() {
        for(int i = 0, xSpacing = 70; i < ground.length; i++, xSpacing += 70) {
            ground[i] = new SmoothBrick(xSpacing,70,.1f,70,70,1);
            entities.add(ground[i]);
            GraphicsEngine.getInstance().addEntity(ground[i]);

        }
        for(int i = 0, xSpacing = 1100; i < smallRow.length; i++, xSpacing += 300) {
            smallRow[i] = new CobbleBrick(xSpacing, 260,.1f,70,70,1);
            entities.add(smallRow[i]);
            GraphicsEngine.getInstance().addEntity(smallRow[i]);
        }
        background = new Background(1000,140,0,1000,1200,1);
        background.getType().setTexX(0);

    }

    public void render() {
     //   background.renderFull();
        GraphicsEngine.getInstance().render();
    }

    public ArrayList<StaticEntity> getEntities() {
           return entities;
    }



}
