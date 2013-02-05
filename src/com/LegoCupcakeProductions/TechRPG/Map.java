package com.LegoCupcakeProductions.TechRPG;

import com.LegoCupcakeProductions.RPGCupcake.Level;
import com.LegoCupcakeProductions.RPGCupcake.TileRect;
import com.LegoCupcakeProductions.RPGCupcake.MapWarp;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	 public Level Map1;
	 public MapWarp Map1_Warp1;
	 public Level Map2;
	 public int currentMap;
//	 public Graphics Sprite;
	
	public Map() {
		Map1 = new Level(null, null, null, null, null, null, null, null, 0, "data/Village1.png");
//		Map1_Warp1 = new MapWarp(1, 0, 0, 32, 32);
		Map2 = new Level(null, null, null, null, null, null, null, null, 1, "data/PersonHouse.png");
		currentMap = 0;
//		Sprite = new Graphics();
	}
	
	public boolean Collide(int s1x, int s2x, int s1y, int s2y) {
		if (s1x > s2x - 32 && s1x < s2x + 32 && s1y > s2y - 32 && s1y < s2y + 32) {
			return true;
		} else {
			return false;
		}
	}
	
	public void draw(SpriteBatch batch) {
		if (currentMap == 0) {
			batch.draw(Map1.Map, 0, 0);
		}
		if (currentMap == 1) {
			batch.draw(Map2.Map, 0, 0);
		}
	}
	
	public void update(int x, int y) {
		if (currentMap == 0) {
			if (Collide(x, 0, y, 0)) {
				currentMap = 1;
			}
		} else if (currentMap == 1) {
			if (Collide(x, 736, y, 384)) {
				currentMap = 0;
//				Sprite.move_player(100, 100);
			}
		}
	}
}
