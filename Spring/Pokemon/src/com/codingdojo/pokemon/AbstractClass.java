package com.codingdojo.pokemon;

public abstract class AbstractClass implements PokemonInterface {
	 public void createPokemon(String name, int health, String type) {
		
		System.out.println("Pokemon " + name + " is of type " + type + " and has " + health + " health.");
	}
	
	public void attackPokemon(Pokemon pokemon) {
		pokemon.health -= 10;
		
		System.out.println(pokemon.name + " was attacked by another Pokemon and lost 10 health. " + pokemon.name + "'s health is now " + pokemon.health + ".");
	}
}
