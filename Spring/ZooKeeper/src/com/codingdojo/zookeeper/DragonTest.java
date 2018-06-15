package com.codingdojo.zookeeper;

class DragonTest {

	public static void main(String[] args) {
		Dragon zoldar = new Dragon();
		
		zoldar.attackTown();
		zoldar.displayEnergy();
		zoldar.attackTown();
		zoldar.displayEnergy();
		zoldar.attackTown();
		zoldar.displayEnergy();
		zoldar.eatHumans();
		zoldar.displayEnergy();
		zoldar.eatHumans();
		zoldar.displayEnergy();
		zoldar.fly();
		zoldar.displayEnergy();
		zoldar.fly();
		zoldar.displayEnergy();
	}

}
