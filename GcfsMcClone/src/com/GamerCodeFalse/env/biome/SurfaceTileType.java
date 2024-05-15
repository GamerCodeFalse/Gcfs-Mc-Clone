package com.GamerCodeFalse.env.biome;

public enum SurfaceTileType {
	LEFT_EDGE(0),
	CENTER(1),
	RIGHT_EDGE(2);
	
	public int id;
	
	SurfaceTileType(int id) {
		this.id =id;
	}
	
    public static SurfaceTileType fromId(int id) {
        for (SurfaceTileType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
}

