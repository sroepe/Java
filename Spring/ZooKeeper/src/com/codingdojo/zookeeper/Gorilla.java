package com.codingdojo.zookeeper;

class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("The gorilla just threw something:/");
		this.energyLevel = energyLevel - 5;
	}
	
	public void eatBananas() {
		System.out.println("The gorilla is happily feasting on bananas!");
		this.energyLevel = energyLevel + 10;
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree.");
		this.energyLevel = energyLevel - 10;
	}
}
