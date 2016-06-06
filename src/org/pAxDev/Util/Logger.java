package org.pAxDev.Util;

import org.pAxDev.ObjectFactory.Tile;

import java.time.Instant;
import java.util.Date;

/**
 * Created by Lance on 4/16/2016.
 */
public class Logger {

    private static Logger logger = new Logger();

    private Logger() {}

    public static Logger getInstance() {
        return logger;
    }


    public void printTileSetFailure() {
        printTimeStamp();
        System.out.print(" ::ERROR:: TileSet was not initialized-->");
        System.out.println("::END ERROR::");
    }

    private void printTimeStamp() {
        System.out.print(Date.from(Instant.now()));
    }

    public void printTileInitResult(float[] params, Tile tile) {
        if(params.length < 6) {
            printTimeStamp();
            System.out.print(" ::ERROR:: Couldn't create tile " + tile.toString());
            System.out.print(" required params Type,posX,posY,posZ,width,height,alpha" );
            System.out.println("::END ERROR::");
        } else {
            System.out.println("::SUCCESS:: Tile created->" + tile.toString());
        }
    }

    public void printPlayerSpriteFailure() {
        printTimeStamp();
        System.out.print(" ::ERROR:: Player Sprite sheet was not initialized-->");
        System.out.println("::END ERROR::");
    }
}
