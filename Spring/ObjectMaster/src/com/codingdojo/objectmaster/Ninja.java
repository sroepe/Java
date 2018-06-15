package com.codingdojo.objectmaster;

class Ninja extends Human {
	public Ninja() {
		this.stealth = 10;
	}
	
	public void steal(Human name) {
		name.health -= this.stealth;
		this.health += this.stealth;
		System.out.println("This Human has lost health. Their current health is " + name.health + ".");
		System.out.println("This ninja has gained health.  Their current health is " + this.health);
	}
	
	public void runAway() {
		this.health -= 10;
		System.out.println("This ninja has lost health.  Their current health is " + this.health + ".");
	}
}
