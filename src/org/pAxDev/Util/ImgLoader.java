package org.pAxDev.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class ImgLoader {
    private static ImgLoader imgLoader = new ImgLoader();


	private ImgLoader() {}

    public static ImgLoader getInstance() {
        return imgLoader;

    }

	public Texture loadTexture(String filename, String format){
		format = format.toUpperCase();
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture(format, new FileInputStream(new File(filename)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Could not find file: "+filename);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not read file: "+ filename);
		}

		System.out.println("Loaded texture: "+filename);
		System.out.println("	width: "+texture.getImageWidth());
		System.out.println("	height: "+texture.getImageHeight());
		System.out.println();

		return texture;
	}
	
}	
