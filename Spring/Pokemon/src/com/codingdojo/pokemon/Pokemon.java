package com.codingdojo.pokemon;

class Pokemon {
	public String name;
	public int health = 0;
	public String type;
	
	public static int counter;
	
	public Pokemon(String name, int health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
		counter++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static int getCount() {
		return counter;
	}
	
	public static void setCount(int counter) {
		Pokemon.counter = counter;
		System.out.println(counter);
	}
	

	public Pokemon pokemonInfo(Pokemon pokemon) {
				
		System.out.println(pokemon.name + " " + Integer.toString(pokemon.health) + " " + pokemon.type);
		return pokemon;
		
	}

}
