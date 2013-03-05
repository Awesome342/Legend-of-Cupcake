package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

//DON'T REFERENCE THIS IN ANYTHING EXCEPT GRAPHICS!!

public class Player {
	public int x;
	public int y;
	public int w;
	public int h;
	public int frame;
	public int direction;
	public int health;
	public boolean IsAttacking;
	public boolean IsAlive;
	public Texture Img;
	public TextureRegion ImgClip;
	public Hud HealthHud;
	
	public Player() {
		x = 0;
		y = 0;
		w = 32;
		h = 32;
		frame = 0;
		direction = 0;
		health = 196;
		IsAttacking = false;
		IsAlive = false;
		Img = new Texture("data/Knight3.png");
		ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
		HealthHud = new Hud();
	}
	
	public boolean Collide(int s1x, int s2x, int s1y, int s2y) {
		if (s1x > s2x - 32 && s1x < s2x + 32 && s1y > s2y - 32 && s1y < s2y + 32) {
			return true;
		} else {
			return false;
		}
	}
	
	public void CheckInput() {
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= 5;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			y += 5;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			y -= 5;
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			IsAttacking = true;
			frame = 4;
			ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			IsAttacking = false;
			frame = 0;
			ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
		}
	}
	
	public void handleDamage(Enemy Baddie) {
		if (Baddie.IsAlive == true) {
			if (Collide(x, Baddie.x, y, Baddie.y) && IsAttacking == false) {
				health -= 1;
			}
			if (health < 0) {
				System.out.println("PLAYER IS DEAD");
			}
		}
	}
	
	public void draw(SpriteBatch Screen) {
		Screen.draw(ImgClip, x, y);
		HealthHud.draw(Screen, health);
	}
}
