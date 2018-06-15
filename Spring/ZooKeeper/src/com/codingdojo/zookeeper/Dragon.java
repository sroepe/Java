package com.codingdojo.zookeeper;

class Dragon extends Mammal {
	public Dragon() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Squawcawwwwwwwwwwwww.  Raaaaaaaaaaaaaawwwwwwwwwrrrrrrrr");
		this.energyLevel = energyLevel - 50;
	}
	
	public void eatHumans() {
		this.energyLevel = energyLevel + 25;
	}
	
	public void attackTown() {
		System.out.println("Crackle crackle, wooooooooooo, woo, woo, woo, woo, crackle");
		this.energyLevel = energyLevel - 100;
	}

}
