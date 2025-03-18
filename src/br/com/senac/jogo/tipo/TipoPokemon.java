package br.com.senac.jogo.tipo;

import br.com.senac.jogo.pokemon.Pokemon;

public interface TipoPokemon {
	void tipo(Pokemon pokemon);

	String getTipo();
}
