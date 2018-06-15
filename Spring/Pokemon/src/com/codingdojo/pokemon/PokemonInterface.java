package com.codingdojo.pokemon;


public interface PokemonInterface {
	void createPokemon(String name, int health, String type);
	
	void attackPokemon(Pokemon pokemon);
	
	String pokemonInfo(Pokemon pokemon);

}
