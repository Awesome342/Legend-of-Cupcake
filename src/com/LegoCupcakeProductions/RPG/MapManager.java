package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapManager {
	public Map Map1;
	public Map Map2;
	public Map Map3;
	public Map Map4;
	public int currentMap;
	public Rect Map1_Warp1;
	public Rect Map1_Warp2;
	public Rect Map2_Warp1;
	public Rect Map3_Warp1;
	
	public MapManager() {
		Map1_Warp1 = new Rect(246, 232, 32, 32);
		Map1_Warp2 = new Rect(-32, 480, 32, 512);
		Map2_Warp1 = new Rect(736, 384, 32, 32);
		Map3_Warp1 = new Rect(384, 128, 32, 32);
		Map1 = new Map("data/Village1.png", null, null, null, null, Map1_Warp1, Map1_Warp2, null, null);
		Map2 = new Map("data/PersonHouse.png", null, null, null, null, Map2_Warp1, null, null, null);
		Map3 = new Map("data/Village2.png", null, null, null, null, Map3_Warp1, null, null, null);
		Map4 = new Map("data/Temple1.png", null, null, null, null, null, null, null, null);
		currentMap = 0;
	}
	
	public boolean Collide(int s1x, int s2x, int s1y, int s2y) {
		if (s1x > s2x - 32 && s1x < s2x + 32 && s1y > s2y - 32 && s1y < s2y + 32) {
			return true;
		} else {
			return false;
		}
	}

	public void updateMaps(int x, int y) {

	}

	public void draw(SpriteBatch Screen, Rect Player) {
		//updating currentMap
		if (currentMap == 0) {
			if (Map1.updateWarp1(Player)) {
				currentMap = 1;
			}
			if (Map1.updateWarp2(Player)) {
				currentMap = 2;
			}
		}
		if (currentMap == 1) {
			if (Map2.updateWarp1(Player)) {
				currentMap = 0;
			}
		}
		if (currentMap == 2) {
			if (Map3.updateWarp1(Player)) {
				currentMap = 3;
			}
		}
		
		if (currentMap == 0) {
			Screen.draw(Map1.Img, 0, 0);
		} else if (currentMap == 1) {
			Screen.draw(Map2.Img, 0, 0);
		} else if (currentMap == 2) {
			Screen.draw(Map3.Img, 0, 0);
		} else if (currentMap == 3) {
			Screen.draw(Map4.Img, 0, 0);
		}
	}

}
