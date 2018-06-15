package com.codingdojo.objectmaster;

class Samurai extends Human {
	private static int counter;
	
	public Samurai() {
		this.health = 200;
		counter ++;
	}
	
	public void deathBlow(Human name) {
		name.health = 0;
		this.health -= this.health / 2;
		System.out.println("This Human has died.  They have " + name.health + "current health.");
		System.out.println("This Samurai has lost half their health.  Their current health is " + this.health + ".");
	}
	
	public void meditate() {
		this.health += this.health / 2;
		System.out.println("This Samurai meditated and gained half of their health.  Their current health is " + this.health + ".");
	}
	
	public static int howMany() {
		System.out.println("There are currently " + counter + " Samurai.");
		return counter;
	}
}
