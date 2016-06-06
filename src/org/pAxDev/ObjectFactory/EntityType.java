package org.pAxDev.ObjectFactory;

import org.newdawn.slick.opengl.Texture;
import org.pAxDev.Util.AssetLoader;

/**
 * Created by Lance on 4/16/2016.
 */
public enum EntityType {

    BRICK_1(AssetLoader.getInstance().getTileSet(), .245f/2,.3734f),
    BRICK_2(AssetLoader.getInstance().getTileSet(),0,.3754f),
    PLAYER(AssetLoader.getInstance().getPlayerSet(), .25f,0.239f),
    BACKGROUND(AssetLoader.getInstance().getBackground(),0,0);

    private Texture texture;
    private float texX;
    private float texY;
    private float width = 0.25f/2;
    private float height = 0.123f/2;
    EntityType(Texture tex, float x, float y) {
           this.texture = tex;
           this.texX = x;
           this.texY = y;
           this.width = width;
           this.height = height;

    }

    public Texture getTexture() {
        return texture;
    }
    public float getTexX() {
        return texX;
    }
    public float getTexY() {
        return texY;
    }
    public float getXwidth() {
        return width + texX;
    }
    public float getYheight() {
        return height + texY;
    }
    public void setTexX(float x) {
        this.texX = x;
    }
    public void setWidth(float x) { width = x;}
    public void setHeight(float y) { height = y;}
}
