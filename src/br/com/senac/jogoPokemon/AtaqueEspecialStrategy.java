package br.com.senac.jogoPokemon;

import Enum.TipoAtaqueStrategy;

public class AtaqueEspecialStrategy implements TipoAtaqueStrategy{
	@Override
	public void atacar(Pokemon atacante, Pokemon alvo) {
        System.out.println(atacante.getNome() + " realizou um ataque especial " + alvo.getNome());
		int ataqueSimples = atacante.getAtaque() + 20;
		alvo.setVida(alvo.getVida() - ataqueSimples);
        System.out.println(" A vida do pokemon "+ alvo.getNome() + " Caiu para " + alvo.getVida());

	}
 
	
}
