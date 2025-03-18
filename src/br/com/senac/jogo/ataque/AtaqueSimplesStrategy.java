package br.com.senac.jogo.ataque;

import br.com.senac.jogo.pokemon.Pokemon;

public class AtaqueSimplesStrategy implements TipoAtaqueStrategy {

	@Override
	public void atacar(Pokemon atacante, Pokemon alvo) {
		System.out.println(atacante.getNome() + " realizou um ataque SIMPLES a " + alvo.getNome());
		int ataqueSimples = atacante.getAtaque();
		alvo.setVida(alvo.getVida() - ataqueSimples);
		System.out.println(" A vida do pokemon " + alvo.getNome() + " Caiu para " + alvo.getVida());

	}

}
