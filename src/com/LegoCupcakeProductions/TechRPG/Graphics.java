package com.LegoCupcakeProductions.TechRPG;

import com.LegoCupcakeProductions.RPGCupcake.Charector;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graphics {
	public Map Level;
	SpriteBatch Screen;
	private Player Knight;
	
	public Graphics() {
		Level = new Map();
		Screen = new SpriteBatch();
		Knight = new Player();
	}
	
	public void draw() {
		Knight.get_input();
		Level.update(Knight.PlayerNPC.x, Knight.PlayerNPC.y);
		
		Screen.begin();
		Level.draw(Screen);
		Knight.updatePOS();
		Knight.draw(Screen);
		Screen.end();
	}
}
