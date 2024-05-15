package com.GamerCodeFalse.env.biome;

public enum TreeType {
	TREE(0),
	MUSHROOM(1);

	public int id;
	
	TreeType(int id) {
		this.id =id;
	}
	
    public static TreeType fromId(int id) {
        for (TreeType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }
}
