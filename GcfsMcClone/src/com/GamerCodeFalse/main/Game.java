package com.GamerCodeFalse.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.GamerCodeFalse.env.biome.Biome;
import com.GamerCodeFalse.env.biome.Biomes;
import com.GamerCodeFalse.env.biome.SurfaceTileType;
import com.GamerCodeFalse.util.ImportAssets;

public class Game implements Runnable{
	public static final int TILE_SIZE = 18;
	
	public static final int WIDTH_IN_TILES = 30*TILE_SIZE;
	public static final int HEIGHT_IN_TILES = 20*TILE_SIZE;
	
	public static final float SCALE = 1.25f;
	
	public static final int WINDOW_WIDTH =  (int) (WIDTH_IN_TILES*SCALE);
	public static final int WINDOW_HEIGHT =  (int) (HEIGHT_IN_TILES*SCALE);
	
	public static final int FPS_LIMIT = 120;
	public static final int UPS_LIMIT = 200;
	
	public static Panel panel;
	public static Window window;
	
	private final Thread appThread = new Thread(this);
	
	public static HashMap<String, Biome> BIOMES;
	public static BufferedImage[][] GAME_SPRITES;
	
	public static final int SURFACE_LEVEL = 0;
	
	public Game() {
		panel = new Panel();
		window = new Window(panel);
		
		BIOMES = new Biomes().BIOMES;
		GAME_SPRITES = ImportAssets.TryImportSpriteSpriteSheet("./assets/env/biomes/sprites/tilemap.png", 20, 9);
		
		appThread.start();
	}
	
	public void update() {}
	public void render(Graphics g) {
		g.drawImage(BIOMES.get("snowy").surfaceSprites.get(SurfaceTileType.CENTER.id), 0, 0, (int)(BIOMES.get("plains").surfaceSprites.get(SurfaceTileType.CENTER.id).getWidth()*SCALE),(int)(BIOMES.get("plains").surfaceSprites.get(SurfaceTileType.CENTER.id).getHeight()*SCALE), null);
	}
	
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_LIMIT;
		double timePerUpdate = 1000000000.0 / UPS_LIMIT;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				render(panel.getGraphics());
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;

			}
		}
	}

}
