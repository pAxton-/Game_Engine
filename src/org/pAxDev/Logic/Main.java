package org.pAxDev.Logic;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import org.pAxDev.ObjectFactory.*;

import org.pAxDev.Util.AssetLoader;
import org.pAxDev.Util.Options;
import org.pAxDev.Util.Screen;


public class Main {
	

	static Main main;
	 String TITLE = "TITLE";
	 String VERSION = "0.0.1 pre-alpha";
	
	
	Options options = Options.getIntance();
    Screen screen;
	Camera cam1;

	
	private long lastFrame;
    private AssetLoader aLoader;
    private boolean isAssetsReady = false;
    GameMode gm = new GameMode();

    Player player = new Player();
	private int fps;
    private long lastFPS;


    private Main() {}

	public void updateOptions(){
		
		options.readFile("options.cfg");
		
	}
	
	public void init(){
		screen = Screen.getInstance().init(options.screenWidth, options.screenHeight, options.frameCap, options.fullscreen, options.vSync, TITLE+" - "+VERSION);
		cam1 = new Camera(new Vector2f(0,0), new Vector2f(options.screenWidth, options.screenHeight));
        loadGameAssets();

        player.init();
        gm.init(player);

	}

    public void loadGameAssets() {
        aLoader = AssetLoader.getInstance();
        isAssetsReady = true;
    }
	
	public void mainLoop(){
        float currentTime = getTime();
        lastFPS = getTime();
        int frameCount = 0;
		while(!screen.isCloseRequested()){
			int delta = getDelta();
			cam1.update();
            if(!isAssetsReady) {
               // loadGameAssets();
            }
/*

            if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
                if(getTime() > currentTime +100) {
                    if (player.getType().getTexX() > .50f) {
                        player.getType().setTexX(0);
                    }
                    player.getType().setTexX(player.getType().getTexX() + 0.25f);

                    currentTime = getTime();
                }
            } else {
                player.getType().setTexX(0);
            }
            */
			gm.update(delta);
            player.render();



			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				break;
			}
            updateFPS();
            screen.update();
            frameCount++;

		}
	}
	
	public void close(){
		screen.destroy();
	}
	
	public static void main(String[] args) {
		main = new Main();
		
		main.updateOptions();
		main.init();
		main.mainLoop();
		main.close();
	}
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
		}
	public void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            screen.setTitle("FPS: " + fps);
            fps = 0; //reset the FPS counter
            lastFPS += 1000; //add one second
        }
        fps++;
    }
		 
	
		public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
		}

}
