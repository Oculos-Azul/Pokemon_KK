package br.com.senac.jogoPokemon.item;

 import br.com.senac.jogoPokemon.Pokemon;

public class Dano implements Item{

	@Override
	public void aplicar(Pokemon pokemon) {
		pokemon.setAtaque(pokemon.getAtaque() + 15);
		System.out.println(pokemon.getNome() + " usou a poção de dano! " + 
		"Agora o ataque " + pokemon.getNome() + " tem dano " + pokemon.getAtaque());
	}
	
}
