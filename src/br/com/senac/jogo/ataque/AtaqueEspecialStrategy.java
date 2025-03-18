package br.com.senac.jogo.ataque;

import br.com.senac.jogo.pokemon.Pokemon;

public class AtaqueEspecialStrategy implements TipoAtaqueStrategy {
	@Override
	public void atacar(Pokemon atacante, Pokemon alvo) {
		System.out.println("\n" + atacante.getNome() + " realizou um ataque ESPECIAL a " + alvo.getNome());
		int ataqueSimples = atacante.getAtaque() + 20;
		alvo.setVida(alvo.getVida() - ataqueSimples);
		System.out.println(" A vida do pokemon " + alvo.getNome() + " Caiu para " + alvo.getVida() + "\n");

	}

}
