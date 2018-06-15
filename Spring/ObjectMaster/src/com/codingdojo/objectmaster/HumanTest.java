package com.codingdojo.objectmaster;

class HumanTest {

	public static void main(String[] args) {
		Human George = new Human();
		Human Simon = new Human();
		
		Wizard Harry = new Wizard();
		
		Ninja Sensei = new Ninja();
		
		Samurai Nick = new Samurai();
		Samurai Frank = new Samurai();
		Samurai Kenji = new Samurai();
		
//		Simon.attack(George);
		
//		Harry.heal(George);
//		Harry.fireball(George);
		
//		Sensei.steal(Simon);
//		Sensei.runAway();

		Nick.deathBlow(Harry);
		
		Samurai.howMany();	
	}

}
