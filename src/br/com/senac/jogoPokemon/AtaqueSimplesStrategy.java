package br.com.senac.jogoPokemon;

import Enum.TipoAtaqueStrategy;

public class AtaqueSimplesStrategy implements TipoAtaqueStrategy{

	@Override
	public void atacar(Pokemon atacante, Pokemon alvo) {
        System.out.println(atacante.getNome() + " realizou um ataque SIMPLES " + alvo.getNome());
		int ataqueSimples = atacante.getAtaque();
		alvo.setVida(alvo.getVida() - ataqueSimples);
        System.out.println(" A vida do pokemon "+ alvo.getNome() + " Caiu para " + alvo.getVida());

	}
 
	
	
}
