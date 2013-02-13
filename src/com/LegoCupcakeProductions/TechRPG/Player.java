package com.LegoCupcakeProductions.TechRPG;

import com.LegoCupcakeProductions.RPGCupcake.NPC;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	public int x;
	public int y;
	public NPC PlayerNPC;
	
	public Player() {
		x = 20;
		y = 20;
		PlayerNPC = new NPC(x, y, "data/BoyKnight_Moosader.png", 0, 0, 32, 32);
	}
	
	public void draw(SpriteBatch Screen) {
		Screen.draw(PlayerNPC.NPCImgClip, PlayerNPC.x, PlayerNPC.y); 
	}
	
	public void move(int new_x, int new_y) {
		PlayerNPC.x = new_x;
		PlayerNPC.y = new_y;
	}
}
