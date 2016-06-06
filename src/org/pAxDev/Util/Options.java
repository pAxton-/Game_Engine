package org.pAxDev.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Options {
	
	public int screenWidth;
	public int screenHeight;
	public int frameCap;
	public boolean fullscreen, vSync;

    private static Options opts = new Options();

	private Options() {}

	public static Options getIntance() {
        if(opts == null) {
            opts = new Options();
        }
        return opts;
    }
	public void readFile(String filename){
		File file;
		BufferedReader reader = null;
		String line;
		
		try {
			file = new File(filename);
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("COULD NOT FIND FILE: "+filename);
		}
		
		try {
			while( (line = reader.readLine()) != null){
				if(line.startsWith("screenWidth ")){
					screenWidth = Integer.valueOf(line.split(" ")[1]);
				}
				else if(line.startsWith("screenHeight ")){
					screenHeight = Integer.valueOf(line.split(" ")[1]);
				}
				else if(line.startsWith("frameCap ")){
					frameCap = Integer.valueOf(line.split(" ")[1]);
				}
				else if(line.startsWith("fullscreen ")){
					fullscreen = Boolean.valueOf(line.split(" ")[1]);
				}
				else if(line.startsWith("vSync ")){
					vSync = Boolean.valueOf(line.split(" ")[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("COULD NOT READ FILE: "+filename);
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("COULD NOT CLOSE READER!");
		}
		System.out.println(filename+" read successfully:");
		System.out.println("	screenWidth:"+screenWidth);
		System.out.println("	screenHeight:"+screenHeight);
		System.out.println("	fullscreen:"+fullscreen);
		System.out.println("	vSync:"+vSync);
		System.out.println("	frameCap:"+frameCap);
		System.out.println();
	}
	
}
