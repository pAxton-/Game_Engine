package org.pAxDev.ObjectFactory;

/**
 * Created by Lance on 4/16/2016.
 */
public class CobbleBrick extends Tile {
    public CobbleBrick(float... posXYZWHA) {
        super(posXYZWHA);
        setType(EntityType.BRICK_2);
    }
}
