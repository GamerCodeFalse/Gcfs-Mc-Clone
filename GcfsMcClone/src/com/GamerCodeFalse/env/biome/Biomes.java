package com.GamerCodeFalse.env.biome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

import org.json.simple.parser.ParseException;

public class Biomes {
	public final HashMap<String, Biome> BIOMES = new HashMap<String, Biome>();
	private static String path = "./assets/env/biomes/info/";
	
	public Biomes() {
	    try (Stream<Path> paths = Files.walk(Paths.get(path))) {
	        paths.forEach((p) -> {
	        	if(p.toString().contains(".json")) {
	        		try {
						BIOMES.put(p.toString().split("/")[p.toString().split("/").length-1].split(".json")[0], new Biome(p));
					} catch (IOException | ParseException e) {
						e.printStackTrace();
					}
	        	}
	        });
	
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    
	    
	}
}
