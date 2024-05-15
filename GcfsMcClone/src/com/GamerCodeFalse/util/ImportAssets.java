package com.GamerCodeFalse.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.GamerCodeFalse.main.Game;

public class ImportAssets {
	public static JSONObject ImportJSONFile(String path) throws FileNotFoundException, IOException, ParseException {
		 return (JSONObject) (new JSONParser().parse(new FileReader(path)));
	}
	
	public static JSONObject TryImportJSONFile(String path){
		 try {
			return (JSONObject) (new JSONParser().parse(new FileReader(path)));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage ImportSprite(String path) throws IOException {
		return ImageIO.read(new File(path));
	}
	
	public static BufferedImage TryImportSprite(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage[][] ImportSpriteSpriteSheet(String path, int width_,int height_) throws IOException {
		BufferedImage[][] temp = new BufferedImage[height_][width_];
		for(int i = 0;i<width_;i++) {
			for(int j = 0;j<height_;j++) {
				 temp[i][j] = ImageIO.read(new File(path)).getSubimage(i*Game.TILE_SIZE, j*Game.TILE_SIZE, Game.TILE_SIZE, Game.TILE_SIZE);
			}
		}
		return temp;
	}
	
	public static BufferedImage[][] TryImportSpriteSpriteSheet(String path, int width_,int height_) {
		BufferedImage[][] temp = new BufferedImage[width_][height_];
		for (int j = 0; j < temp.length; j++) {
			for (int i = 0; i < temp[j].length; i++) {
				 try {
					temp[j][i] = ImageIO.read(new File("./assets/env/biomes/sprites/tilemap.png")).getSubimage(j*Game.TILE_SIZE,i*Game.TILE_SIZE, Game.TILE_SIZE, Game.TILE_SIZE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return temp;
	}
}
