package com.codingdojo.pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		Pokemon pokemon1 = new Pokemon("Bulbasour", 25, "Grass");
		Pokemon pokemon2 = new Pokemon("Squirtle", 30, "Water");
		
		Pokedex pokedex = new Pokedex();
		
		pokedex.attackPokemon(pokemon1);
		
		System.out.println(pokedex.pokemonInfo(pokemon1));
		System.out.println(pokedex.pokemonInfo(pokemon2));
	}

}
