package com.GamerCodeFalse.env.biome;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.GamerCodeFalse.main.Game;
import com.GamerCodeFalse.util.ImportAssets;



public class Biome {
	public int surfaceMinY, surfaceMaxY, minWidth, maxWidth, generationDepth;
	public TreeType treeType;
	
	public ArrayList<BufferedImage> surfaceSprites = new ArrayList<BufferedImage>();
	
	
	@SuppressWarnings("unchecked")
	public Biome(Path path) throws FileNotFoundException, IOException, ParseException {
		JSONObject obj = ImportAssets.ImportJSONFile(path.toString());
		
		surfaceMinY = (int) Long.parseLong((String) obj.get("surfaceMinY"));
		surfaceMaxY = (int) Long.parseLong((String) obj.get("surfaceMaxY"));
		
		minWidth = (int) Long.parseLong((String) obj.get("minWidth"));
		maxWidth = (int) Long.parseLong((String) obj.get("maxWidth"));
		
		generationDepth = (int) Long.parseLong((String) obj.get("generationDepth"));
		treeType = TreeType.fromId((int) Long.parseLong((String) obj.get("treeType")));
		
		((JSONArray) obj.get("surfaceTiles")).forEach((t) -> {
			JSONArray coordinatesArray = (JSONArray) t;
			surfaceSprites.add(Game.GAME_SPRITES[(int) coordinatesArray.get(0)][(int) coordinatesArray.get(1)]);
		});
	}
}
