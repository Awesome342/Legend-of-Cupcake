package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hud {
	public Texture HealthBarHolder_Img;
	public Texture HealthBar_Img;
	public TextureRegion HealthBarHolder_Clip;
	public TextureRegion HealthBar_Clip;
	
	public Hud() {
		HealthBar_Img = new Texture("data/enemy_health_bar_000.png");
		HealthBarHolder_Img = new Texture("data/enemy_health_bar_foreground_000.png");
		HealthBarHolder_Clip = new TextureRegion(HealthBarHolder_Img, 48, 0, 48, 16);
		HealthBar_Clip = new TextureRegion(HealthBar_Img, 48, 16, 48, 16);
	}
	
	public void draw(SpriteBatch Screen, int health) {
		Screen.draw(HealthBar_Img, health -= 196, 448);
		Screen.draw(HealthBarHolder_Img, 0, 448);
	}
}
