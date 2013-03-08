package com.LegoCupcakeProductions.RPG;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy {
	public Random rand;
	public int x;
	public int y;
	public int w;
	public int h;
	public Rect ImgRect;
	public int frame;
	public int direction;
	public int health;
	public boolean IsAlive;
	public boolean CanAttack;
	public Texture Img;
	public TextureRegion ImgClip;

	
	public Enemy() {
		rand = new Random();
		x = rand.nextInt(900);
		y = rand.nextInt(480);
		w = 32;
		h = 32;
		ImgRect = new Rect(x, y, w, h);
		frame = 0;
		direction = 0;
		health = 100;
		IsAlive = true;
		CanAttack = false;
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
	
	public void updateStuff(int currentMap) {
		if (currentMap == 0) {
			CanAttack = true;
		} else {
			CanAttack = false;
		}
	}
	
	public void draw(SpriteBatch Screen, int currentMap) {
		if (currentMap == 0) {
			if (IsAlive == true) {
				Screen.draw(ImgClip, x, y);
			}
		}
	}
	
	public void CheckDamage(Rect Player, boolean IsAttacking, int currentMap) {
		if (currentMap == 0) {
			if (Collide(x, Player.x, y, Player.y) && IsAttacking == true) {
				health -= 1;
				System.out.println(health);
			}
			if (health < 0) {
				IsAlive = false;
			}
		}
	}
}
