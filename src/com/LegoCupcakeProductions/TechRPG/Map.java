package com.LegoCupcakeProductions.TechRPG;

import com.LegoCupcakeProductions.RPGCupcake.Level;
import com.LegoCupcakeProductions.RPGCupcake.NPC;
import com.LegoCupcakeProductions.RPGCupcake.TileRect;
import com.LegoCupcakeProductions.RPGCupcake.MapWarp;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	//Map Stufff
	 public Level Map1;
	 public Level Map2;
	 public Level Map3;
	 public Level Map4;
	 public int currentMap;
	 public Texture Blackness;
	 //NPC's ***NEEDS TO BE MOVED TO A DYNAMICLY SCRIPTED SYSTEM***
	 public NPC Coa;
	 public NPC Player;
	 public Battle Fight;
	 public Player Knight;
	 public int newX;
	 public int newY;
	
	public Map() {
		Map1 = new Level(null, null, null, null, null, null, null, null, 0, "data/Village1.png");
		Map2 = new Level(null, null, null, null, null, null, null, null, 1, "data/PersonHouse.png");
		Map3 = new Level(null, null, null, null, null, null, null, null, 2, "data/Village2.png");
		Map4 = new Level(null, null, null, null, null, null, null, null, 3, "data/Temple1.png");
		Blackness = new Texture("data/Blackness.png");
		currentMap = 1;
		
		Coa = new NPC(800, 400, "data/Coa2.png", 0, 0, 22, 32);
		Player = new NPC(20, 200, "data/BoyKnight_Moosader.png", 0, 0, 32, 32);
		Fight = new Battle();
		Knight = new Player();
	}
	
	public boolean Collide(int s1x, int s2x, int s1y, int s2y) {
		if (s1x > s2x - 32 && s1x < s2x + 32 && s1y > s2y - 32 && s1y < s2y + 32) {
			return true;
		} else {
			return false;
		}
	}
	
	public void draw(SpriteBatch batch) {
		if (Fight.IsBattle == false) {
			if (currentMap == 1) {
				batch.draw(Map1.Map, 0, 0);
			}
			if (currentMap == 2) {
				batch.draw(Map2.Map, 0, 0);
			}
			if (currentMap == 3) {
				batch.draw(Map3.Map, 0, 0);
			}
			if (currentMap == 4) {
				batch.draw(Map4.Map, 0, 0);
				batch.draw(Coa.NPCImgClip, Coa.x, Coa.y);
			}
		} else if (Fight.IsBattle == true) {
			batch.draw(Blackness, 0, 0);
			Fight.StartBattle(Knight.PlayerNPC, Coa);
		}
	}
	
	public void update(int x, int y) {
		if (currentMap == 1) {
			if (Collide(x, 0, y, 0)) {
				currentMap = 2;
			} else if (x < 0) {
				currentMap = 3;
			} 
		} else if (currentMap == 2) {
			if (Collide(x, 736, y, 384)) {
				currentMap = 1;
			} 
		} else if (currentMap == 3) {
			if (Collide(x, 352, y, 160)) {
				currentMap = 4;
			}
		}
	
		//Battle updates
		if (Collide(x, Coa.x, y, Coa.y)) {
			Fight.IsBattle = true;
		}
		
		newX = x;
		newY = y;
		Knight.updatePOS();
	}
	
	public void change_map(int new_map) {
		currentMap = new_map;
	}
}
