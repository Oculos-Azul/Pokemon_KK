package br.com.senac.jogo;

import br.com.senac.jogo.ataque.AtaqueEspecialStrategy;
import br.com.senac.jogo.ataque.AtaqueSimplesStrategy;
import br.com.senac.jogo.batalha.BatalhaFacade;
import br.com.senac.jogo.evolucao.Evolucao;
import br.com.senac.jogo.pokemon.Pokemon;
import br.com.senac.jogo.tipo.TipoGramaComposite;
import br.com.senac.jogo.tipo.TiposSimples;

public class Main {
	public static void main(String[] args) {

		/*
		 * Design para implementar: 1 - Singleton: Esse design tem a funcao de
		 * centralizar a instancia de uma classe em apenas uma, assim alterando apenas o
		 * estado dessa instancia
		 * 
		 * implementacao: retirei o methodo da instanciava um ITEM dentro da classe
		 * POKEMON, e criei a classe itemSingleton que funciona independente da classe
		 * POKEMON, assim eu posso instanciar um item (por default CURA) e caso queira
		 * mudar o estado do item eu uso o setItem para alterar o item para algum outro.
		 * Apos isso executo o methodo aplicar item para poder alterar os atributos do
		 * pokemon passado como parametro
		 * 
		 * 2 - Factory: Esse design tem como funcao separar a "regra de negocio" da
		 * classe principal, assim afastando a logida do usuario
		 * 
		 * implementacao: fiz a validacao da evolucao do pokemom atraves de um enum que
		 * tem a linha evolucional do pokemon, apos isso criei o metodo evolucaoFactory
		 * que vai gerenciar a evolucao do pokemon, nao permitindo que ele pule etapas
		 * da evolucao ou evolua para uma forma que nao existe;
		 * 
		 * 3 - Strategy: Esse design aplica conceito de abstracao de classes, ele prega
		 * o principio da funcao unica, ou seja se eu posso criar uma classe para que
		 * essa classe seja responsavel para fazer um calculo expecifico, devo criar.
		 * 
		 * implementacao: criei uma interface chamada ataqueEspecialStrategy para
		 * abstrar o atributo ataque para que o pokemom possa ter dois tipos de ataques,
		 * os ataquesSimples e os AtaquesEspeciais dessa maneira caso queiram inserir
		 * novos tipos de ataques nos pokemons, poderam fazer isso sem mexer nos tipos
		 * de ataque ja existentes
		 * 
		 * 4 - Composite: esse design funciona aplicando alguns conceitos de heranca,
		 * pois podemos criar uma interface que vai se implementada em dua classes, uma
		 * que sera uma classe unica, e outra classe que contera outras classes
		 * subjacente ou ate mesmo listas dentro dela
		 * 
		 * implementacao: criei uma interface TipoPokemon e seu methodo padrao seria o
		 * tipo(Pokemon pokemon) que e implementada em duas classes subjacentes, sendo
		 * uma TipoSimples que apenas retorna o tipo do pokemon, e uma
		 * TipoGramaComposite, que possui um arrayList dentro dela onde podemos
		 * adicionar novas subclasses do pokemon.
		 * 
		 * 5 - Facade: serve basicamente como um Controler, e la que serao chamados os
		 * methodos para serem executados posteriormente na classe principal
		 * 
		 * implementacao: criei a classe batalhaFacade que serve para apenas executar as
		 * funcoes de combate dos pokemons, seja um ataque, a utilizacao de algum item,
		 * uma evolucao.
		 */

		/*
		 * Composite: instanciando uma classe TipoSimples para o pokemon possuir apenas
		 * um tipo
		 */
		TiposSimples tipoFogo = new TiposSimples("Fogo");

		/*
		 * Composite: instanciando uma classe TipoGramaComposite para que possamos
		 * passsar um tipo e subtipos para o pokemon
		 */
		TipoGramaComposite tipoGramaComposto = new TipoGramaComposite("Grama");
		tipoGramaComposto.adicionaSubtipo(new TiposSimples("veneno"));
		tipoGramaComposto.adicionaSubtipo(new TiposSimples("Grama"));

		/*
		 * Strategy: a instancia AtaqueSimplesStrategy realiza apenas o ataque com o
		 * valor do atriburo dano.
		 */
		/*
		 * ja a instancia AtaqueEspecialStrategy realiza a multiplicacao por 2 desse
		 * valor do ataque, assim causando mais dano
		 */
		Pokemon charmander = new Pokemon(tipoFogo, 100, 30, 50, 0, new AtaqueSimplesStrategy(), Evolucao.CHARMANDER);
		Pokemon bulbasauro = new Pokemon(tipoGramaComposto, 100, 20, 50, 0, new AtaqueEspecialStrategy(),
				Evolucao.BULBASAURO);

		/*
		 * Facade: basicamente criei uma classe a parte para apenas poder executar as
		 * tarefas da batalha para que o usuario nao saiba como funciona
		 */
		BatalhaFacade batalha = new BatalhaFacade();
		batalha.start(charmander, bulbasauro);

	}
}
