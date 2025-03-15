package br.com.senac.jogoPokemon;

import Enum.Evolucao;
import br.com.senac.jogoPokemon.item.Cura;
import br.com.senac.jogoPokemon.item.Dano;
import br.com.senac.jogoPokemon.item.ItemSingleton;

public class Main {
	public static void main(String[] args) {
		
		// Design para implementar:
		// 1 - Singleton: Esse design tem a funcao de centralizar a instancia de uma classe em apenas uma,
		//	   assim alterando apenas o estado dessa instancia
		
		// 	   implementacao: retirei o methodo da instanciava um ITEM dentro da classe POKEMON, e criei a
		//     classe itemSingleton que funciona independente da classe POKEMON, assim eu posso instanciar um item (por default CURA)
		//     e caso queira mudar o estado do item eu uso o setItem para alterar o item para algum outro. Apos isso executo o methodo
		//     aplicar item para poder alterar os atributos do pokemon passado como parametro
		
		// 2 - Factory: Esse design tem como funcao separar a "regra de negocio" da classe principal, assim 
		// 3 - Strategy 
		// 4 - Composite
		// 5 - Facade 

		// 
		Pokemon charmander = new Pokemon("fogo", 100, 60, 50, 0,  Evolucao.CHARMANDER);
		Pokemon bulbasauro = new Pokemon("planta", 100, 20, 50, 0,  Evolucao.BULBASAURO);
		
		// Singleton: Criando uma instancia unica da classe gerenciadora de itens
		ItemSingleton itemSingleton = ItemSingleton.getInstance();

        System.out.println(charmander);
        charmander.evoluir();
        System.out.println(charmander.toString());
        
        charmander.atacar(bulbasauro);
        
        System.out.println(bulbasauro);
        
        itemSingleton.setItem(new Dano());
        itemSingleton.aplicarItem(bulbasauro);
        
        bulbasauro.atacar(charmander);
        System.out.println(charmander);

        

	}
}
 	