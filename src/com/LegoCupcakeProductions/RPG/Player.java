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
	public Rect ImgRect;
	public int frame;
	public int direction;
	public int health;
	public boolean IsAttacking;
	public boolean IsAlive;
	public Texture Img;
	public TextureRegion ImgClip;
	public Hud HealthHud;
	public MapManager Level;
	
	public Player() {
		x = 50;
		y = 500;
		w = 32;
		h = 32;
		ImgRect = new Rect(50, 500, 32, 32);
		frame = 0;
		direction = 0;
		health = 196;
		IsAttacking = false;
		IsAlive = false;
		Img = new Texture("data/Knight3.png");
		ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
		HealthHud = new Hud();
		Level = new MapManager();
	}
	
	public boolean Collide(Rect A, Rect B) {
		if (A.x < B.x + B.w && A.x + A.w > B.x && A.y < B.y + B.h && A.y + A.h	> B.y) {
			return true;
		} else {
			return false;
		}
	}
	
	public void CheckInput() {
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			ImgRect.x += 5;
			direction = 3;
			ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
		}
		else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			ImgRect.x -= 5;
			direction = 2;
			ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
		}
		else if (Gdx.input.isKeyPressed(Keys.UP)) {
			ImgRect.y += 5;
			direction = 1;
			ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			ImgRect.y -= 5;
			direction = 0;
			ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
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
			if (Collide(ImgRect, Baddie.ImgRect) && IsAttacking == false) {
				health -= 1;
			}
			if (health < 0) {
				System.out.println("PLAYER IS DEAD");
			}
		}
	}
	
	
	public void updateObjects(Rect Object) {
		//BigHouse
		
		if (Collide(ImgRect, Object)) {
			if (direction == 3) {
				ImgRect.x -= 5;
			} else if (direction == 2) {
				ImgRect.x += 5;
			} else if (direction == 1) {
				ImgRect.y -= 5;
			} else if (direction == 0) {
				ImgRect.y += 5;
			}
		}
		
	}
	
	public void draw(SpriteBatch Screen) {
		Screen.draw(ImgClip, ImgRect.x, ImgRect.y);
		HealthHud.draw(Screen, health);
	}
}
