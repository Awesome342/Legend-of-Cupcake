package com.LegoCupcakeProductions.TechRPG;

import com.LegoCupcakeProductions.RPGCupcake.Charector;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graphics {
	public Map Level;
	SpriteBatch Screen;
	private Charector Player;
	
	public Graphics() {
		Level = new Map();
		Screen = new SpriteBatch();
		Player = new Charector(20, 200, 32, 32, 0, 0, "data/BoyKnight_Moosader.png");
	}
	
	public void get_input() {
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			Player.x += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			Player.x -= 5;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			Player.y += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			Player.y -= 5;
		}
	}
	
	public void draw() {
		get_input();
		Level.update(Player.x, Player.y);
		
		Screen.begin();
		Level.draw(Screen);
		Screen.draw(Player.ImgClip, Player.x, Player.y);
		Screen.end();
	}
	
	public void move_player(int x, int y) {
		Player.x = x;
		Player.y = y;
	}
}
