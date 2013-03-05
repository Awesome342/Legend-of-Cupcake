package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graphics {
	//Class References
	public Player Knight;
	public Enemy Baddies;
	public Map Level;
	
	//Variables
	public SpriteBatch Screen;
	
	public Graphics() {
		//Class References
		Knight = new Player();
		Baddies = new Enemy();
		Level = new Map();
		
		//Variables
		Screen = new SpriteBatch();
	}
	
	public void draw() {
		Screen.begin();
		Level.draw(Screen);
		Knight.draw(Screen);
		Baddies.draw(Screen);
		Screen.end();
		
		Knight.CheckInput();
		Knight.handleDamage(Baddies);
		Baddies.CheckDamage(Knight.x, Knight.y, Knight.IsAttacking);
	}
}
