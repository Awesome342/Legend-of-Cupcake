package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy {
	public int x;
	public int y;
	public int w;
	public int h;
	public int frame;
	public int direction;
	public int health;
	public boolean IsAlive;
	public Texture Img;
	public TextureRegion ImgClip;
	
	public Enemy() {
		x = 500;
		y = 50;
		w = 32;
		h = 32;
		frame = 0;
		direction = 0;
		health = 100;
		IsAlive = true;
		Img = new Texture("data/Enemy1_Moosader.png");
		ImgClip = new TextureRegion(Img, frame * w, direction * h, w, h);
	}
	
	public boolean Collide(int s1x, int s2x, int s1y, int s2y) {
		if (s1x > s2x - 32 && s1x < s2x + 32 && s1y > s2y - 32 && s1y < s2y + 32) {
			return true;
		} else {
			return false;
		}
	}
	
	public void draw(SpriteBatch Screen) {
		if (IsAlive == true) {
			Screen.draw(ImgClip, x, y);
		}
	}
	
	public void CheckDamage(int X, int Y, boolean IsAttacking) {
		if (Collide(x, X, y, Y) && IsAttacking == true) {
			health -= 1;
			System.out.println(health);
		}
		if (health < 0) {
			IsAlive = false;
		}
	}
	

}
