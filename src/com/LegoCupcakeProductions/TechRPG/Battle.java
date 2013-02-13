package com.LegoCupcakeProductions.TechRPG;

import com.LegoCupcakeProductions.RPGCupcake.NPC;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Battle {
	public boolean IsBattle;
	
	public Battle() {
		IsBattle = false;
	}
	
	public void StartBattle(NPC Player, NPC npc) {
		if (IsBattle == true) {
			if (Gdx.input.isKeyPressed(Keys.A)) {
				Player.Attack("PLAYER ATTACKED!!!");
				npc.BeAttacked("NPC HURT!!!");
				npc.update();
				if (npc.decision == 0) {
					npc.Attack("NPC ATTACKED!!");
					Player.BeAttacked("PLAYER HURT!!!");
				} else if (npc.decision == 1) {
					npc.Run("NPC RAN AWAY!");
					IsBattle = false;
				} else if (npc.decision == 2) {
					npc.Run("NPC RAN AWAY!!");
					IsBattle = false;
				}
			} else if (Gdx.input.isKeyPressed(Keys.S)) {
				Player.Run("RAN AWAY!");
				IsBattle = false;
			}
		}
	}
}
