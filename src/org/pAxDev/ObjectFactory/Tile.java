package org.pAxDev.ObjectFactory;

import org.pAxDev.Util.Logger;

/**
 * Created by Lance on 4/16/2016.
 */
public abstract class Tile extends StaticEntity {

    //this constructor expects position XYZ width height and alpha
    public Tile(float...posXYZWHA) {

        //crazy way to init fields
        //so lets log error just in case
        Logger.getInstance().printTileInitResult(posXYZWHA, this);
        setX(posXYZWHA[0]);
        setY(posXYZWHA[1]);
        setZ(posXYZWHA[2]);
        setWidth(posXYZWHA[3]);
        setHeight(posXYZWHA[4]);
        setAlpha(posXYZWHA[5]);
    }

}
