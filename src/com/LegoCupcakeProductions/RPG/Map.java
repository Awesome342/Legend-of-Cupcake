package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	public Texture Map1;
	
	public Map() {
		Map1 = new Texture("data/Village1.png");
	}
	
	public void draw(SpriteBatch Screen) {
		Screen.draw(Map1, 0, 0);
	}
}
