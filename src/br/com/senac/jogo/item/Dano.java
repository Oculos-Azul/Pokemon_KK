package br.com.senac.jogo.item;

import br.com.senac.jogo.pokemon.Pokemon;

public class Dano implements Item {

	@Override
	public void aplicar(Pokemon pokemon) {
		pokemon.setAtaque(pokemon.getAtaque() + 15);
		System.out.println(pokemon.getNome() + " usou a poção de dano! " + "Agora o ataque " + pokemon.getNome()
				+ " tem dano " + pokemon.getAtaque());
	}

}
