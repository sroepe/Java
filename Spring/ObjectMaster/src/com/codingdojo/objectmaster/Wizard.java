package com.codingdojo.objectmaster;

class Wizard extends Human {
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	
	public void heal(Human name) {
		name.health += this.intelligence;
		System.out.println(name.health);
	}
	
	public void fireball(Human name) {
		name.health -= this.intelligence * 3;
		System.out.println(name.health);
	}
}
