package com.LegoCupcakeProductions.RPG;

import com.badlogic.gdx.graphics.Texture;

public class Map {
	public Texture Img;
	public Rect Object1;
	public Rect Object2;
	public Rect Object3;
	public Rect Object4;
	public Rect Warp1;
	public Rect Warp2;
	public Rect Warp3;
	public Rect Warp4;
	
	public Map(String filename, Rect Object1, Rect Object2, Rect Object3, Rect Object4, Rect Warp1, Rect Warp2, Rect Warp3, Rect Warp4) {
		Img = new Texture(filename);
		this.Object1 = Object1;
		this.Object2 = Object2;
		this.Object3 = Object3;
		this.Object4 = Object4;
		this.Warp1 = Warp1;
		this.Warp2 = Warp2;
		this.Warp3 = Warp3;
		this.Warp4 = Warp4;
	}
	
	public boolean Collide(Rect A, Rect B) {
		if (A.x < B.x + B.w && A.x + A.w > B.x && A.y < B.y + B.h && A.y + A.h	> B.y) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateObject1(Rect Player) {
		if (Collide(Player, Object1)) {
			return true;
		}
		return false;
	}
	
	public boolean updateObject2(Rect Player) {
		if (Collide(Player, Object2)) {
			return true;
		}
		return false;
	}
	
	public boolean updateObject3(Rect Player) {
		if (Collide(Player, Object3)) {
			return true;
		}
		return false;
	}
	
	public boolean updateObject4(Rect Player) {
		if (Collide(Player, Object4)) {
			return true;
		}
		return false;
	}
	
	public boolean updateWarp1(Rect Player) {
		if (Collide(Player, Warp1)) {
			return true;
		}
		return false;
	}
	
	public boolean updateWarp2(Rect Player) {
		if (Collide(Player, Warp2)) {
			return true;
		}
		return false;
	}
	
	public boolean updateWarp3(Rect Player) {
		if (Collide(Player, Warp3)) {
			return true;
		}
		return false;
	}
	
	public boolean updateWarp4(Rect Player) {
		if (Collide(Player, Warp4)) {
			return true;
		}
		return false;
	}
}
