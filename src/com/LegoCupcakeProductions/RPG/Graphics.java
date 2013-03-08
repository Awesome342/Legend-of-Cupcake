package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graphics {
	//Class References
	public Player Knight;
	public Enemy Baddies;
	public MapManager Level;
	
	//Variables
	public SpriteBatch Screen;
	
	public Graphics() {
		//Class References
		Knight = new Player();
		Baddies = new Enemy();
		Level = new MapManager();
		
		//Variables
		Screen = new SpriteBatch();
	}
	
	public void draw() {
		Screen.begin();
		Level.draw(Screen, Knight.ImgRect);
		Knight.draw(Screen);
		Baddies.draw(Screen, Level.currentMap);
		Screen.end();
		
		Knight.CheckInput();
		Knight.handleDamage(Baddies);
		Baddies.CheckDamage(Knight.ImgRect, Knight.IsAttacking, Level.currentMap);
	}
}
