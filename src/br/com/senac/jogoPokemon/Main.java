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
		
		// 2 - Factory: Esse design tem como funcao separar a "regra de negocio" da classe principal, assim afastando a logida do usuario
		
		//	   implementacao: fiz a validacao da evolucao do pokemom atraves de um enum que tem a linha evolucional do pokemon, 
		//	   apos isso criei o metodo evolucaoFactory que vai gerenciar a evolucao do pokemon, nao permitindo que ele pule 
		//	   etapas da evolucao ou evolua para uma forma que nao existe;
		
		// 3 - Strategy: Esse design aplica conceito de abstracao de classes, ele prega o principio da funcao unica, ou seja
		//     se eu posso criar uma classe para que essa classe seja responsavel para fazer um calculo expecifico, devo criar.
		//    	
		//	   implementacao: criei uma interface chamada ataqueEspecialStrategy para 
		//     abstrar o atributo ataque para que o pokemom possa ter dois tipos de ataques, os ataquesSimples e os AtaquesEspeciais
		//	   dessa maneira caso queiram inserir novos tipos de ataques nos pokemons, poderam fazer isso sem mexer nos tipos de ataque ja existentes
		// 4 - Composite
		// 5 - Facade 

		//Strategy: a instancia AtaqueSimplesStrategy realiza apenas o ataque com o valor do atriburo dano.
		// ja a instancia AtaqueEspecialStrategy realiza a multiplicacao por 2 desse valor do ataque, assim causando mais dano
		Pokemon charmander = new Pokemon("fogo", 100, 30, 50, 0, new AtaqueSimplesStrategy(),  Evolucao.CHARMANDER);
		Pokemon bulbasauro = new Pokemon("planta", 100, 20, 50, 0, new AtaqueEspecialStrategy(), Evolucao.BULBASAURO);
		
		// Singleton: Criando uma instancia unica da classe gerenciadora de itens
		ItemSingleton itemSingleton = ItemSingleton.getInstance();

		
        System.out.println(charmander);
        charmander.evoluir();
        System.out.println(charmander.toString());
        
        
        bulbasauro.atacar(charmander);
        System.out.println(charmander.toString());

        itemSingleton.setItem(new Cura());
        itemSingleton.aplicarItem(charmander);
        System.out.println(charmander.toString());

	}
}
 	