package com.codingdojo.objectmaster;

class Human {
	public int strength;
	public int intelligence;
	public int stealth;
	public int health;
	
	public Human(){
		this.strength = 3;
		this.intelligence = 3;
		this.stealth = 3;
		this.health = 100;
	}
	
	public int attack(Human name) {
		name.health = name.health - this.health;
		System.out.println(name.health);
		return name.health;
	}
	
	

}
