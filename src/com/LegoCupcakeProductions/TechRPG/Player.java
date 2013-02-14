package com.LegoCupcakeProductions.TechRPG;

import com.LegoCupcakeProductions.RPGCupcake.NPC;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	public int x;
	public int y;
	public NPC PlayerNPC;
	public Physics Phys;
	
	public Player() {
		x = 20;
		y = 20;
		PlayerNPC = new NPC(x, y, "data/BoyKnight_Moosader.png", 0, 0, 32, 32);
		Phys = new Physics();
	}
	
	public void draw(SpriteBatch Screen) {
		Screen.draw(PlayerNPC.NPCImgClip, PlayerNPC.x, PlayerNPC.y); 
	}
	
	public void ChangePOS(int new_x, int new_y) {
		PlayerNPC.x = new_x;
		PlayerNPC.y = new_y;
	}
	
	public void move(String dir) {
		if (dir.equals("RIGHT")) {
			PlayerNPC.x += 5;
		} else if (dir.equals("LEFT")) {
			PlayerNPC.x -= 5;
		}
		if (dir.equals("UP")) {
			PlayerNPC.y += 5;
		} else if (dir.equals("DOWN")) {
			PlayerNPC.y -= 5;
		}
	}
	
	public void get_input() {
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			PlayerNPC.x += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			PlayerNPC.x -= 5;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			PlayerNPC.y += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			PlayerNPC.y -= 5;
		}
	}
	
	public void updatePOS() {
		if (Phys.UpdateX(PlayerNPC.x) != 0) {
			PlayerNPC.x = Phys.UpdateX(PlayerNPC.x);
		}
	}
}
