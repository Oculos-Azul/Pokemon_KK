package br.com.senac.jogoPokemon.item;

import br.com.senac.jogoPokemon.Pokemon;

public class Cura implements Item{
	
	@Override
	public void aplicar(Pokemon pokemon) {
		
		int cura = 15;
		
		// Verificando quanto de cura pode ser aplicada na vida
	    if (pokemon.getVida() < pokemon.getMaxVida()) {
	        // Curando a vida até o máximo, respeitando o limite
	        int vidaRestante = pokemon.getMaxVida() - pokemon.getVida();
	        int curaVida = Math.min(cura, vidaRestante);
	        pokemon.setVida(pokemon.getVida() + curaVida);  // Aumentando a vida
	        cura -= curaVida;  // Subtraindo a cura aplicada à vida
	        System.out.println(pokemon.getNome() + " curou " + curaVida + " de vida!");
	    }

	    // Agora, aplicando a cura restante à defesa
	    if (cura > 0 && pokemon.getDefesa() < pokemon.getMaxDefesa()) {
	        int defesaRestante = pokemon.getMaxDefesa() - pokemon.getDefesa();
	        int curaDefesa = Math.min(cura, defesaRestante);
	        pokemon.setDefesa(pokemon.getDefesa() + curaDefesa);  // Aumentando a defesa
	        System.out.println(pokemon.getNome() + " curou " + curaDefesa + " de defesa!");
	    }
		
	}
}
