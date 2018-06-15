package com.codingdojo.pokemon;

class Pokedex extends AbstractClass {

	public String pokemonInfo(Pokemon pokemon) {
		
		return "Name " + pokemon.getName() + " , Type: " + pokemon.getType() + " , Health: " + pokemon.getHealth();
	}

	

}
