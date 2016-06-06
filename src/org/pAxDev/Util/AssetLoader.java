package org.pAxDev.Util;
import org.newdawn.slick.opengl.Texture;

/**
 * Created by Lance on 4/16/2016.
 */
public class AssetLoader {

    private static AssetLoader assetLoader = new AssetLoader();
    private static Texture rawTextureImg;
    private static Texture playerSpriteImg;
    private static Texture background;

    private AssetLoader() {}

    static {
        loadTileMap();
        loadPlayerSprite();
        loadBackGround();
    }

    public static AssetLoader getInstance() {
        if (assetLoader == null) {
            assetLoader = new AssetLoader();
        }
        return assetLoader;
    }

    public Texture getTileSet() {
        if(rawTextureImg == null) {
             loadTileMap();
        } else if (rawTextureImg != null) {
            return rawTextureImg;
        }
        Logger.getInstance().printTileSetFailure();
        return null;
    }
    public Texture getPlayerSet() {
        if(playerSpriteImg == null) {
            loadPlayerSprite();
        } else if (playerSpriteImg != null) {
            return playerSpriteImg;
        }
        Logger.getInstance().printPlayerSpriteFailure();
        return null;
    }

    private static void loadTileMap() {
        rawTextureImg = ImgLoader.getInstance().loadTexture("res/tileset.png", "PNG");
    }
    private static void loadPlayerSprite() {
        playerSpriteImg = ImgLoader.getInstance().loadTexture("res/sprite.png", "PNG");
    }
    private static void loadBackGround() {
        background = ImgLoader.getInstance().loadTexture("res/background.png", "PNG");
    }

    public Texture getBackground() {
        return background;
    }
}
