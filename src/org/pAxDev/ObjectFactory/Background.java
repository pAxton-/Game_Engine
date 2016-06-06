package org.pAxDev.ObjectFactory;

/**
 * Created by Lance on 4/17/2016.
 */
public class Background extends BaseEntity {

    public Background(float... posXYZWHA) {
        setX(posXYZWHA[0]);
        setY(posXYZWHA[1]);
        setZ(posXYZWHA[2]);
        setWidth(posXYZWHA[3]);
        setHeight(posXYZWHA[4]);
        setAlpha(posXYZWHA[5]);
        setType(EntityType.BACKGROUND);
    }
}
