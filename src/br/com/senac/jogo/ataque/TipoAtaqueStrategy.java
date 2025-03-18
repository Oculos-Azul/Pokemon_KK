package br.com.senac.jogo.ataque;

import br.com.senac.jogo.pokemon.Pokemon;

public interface TipoAtaqueStrategy {
	void atacar(Pokemon atacante, Pokemon alvo);

}
