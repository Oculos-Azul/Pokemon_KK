package br.com.senac.jogo.evolucao;

public enum Evolucao {
	CHARMANDER("Charmander", null), // Não tem evolução anterior
	CHARMILION("Charmeleon", CHARMANDER), CHARIZARD("Charizard", CHARMILION),

	BULBASAURO("Bulbasauro", null), // Não tem evolução anterior
	IVYSAURO("Ivysauro", BULBASAURO), VENOSAURO("Venosauro", IVYSAURO);

	private final String nome;
	private final Evolucao evolucaoAnterior;

	// Construtor para cada valor do enum
	Evolucao(String nome, Evolucao evolucaoAnterior) {
		this.nome = nome;
		this.evolucaoAnterior = evolucaoAnterior;
	}

	public Evolucao getProximaEvolucao() {
		if (this == CHARIZARD || this == VENOSAURO) {
			return null;
		}
		return Evolucao.values()[this.ordinal() + 1]; // Retorna o próximo valor do enum
	}

	public String getNome() {
		return nome;
	}

	public Evolucao getEvolucaoAnterior() {
		return evolucaoAnterior;
	}
}
