package com.LegoCupcakeProductions.TechRPG;

public class Physics {
	public int currentMap = 1;
	
	public int UpdateX(int x) {
		if (currentMap == 1 && x < 0) {
			return 992;
		} else {
			return 0;
		}
	}
	
	public int UpdateY(int currentMap, int y) {
		return 0;
	}
}
