package com.codingdojo.zookeeper;

class Mammal {
	public int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println(energyLevel);
		return energyLevel;
	}
	
	
	
}
