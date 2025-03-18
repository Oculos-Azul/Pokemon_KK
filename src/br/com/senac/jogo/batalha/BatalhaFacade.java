package br.com.senac.jogo.batalha;

import br.com.senac.jogo.item.Cura;
import br.com.senac.jogo.item.ItemSingleton;
import br.com.senac.jogo.pokemon.Pokemon;

public class BatalhaFacade {

	public void start(Pokemon pokemon1, Pokemon pokemon2) {
		System.out.println("Iniciando batalha entre " + pokemon1.getNome() + " e " + pokemon2.getNome() + "\n\n");

		// Singleton: Criando uma instancia unica da classe gerenciadora de itens
		ItemSingleton itemSingleton = ItemSingleton.getInstance();

		System.out.println(pokemon1.toString() + "\n");
		System.out.println(pokemon2.toString());

		// Atacando o pokemon 2
		pokemon1.atacar(pokemon2);
		System.out.println("\n" + pokemon2.toString());

		/*
		 * Factory: implementa a logica de evolucao do pokemon, ela foi encapsulada em
		 * uma classe propria para isso, a classe principal apenas passa os parametros
		 * para a classe EvolucaoFactory executar e retornar a proxima evolucao do
		 * pokemon
		 */
		pokemon1.evoluir();

		pokemon2.atacar(pokemon1);
		System.out.println(pokemon1.toString() + "\n");

		itemSingleton.setItem(new Cura());
		itemSingleton.aplicarItem(pokemon1);
		System.out.println(pokemon1.toString() + "\n");

	}
}
